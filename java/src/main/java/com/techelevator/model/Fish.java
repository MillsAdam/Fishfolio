package com.techelevator.model;

import java.util.Date;

public class Fish {
    private int fishId;
    private String name;
    private String type;
    private double length;
    private double weight;
    private String location;
    private String lureUsed;
    private Date dateCaught;
    private String imageUrl;


    public Fish() {
    }


    public Fish(int fishId, String name, String type, double length, double weight, String location, String lureUsed, Date dateCaught, String imageUrl) {
        this.fishId = fishId;
        this.name = name;
        this.type = type;
        this.length = length;
        this.weight = weight;
        this.location = location;
        this.lureUsed = lureUsed;
        this.dateCaught = dateCaught;
        this.imageUrl = imageUrl;
    }


    public int getFishId() {
        return fishId;
    }

    public void setFishId(int fishId) {
        this.fishId = fishId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLureUsed() {
        return lureUsed;
    }

    public void setLureUsed(String lureUsed) {
        this.lureUsed = lureUsed;
    }

    public Date getDateCaught() {
        return dateCaught;
    }

    public void setDateCaught(Date dateCaught) {
        this.dateCaught = dateCaught;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Override
    public String toString() {
        return "Fish{" +
                "fishId=" + fishId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", length=" + length +
                ", weight=" + weight +
                ", location='" + location + '\'' +
                ", lureUsed='" + lureUsed + '\'' +
                ", dateCaught=" + dateCaught +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
