package com.christianosorio.eagle.repository.trip;

import com.christianosorio.eagle.model.trip.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
}
