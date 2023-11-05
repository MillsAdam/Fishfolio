package com.techelevator.model;

import java.util.Date;

public class TrackingHistory {
    private int historyId;
    private int fishId;
    private Date recordedDate;
    private double recordedLength;
    private double recordedWeight;


    public TrackingHistory() {
    }

    public TrackingHistory(int historyId, int fishId, Date recordedDate, double recordedLength, double recordedWeight) {
        this.historyId = historyId;
        this.fishId = fishId;
        this.recordedDate = recordedDate;
        this.recordedLength = recordedLength;
        this.recordedWeight = recordedWeight;
    }


    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
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
                "historyId=" + historyId +
                ", fishId=" + fishId +
                ", recordedDate=" + recordedDate +
                ", recordedLength=" + recordedLength +
                ", recordedWeight=" + recordedWeight +
                '}';
    }
}
