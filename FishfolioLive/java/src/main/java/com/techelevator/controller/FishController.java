package com.techelevator.controller;

import com.techelevator.exception.DaoException;
import com.techelevator.exception.GlobalExceptionHandler;
import com.techelevator.model.Fish;
import com.techelevator.service.FishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping
    public List<Fish> getFish (
            @RequestParam(required = false) Integer fishId,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String sortBy) {

        logger.info("Received Fish Request: fishId: {}, type: {}, location: {}, sortBy: {}",
                fishId, type, location, sortBy);


        if (fishId != null) {
            try {
                return List.of(fishService.getFishById(fishId));
            } catch (ResponseStatusException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fish not found", e);
            } catch (Exception e) {
                throw e;
            }
        } else if (type != null) {
            return fishService.getFishByType(type);
        } else if (location != null) {
            return fishService.getFishByLocation(location);
        } else if (sortBy != null) {
            if (sortBy.contains("Recent")) {
                return fishService.getFishByMostRecent();
            } else if (sortBy.contains("Oldest")) {
                return fishService.getFishByOldest();
            } else if (sortBy.contains("Popular")) {
                return fishService.getFishByMostPopular();
            }
        }
        return fishService.getFish();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/{fishId}")
    public Fish getFishById(@Valid @PathVariable int fishId) {
        return fishService.getFishById(fishId);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Fish createFish(@Valid @RequestBody Fish fish) {
        return fishService.createFish(fish);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("/update/{fishId}")
    public Fish updateFish(@Valid @RequestBody Fish fish, @PathVariable int fishId) {
        fish.setFishId(fishId);
        try {
            return fishService.updateFish(fish);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fish Not Found.", e);
        }
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{fishId}")
    public void deleteFish(@PathVariable int fishId) {
        fishService.deleteFishById(fishId);
    }


    @GetMapping("/types")
    public List<String> getFishTypes() {
        return fishService.getFishTypes();
    }

    @GetMapping("/locations")
    public List<String> getFishLocations() {
        return fishService.getFishLocations();
    }

}
