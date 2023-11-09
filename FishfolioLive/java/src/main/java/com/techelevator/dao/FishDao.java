package com.techelevator.dao;

import com.techelevator.model.Fish;

import java.util.List;

public interface FishDao {
    List<Fish> getFish();
    Fish getFishById(int fishId);
    List<Fish> getFishByType(String type);
    List<Fish> getFishByLocation(String location);

    Fish createFish(Fish fish);
    Fish updateFish(Fish fish);
    int deleteFishById(int fishId);

    List<Fish> getFishByMostRecent();
    List<Fish> getFishByOldest();
    List<Fish> getFishByMostPopular();

    List<String> getFishTypes();
    List<String> getFishLocations();
}
