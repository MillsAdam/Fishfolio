package com.techelevator.dao;

import com.techelevator.model.TrackingHistory;

import java.util.Date;
import java.util.List;

public interface TrackingHistoryDao {
    List<TrackingHistory> getTrackingHistory();
    TrackingHistory getTrackingHistoryById(int trackingHistoryId);
    List<TrackingHistory> getTrackingHistoryByFishId(int fishId);
    List<TrackingHistory> getTrackingHistoryByRecordedDate(Date recordedDate);

    TrackingHistory createTrackingHistory(TrackingHistory trackingHistory);
    TrackingHistory updateTrackingHistory(TrackingHistory trackingHistory);
    int deleteTrackingHistory(int trackingHistoryId);


}
