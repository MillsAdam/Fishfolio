package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Fish;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFishDao implements FishDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcFishDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Fish> getFish() {
        List<Fish> fishList = new ArrayList<>();
        String sql = "SELECT * FROM fish_inventory ORDER BY fish_id";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                fishList.add(mapRowToFish(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }

        return fishList;
    }

    @Override
    public Fish getFishById(int fishId) {
        Fish fish = null;
        String sql = "SELECT * FROM fish_inventory WHERE fish_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, fishId);
            if (results.next()) {
                fish = mapRowToFish(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }

        return fish;
    }

    @Override
    public List<Fish> getFishByType(String type) {
        List<Fish> fishList = new ArrayList<>();
        String sql = "SELECT * FROM fish_inventory WHERE type = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, type);
            while (results.next()) {
                fishList.add(mapRowToFish(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }

        return fishList;
    }

    @Override
    public List<Fish> getFishByLocation(String location) {
        List<Fish> fishList = new ArrayList<>();
        String sql = "SELECT * FROM fish_inventory WHERE location = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, location);
            while (results.next()) {
                fishList.add(mapRowToFish(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }

        return fishList;
    }

    @Override
    public Fish createFish(Fish fish) {
        Fish newFish = null;
        String fishSql = "INSERT INTO fish_inventory (" +
                "name, type, length, weight, " +
                "location, lure_used, date_caught, image_url) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING fish_id";
        String trackingHistorySql = "" +
                "INSERT INTO fish_tracking_history (" +
                "fish_id, recorded_date, recorded_length, recorded_weight) " +
                "VALUES (?, ?, ?, ?) " +
                "RETURNING tracking_history_id;";

        try {
            int fishId = jdbcTemplate.queryForObject(fishSql, int.class,
                    fish.getName(), fish.getType(),
                    fish.getLength(), fish.getWeight(),
                    fish.getLocation(), fish.getLureUsed(),
                    fish.getDateCaught(), fish.getImageUrl());
            int trackingHistoryId = jdbcTemplate.queryForObject(trackingHistorySql, int.class,
                    fishId, fish.getDateCaught(),
                    fish.getLength(), fish.getWeight());
            newFish = getFishById(fishId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return newFish;
    }

    @Override
    public Fish updateFish(Fish fish) {
        Fish updatedFish = null;
        String fishSql = "UPDATE fish_inventory " +
                "SET " +
                "name = ?, type = ?, " +
                "length = ?, weight = ?, " +
                "location = ?, lure_used = ?, " +
                "date_caught = ?, image_url = ? " +
                "WHERE fish_id = ?";
        String trackingHistorySql = "UPDATE fish_tracking_history " +
                "SET " +
                "recorded_date = ?, recorded_length = ?, recorded_weight = ? " +
                "WHERE fish_id = ? AND " +
                "recorded_date = (" +
                    "SELECT MIN(recorded_date) " +
                    "FROM fish_tracking_history " +
                    "WHERE fish_id = ?)";

        try {
            int rowsAffected = jdbcTemplate.update(fishSql,
                    fish.getName(), fish.getType(),
                    fish.getLength(), fish.getWeight(),
                    fish.getLocation(), fish.getLureUsed(),
                    fish.getDateCaught(), fish.getImageUrl(),
                    fish.getFishId());
            if (rowsAffected == 0) {
                throw new DaoException("Zero rows affected, expected at least one.");
            }

            jdbcTemplate.update(trackingHistorySql,
                    fish.getDateCaught(), fish.getLength(), fish.getWeight(),
                    fish.getFishId(), fish.getFishId());

            updatedFish = getFishById(fish.getFishId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return updatedFish;
    }

    @Override
    public int deleteFishById(int fishId) {
        int numberOfRows = 0;
        String trackingHistorySql = "DELETE FROM fish_tracking_history WHERE fish_id = ?";
        String fishSql = "DELETE FROM fish_inventory WHERE fish_id = ?";

        try {
            numberOfRows = jdbcTemplate.update(trackingHistorySql, fishId);
            numberOfRows = jdbcTemplate.update(fishSql, fishId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return numberOfRows;
    }

    @Override
    public List<Fish> getFishByMostRecent() {
        List<Fish> fishList = new ArrayList<>();
        String sql = "SELECT * FROM fish_inventory " +
                "ORDER BY date_caught DESC";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                fishList.add(mapRowToFish(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }

        return fishList;
    }

    @Override
    public List<Fish> getFishByOldest() {
        List<Fish> fishList = new ArrayList<>();
        String sql = "SELECT * FROM fish_inventory " +
                "ORDER BY date_caught ASC";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                fishList.add(mapRowToFish(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }

        return fishList;
    }

    @Override
    public List<Fish> getFishByMostPopular() {
        List<Fish> fishList = new ArrayList<>();
        String sql = "" +
                "SELECT " +
                    "fi.fish_id, " +
                    "fi.name, " +
                    "fi.type, " +
                    "fi.length, " +
                    "fi.weight, " +
                    "fi.location, " +
                    "fi.lure_used, " +
                    "fi.date_caught, " +
                    "fi.image_url " +
                "FROM fish_inventory AS fi " +
                "JOIN (" +
                    "SELECT type, COUNT(*) as type_count " +
                    "FROM fish_inventory " +
                    "GROUP BY type" +
                ") AS tc ON fi.type = tc.type " +
                "ORDER BY tc.type_count DESC, fi.type";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                fishList.add(mapRowToFish(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }

        return fishList;
    }

    @Override
    public List<String> getFishTypes() {
        List<String> fishTypesList = new ArrayList<>();
        String sql = "SELECT DISTINCT(type) FROM fish_inventory ORDER BY type";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                String type = results.getString("type");
                fishTypesList.add(type);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }

        return fishTypesList;
    }

    @Override
    public List<String> getFishLocations() {
        List<String> fishLocationsList = new ArrayList<>();
        String sql = "SELECT DISTINCT(location) FROM fish_inventory ORDER BY location";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                String location = results.getString("location");
                fishLocationsList.add(location);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }

        return fishLocationsList;
    }


    private Fish mapRowToFish(SqlRowSet rs) {
        Fish fish = new Fish();
        fish.setFishId(rs.getInt("fish_id"));
        fish.setName(rs.getString("name"));
        fish.setType(rs.getString("type"));
        fish.setLength(rs.getDouble("length"));
        fish.setWeight(rs.getDouble("weight"));
        fish.setLocation(rs.getString("location"));
        fish.setLureUsed(rs.getString("lure_used"));
        fish.setDateCaught(rs.getDate("date_caught").toLocalDate());
        fish.setImageUrl(rs.getString("image_url"));
        return fish;
    }
}
