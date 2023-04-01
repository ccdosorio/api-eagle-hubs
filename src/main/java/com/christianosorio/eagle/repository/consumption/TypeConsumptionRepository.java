package com.christianosorio.eagle.repository.consumption;

import com.christianosorio.eagle.model.consumption.TypeConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeConsumptionRepository extends JpaRepository<TypeConsumption, Long> {
}
