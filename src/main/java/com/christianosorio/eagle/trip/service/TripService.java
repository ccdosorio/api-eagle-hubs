package com.christianosorio.eagle.trip.service;

import com.christianosorio.eagle.consumption.service.ConsumptionService;
import com.christianosorio.eagle.exception.impl.ResourceNotFoundException;
import com.christianosorio.eagle.exception.impl.ValidationException;
import com.christianosorio.eagle.model.consumption.Consumption;
import com.christianosorio.eagle.model.consumption.TypeConsumption;
import com.christianosorio.eagle.model.trip.Trip;
import com.christianosorio.eagle.model.trip.TypeTrip;
import com.christianosorio.eagle.repository.trip.TripRepository;
import com.christianosorio.eagle.repository.trip.TypeTripRepository;
import com.christianosorio.eagle.trip.model.CreateTripRequest;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final TypeTripRepository typeTripRepository;
    private final ConsumptionService consumptionService;

    public TripService(final TripRepository tripRepository,
                       final TypeTripRepository typeTripRepository,
                       final ConsumptionService consumptionService) {
        this.tripRepository = tripRepository;
        this.typeTripRepository = typeTripRepository;
        this.consumptionService = consumptionService;
    }

    private TypeTrip getTypeTrip(final long id) {
        return typeTripRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.builder()
                        .displayMessage("error.trip.type-not-found", id)
                        .build());
    }

    public Trip save(final CreateTripRequest request) {
        final TypeTrip typeTrip = getTypeTrip(request.getTypeTripId());
        final Consumption consumption = consumptionService.getConsumption(request.getConsumptionId());

        final Date dateTrip = parseDate(request.getDateTrip());

        final Trip trip = Trip.builder()
                .name(request.getName())
                .description(request.getDescription())
                .dateTrip(dateTrip)
                .typeTrip(typeTrip)
                .consumption(consumption)
                .build();

        return tripRepository.save(trip);
    }

    private Date parseDate(final String startDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(startDate);
        } catch (Exception e) {
            throw ValidationException.builder()
                    .addValidationError("date", "error.date.invalid", (Object) null)
                    .build();    }
    }
}
