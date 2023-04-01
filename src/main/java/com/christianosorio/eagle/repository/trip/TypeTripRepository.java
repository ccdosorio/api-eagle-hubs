package com.christianosorio.eagle.repository.trip;

import com.christianosorio.eagle.model.trip.TypeTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTripRepository extends JpaRepository<TypeTrip, Long> {
}
