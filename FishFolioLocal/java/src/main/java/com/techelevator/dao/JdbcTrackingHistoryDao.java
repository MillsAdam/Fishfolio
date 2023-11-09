package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.TrackingHistory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTrackingHistoryDao implements TrackingHistoryDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcTrackingHistoryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<TrackingHistory> getTrackingHistory() {
        List<TrackingHistory> trackingHistoryList = new ArrayList<>();
        String sql = "SELECT * FROM fish_tracking_history ORDER BY tracking_history_id";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                trackingHistoryList.add(mapRowToTrackingHistory(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }

        return trackingHistoryList;
    }

    @Override
    public TrackingHistory getTrackingHistoryById(int trackingHistoryId) {
        TrackingHistory trackingHistory = null;
        String sql = "SELECT * FROM fish_tracking_history WHERE tracking_history_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, trackingHistoryId);
            if (results.next()) {
                trackingHistory = mapRowToTrackingHistory(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }

        return trackingHistory;
    }

    @Override
    public List<TrackingHistory> getTrackingHistoryByFishId(int fishId) {
        List<TrackingHistory> trackingHistoryList = new ArrayList<>();
        String sql = "SELECT * FROM fish_tracking_history WHERE fish_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, fishId);
            while (results.next()) {
                trackingHistoryList.add(mapRowToTrackingHistory(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }

        return trackingHistoryList;
    }

    @Override
    public List<TrackingHistory> getTrackingHistoryByMonthAndYear(int month, int year) {
        List<TrackingHistory> trackingHistoryList = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM fish_tracking_history " +
                "WHERE EXTRACT(MONTH FROM recorded_date) = ? " +
                "  AND EXTRACT(YEAR FROM recorded_date) = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, month, year);
            while (results.next()) {
                trackingHistoryList.add(mapRowToTrackingHistory(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        }

        return trackingHistoryList;
    }

    @Override
    public TrackingHistory createTrackingHistory(TrackingHistory trackingHistory) {
        TrackingHistory newTrackingHistory = null;
        String sql = "INSERT INTO fish_tracking_history (" +
                "fish_id, recorded_date, " +
                "recorded_length, recorded_weight) " +
                "VALUES (?, ?, ?, ?) " +
                "RETURNING tracking_history_id";

        try {
            int trackingHistoryId = jdbcTemplate.queryForObject(sql, int.class,
                    trackingHistory.getFishId(), trackingHistory.getRecordedDate(),
                    trackingHistory.getRecordedLength(), trackingHistory.getRecordedWeight());
            newTrackingHistory = getTrackingHistoryById(trackingHistoryId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return newTrackingHistory;
    }

    @Override
    public TrackingHistory updateTrackingHistory(TrackingHistory trackingHistory) {
        TrackingHistory updatedTrackingHistory = null;
        String sql = "UPDATE fish_tracking_history " +
                "SET " +
                "fish_id = ?, recorded_date = ?, " +
                "recorded_length = ?, recorded_weight = ? " +
                "WHERE tracking_history_id = ?";

        try {
            int rowsAffected = jdbcTemplate.update(sql,
                    trackingHistory.getFishId(), trackingHistory.getRecordedDate(),
                    trackingHistory.getRecordedLength(), trackingHistory.getRecordedWeight(),
                    trackingHistory.getTrackingHistoryId());
            if (rowsAffected == 0) {
                throw new DaoException("Zero rows affected, expected at least one.");
            }
            updatedTrackingHistory = getTrackingHistoryById(trackingHistory.getTrackingHistoryId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return updatedTrackingHistory;
    }

    @Override
    public int deleteTrackingHistory(int trackingHistoryId) {
        int numberOfRows = 0;
        String sql = "DELETE FROM fish_tracking_history WHERE tracking_history_id = ?";

        try {
            numberOfRows = jdbcTemplate.update(sql, trackingHistoryId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database.", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return numberOfRows;
    }



    private TrackingHistory mapRowToTrackingHistory(SqlRowSet rs) {
        TrackingHistory trackingHistory = new TrackingHistory();
        trackingHistory.setTrackingHistoryId(rs.getInt("tracking_history_id"));
        trackingHistory.setFishId(rs.getInt("fish_id"));
        trackingHistory.setRecordedDate(rs.getDate("recorded_date").toLocalDate());
        trackingHistory.setRecordedLength(rs.getDouble("recorded_length"));
        trackingHistory.setRecordedWeight(rs.getDouble("recorded_weight"));
        return trackingHistory;
    }
}
