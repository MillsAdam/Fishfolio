package com.techelevator.service;

import com.techelevator.dao.TrackingHistoryDao;
import com.techelevator.model.TrackingHistory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrackingHistoryService {
    private TrackingHistoryDao trackingHistoryDao;
    public TrackingHistoryService(TrackingHistoryDao trackingHistoryDao) {
        this.trackingHistoryDao = trackingHistoryDao;
    }

    public List<TrackingHistory> getTrackingHistory() {
        return trackingHistoryDao.getTrackingHistory();
    }

    public TrackingHistory getTrackingHistoryById(int trackingHistoryId) {
        return trackingHistoryDao.getTrackingHistoryById(trackingHistoryId);
    }

    public List<TrackingHistory> getTrackingHistoryByFishId(int fishId) {
        return trackingHistoryDao.getTrackingHistoryByFishId(fishId);
    }

    public List<TrackingHistory> getTrackingHistoryByMonthAndYear(int month, int year) {
        return trackingHistoryDao.getTrackingHistoryByMonthAndYear(month, year);
    }

    public TrackingHistory createTrackingHistory(TrackingHistory trackingHistory) {
        return trackingHistoryDao.createTrackingHistory(trackingHistory);
    }

    public TrackingHistory updateTrackingHistory(TrackingHistory trackingHistory) {
        return trackingHistoryDao.updateTrackingHistory(trackingHistory);
    }

    public int deleteTrackingHistoryById(int trackingHistoryId) {
        return trackingHistoryDao.deleteTrackingHistory(trackingHistoryId);
    }
}
