package com.techelevator.controller;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Fish;
import com.techelevator.service.FishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/fish")
public class FishController {
    private FishService fishService;
    private static final Logger logger = LoggerFactory.getLogger(FishController.class);

    @Autowired
    public FishController(FishService fishService) {
        this.fishService = fishService;
    }

    @GetMapping
    public List<Fish> getFish (
            @RequestParam(required = false) Integer fishId,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String sortBy) {

        logger.info("Received Fish Request: fishId{}, type{}, location{}, sortyBy{}",
                fishId, type, location, sortBy);

        if (fishId != null) {
            return List.of(fishService.getFishById(fishId));
        } else if (type != null) {
            return fishService.getFishByType(type);
        } else if (location != null) {
            return fishService.getFishByLocation(location);
        } else if ("most-recent".equals(sortBy)) {
            return fishService.getFishByMostRecent();
        } else if ("oldest".equals(sortBy)) {
            return fishService.getFishByOldest();
        } else if ("most-popular".equals(sortBy)) {
            return fishService.getFishByMostPopular();
        } else {
            return fishService.getFish();
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/create", method = RequestMethod.POST)
    public Fish createFish(@Valid @RequestBody Fish fish) {
        return fishService.createFish(fish);
    }

    @RequestMapping(path="/update/{fishId}", method = RequestMethod.PUT)
    public Fish updateFish(@Valid @RequestBody Fish fish, @PathVariable int fishId) {
        fish.setFishId(fishId);
        try {
            return fishService.updateFish(fish);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fish Not Found.", e);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path="/delete/{fishId}", method = RequestMethod.DELETE)
    public void deleteFish(@PathVariable int fishId) {
        fishService.deleteFishById(fishId);
    }
}
