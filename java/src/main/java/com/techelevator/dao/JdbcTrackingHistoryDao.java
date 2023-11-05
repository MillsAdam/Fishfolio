package com.techelevator.dao;

import com.techelevator.model.TrackingHistory;

import java.util.Date;
import java.util.List;

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
}
