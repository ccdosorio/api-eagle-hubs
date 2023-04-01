package com.christianosorio.eagle.repository.consumption;

import com.christianosorio.eagle.model.consumption.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {

    @Query(value = "select extract(month from c.createdAt) as month, avg(c.quantity) as averageMonth "
            + "from Consumption c where c.measure.measureId=1 "
            + "group by extract(month from c.createdAt) ")
    List<Map<String, Integer>> averageMonthlyFuelConsumptionPerGallon();

    @Query(value = "select extract(month from c.createdAt) as month, avg(c.quantity) as averageMonth "
            + "from Consumption c where c.typeFuel.typeFuelId=1 and c.measure.measureId=1 "
            + "group by extract(month from c.createdAt) ")
    List<Map<String, Integer>> averageMonthlyElectricalEnergy();
}
