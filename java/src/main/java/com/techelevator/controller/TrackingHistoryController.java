package com.techelevator.controller;

import com.techelevator.exception.DaoException;
import com.techelevator.model.TrackingHistory;
import com.techelevator.service.TrackingHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/tracking-history")
public class TrackingHistoryController {
    private TrackingHistoryService trackingHistoryService;
    private static final Logger logger = LoggerFactory.getLogger(TrackingHistoryController.class);

    @Autowired
    public TrackingHistoryController(TrackingHistoryService trackingHistoryService) {
        this.trackingHistoryService = trackingHistoryService;
    }

    @GetMapping
    public List<TrackingHistory> getTrackingHistory (
            @RequestParam(required = false) Integer trackingHistoryId,
            @RequestParam(required = false) Integer fishId,
            @RequestParam(required = false) Integer month,
            @RequestParam(required = false) Integer year) {

        logger.info("Received TrackingHistory Request: trackingHistoryId: {}, fishId: {}, month: {}, year: {}",
                trackingHistoryId, fishId, month, year);

        if (trackingHistoryId != null) {
            return List.of(trackingHistoryService.getTrackingHistoryById(trackingHistoryId));
        } else if (fishId != null ) {
            return trackingHistoryService.getTrackingHistoryByFishId(fishId);
        } else if (month != null && year != null) {
            return trackingHistoryService.getTrackingHistoryByMonthAndYear(month, year);
        } else {
            return trackingHistoryService.getTrackingHistory();
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/create", method = RequestMethod.POST)
    public TrackingHistory createTrackingHistory(@Valid @RequestBody TrackingHistory trackingHistory) {
        return trackingHistoryService.createTrackingHistory(trackingHistory);
    }

    @RequestMapping(path="/update/{trackingHistoryId}", method = RequestMethod.PUT)
    public TrackingHistory updateTrackingHistory(@Valid @RequestBody TrackingHistory trackingHistory, @PathVariable int trackingHistoryId) {
        trackingHistory.setTrackingHistoryId(trackingHistoryId);
        try {
            return trackingHistoryService.updateTrackingHistory(trackingHistory);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tracking History Not Found.", e);
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path="/delete/{trackingHistoryId}", method = RequestMethod.DELETE)
    public void deleteTrackingHistory(@PathVariable int trackingHistoryId) {
        trackingHistoryService.deleteTrackingHistoryById(trackingHistoryId);
    }
}
