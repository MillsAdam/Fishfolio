package com.techelevator.dao;

import com.techelevator.model.TrackingHistory;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class JdbcTrackingHistoryDao implements TrackingHistoryDao{
    @Override
    public List<TrackingHistory> getTrackingHistory() {
        return null;
    }

    @Override
    public TrackingHistory getTrackingHistoryById(int trackingHistoryId) {
        return null;
    }

    @Override
    public List<TrackingHistory> getTrackingHistoryByFishId(int fishId) {
        return null;
    }

    @Override
    public List<TrackingHistory> getTrackingHistoryByRecordedDate(Date recordedDate) {
        return null;
    }

    @Override
    public TrackingHistory createTrackingHistory(TrackingHistory trackingHistory) {
        return null;
    }

    @Override
    public TrackingHistory updateTrackingHistory(TrackingHistory trackingHistory) {
        return null;
    }

    @Override
    public int deleteTrackingHistory(int trackingHistoryId) {
        return 0;
    }

    private TrackingHistory mapRowToTrackingHistory(SqlRowSet rs) {
        TrackingHistory trackingHistory = new TrackingHistory();
        trackingHistory.setTrackingHistoryId(rs.getInt("tracking_history_id"));
        trackingHistory.setFishId(rs.getInt("fish_id"));
        trackingHistory.setRecordedDate(rs.getDate("recorded_date"));
        trackingHistory.setRecordedLength(rs.getDouble("recorded_length"));
        trackingHistory.setRecordedWeight(rs.getDouble("recorded_weight"));
        return trackingHistory;
    }
}
