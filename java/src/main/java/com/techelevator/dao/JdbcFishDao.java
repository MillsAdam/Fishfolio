package com.techelevator.dao;

import com.techelevator.model.Fish;

import java.util.List;

public class JdbcFishDao implements FishDao{
    @Override
    public List<Fish> getFish() {
        return null;
    }

    @Override
    public Fish getFishById(int fishId) {
        return null;
    }

    @Override
    public List<Fish> getFishByType(String type) {
        return null;
    }

    @Override
    public List<Fish> getFishByLocation(String location) {
        return null;
    }

    @Override
    public Fish createFish(Fish fish) {
        return null;
    }

    @Override
    public Fish updateFish(Fish fish) {
        return null;
    }

    @Override
    public int deleteFishById(int fishId) {
        return 0;
    }
}
