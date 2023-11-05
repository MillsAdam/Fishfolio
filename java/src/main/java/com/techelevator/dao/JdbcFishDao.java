package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Fish;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcFishDao implements FishDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcFishDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Fish> getFish() {
        List<Fish> fishList = new ArrayList<>();
        String sql = "SELECT * FROM fish";

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
        String sql = "SELECT * FROM fish WHERE fish_id = ?";

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
        String sql = "SELECT * FROM fish WHERE type = ?";

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
        String sql = "SELECT * FROM fish WHERE location = ?";

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
        String sql = "INSERT INTO fish (" +
                "name, type, length, weight, " +
                "location, lure_used, date_caught, image_url) " +
                "VALUES (" +
                "?, ?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING fish_id";

        try {
            int fishId = jdbcTemplate.queryForObject(sql, int.class,
                    fish.getName(), fish.getType(),
                    fish.getLength(), fish.getWeight(),
                    fish.getLocation(), fish.getLureUsed(),
                    fish.getDateCaught(), fish.getImageUrl());
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
        String sql = "UPDATE fish " +
                "SET " +
                "name = ?, type = ?, " +
                "length = ?, weight = ?, " +
                "location = ?, lure_used = ?, " +
                "date_caught = ?, image_url = ? " +
                "WHERE fish_id = ?";

        try {
            int rowsAffected = jdbcTemplate.update(sql,
                    fish.getName(), fish.getType(),
                    fish.getLength(), fish.getWeight(),
                    fish.getLocation(), fish.getLureUsed(),
                    fish.getDateCaught(), fish.getImageUrl(),
                    fish.getFishId());
            if (rowsAffected == 0) {
                throw new DaoException("Zero rows affected, expected at least one.");
            }
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
        String sql = "DELETE FROM fish WHERE fish_id = ?";

        try {
            numberOfRows = jdbcTemplate.update(sql, fishId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return numberOfRows;
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
        fish.setDateCaught(rs.getDate("date_caught"));
        fish.setImageUrl(rs.getString("image_url"));
        return fish;
    }
}
