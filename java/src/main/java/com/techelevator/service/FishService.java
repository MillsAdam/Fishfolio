package com.techelevator.service;

import com.techelevator.dao.FishDao;
import com.techelevator.model.Fish;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishService {
    private FishDao fishDao;
    public FishService(FishDao fishDao) {
        this.fishDao = fishDao;
    }

    public List<Fish> getFish() {
        return fishDao.getFish();
    }

    public Fish getFishById(int fishId) {
        return fishDao.getFishById(fishId);
    }

    public List<Fish> getFishByType(String type) {
        return fishDao.getFishByType(type);
    }

    public List<Fish> getFishByLocation(String location) {
        return fishDao.getFishByLocation(location);
    }

    public List<Fish> getFishByMostRecent() {
        return fishDao.getFishByMostRecent();
    }

    public List<Fish> getFishByOldest() {
        return fishDao.getFishByOldest();
    }

    public List<Fish> getFishByMostPopular() {
        return fishDao.getFishByMostPopular();
    }

    public Fish createFish(Fish fish) {
        return fishDao.createFish(fish);
    }

    public Fish updateFish(Fish fish) {
        return fishDao.updateFish(fish);
    }

    public int deleteFishById(int fishId) {
        return fishDao.deleteFishById(fishId);
    }

    public List<String> getFishTypes() {
        return fishDao.getFishTypes();
    }

    public List<String> getFishLocations() { return fishDao.getFishLocations(); }
}
