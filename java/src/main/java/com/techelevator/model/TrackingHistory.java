package com.techelevator.model;

import java.util.Date;

public class TrackingHistory {
    private int trackingHistoryId;
    private int fishId;
    private Date recordedDate;
    private double recordedLength;
    private double recordedWeight;


    public TrackingHistory() {
    }

    public TrackingHistory(int trackingHistoryId, int fishId, Date recordedDate, double recordedLength, double recordedWeight) {
        this.trackingHistoryId = trackingHistoryId;
        this.fishId = fishId;
        this.recordedDate = recordedDate;
        this.recordedLength = recordedLength;
        this.recordedWeight = recordedWeight;
    }


    public int getTrackingHistoryId() {
        return trackingHistoryId;
    }

    public void setTrackingHistoryId(int trackingHistoryId) {
        this.trackingHistoryId = trackingHistoryId;
    }

    public int getFishId() {
        return fishId;
    }

    public void setFishId(int fishId) {
        this.fishId = fishId;
    }

    public Date getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(Date recordedDate) {
        this.recordedDate = recordedDate;
    }

    public double getRecordedLength() {
        return recordedLength;
    }

    public void setRecordedLength(double recordedLength) {
        this.recordedLength = recordedLength;
    }

    public double getRecordedWeight() {
        return recordedWeight;
    }

    public void setRecordedWeight(double recordedWeight) {
        this.recordedWeight = recordedWeight;
    }


    @Override
    public String toString() {
        return "History{" +
                "trackingHistoryId=" + trackingHistoryId +
                ", fishId=" + fishId +
                ", recordedDate=" + recordedDate +
                ", recordedLength=" + recordedLength +
                ", recordedWeight=" + recordedWeight +
                '}';
    }
}
