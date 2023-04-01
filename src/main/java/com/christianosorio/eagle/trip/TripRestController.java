package com.christianosorio.eagle.trip;

import com.christianosorio.eagle.model.trip.Trip;
import com.christianosorio.eagle.trip.model.CreateTripRequest;
import com.christianosorio.eagle.trip.service.TripService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/trip")
public class TripRestController {

    private final TripService tripService;

    public TripRestController(final TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public Trip save(@RequestBody final CreateTripRequest request) {
        return tripService.save(request);
    }
}
