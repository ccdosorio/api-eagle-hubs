package com.christianosorio.eagle.trip.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CreateTripRequest {
    private Long tripId;
    private String name;
    private String description;
    private Long typeTripId;
    private String dateTrip;
    private Long consumptionId;
}
