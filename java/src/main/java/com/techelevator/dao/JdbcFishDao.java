package com.techelevator.dao;

import com.techelevator.model.Fish;
import org.springframework.jdbc.support.rowset.SqlRowSet;

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

    private Fish mapRowToFish(SqlRowSet rs) {
        Fish fish = new Fish();
        fish.setFishId(rs.getInt("fish_id"));
        fish.setName(rs.getString("name"));
        fish.setType(rs.getString("type"));
        fish.setLength(rs.getDouble("length"));
        fish.setWeight(rs.getDouble("weight"));
        fish.setLocation(rs.getString("location"));
        fish.setLureUsed(rs.getString("lure_used"));
        fish.setDateCaught(rs.getDate("date_caught"));
        fish.setImageUrl(rs.getString("image_url"));
        return fish;
    }
}
