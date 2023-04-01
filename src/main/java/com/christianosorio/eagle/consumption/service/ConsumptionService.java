package com.christianosorio.eagle.consumption.service;

import com.christianosorio.eagle.consumption.model.CreateConsumptionRequest;
import com.christianosorio.eagle.exception.impl.ResourceNotFoundException;
import com.christianosorio.eagle.model.Measure;
import com.christianosorio.eagle.model.TypeEmission;
import com.christianosorio.eagle.model.consumption.Consumption;
import com.christianosorio.eagle.model.consumption.TypeConsumption;
import com.christianosorio.eagle.model.fuel.TypeFuel;
import com.christianosorio.eagle.repository.MeasureRepository;
import com.christianosorio.eagle.repository.TypeEmissionRepository;
import com.christianosorio.eagle.repository.consumption.ConsumptionRepository;
import com.christianosorio.eagle.repository.consumption.TypeConsumptionRepository;
import com.christianosorio.eagle.repository.fuel.TypeFuelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ConsumptionService {
    private final ConsumptionRepository consumptionRepository;
    private final TypeConsumptionRepository typeConsumptionRepository;
    private final TypeFuelRepository typeFuelRepository;
    private final MeasureRepository measureRepository;
    private final TypeEmissionRepository typeEmissionRepository;

    public ConsumptionService(final ConsumptionRepository consumptionRepository,
                              final TypeConsumptionRepository typeConsumptionRepository,
                              final TypeFuelRepository typeFuelRepository,
                              final MeasureRepository measureRepository,
                              final TypeEmissionRepository typeEmissionRepository) {
        this.consumptionRepository = consumptionRepository;
        this.typeConsumptionRepository = typeConsumptionRepository;
        this.typeFuelRepository = typeFuelRepository;
        this.measureRepository = measureRepository;
        this.typeEmissionRepository = typeEmissionRepository;
    }

    public Consumption getConsumption(final long id) {
        return consumptionRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.builder()
                        .displayMessage("error.consumption.not-found", id)
                        .build());
    }

    private TypeConsumption getTypeConsumption(final long id) {
        return typeConsumptionRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.builder()
                        .displayMessage("error.consumption.type-not-found", id)
                        .build());
    }

    private TypeFuel getTypeFuel(final long id) {
        return typeFuelRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.builder()
                        .displayMessage("error.fuel.type-not-found", id)
                        .build());
    }

    private Measure getMeasure(final long id) {
        return measureRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.builder()
                        .displayMessage("error.measure.not-found", id)
                        .build());
    }

    private TypeEmission getMTypeEmission(final long id) {
        return typeEmissionRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.builder()
                        .displayMessage("error.emission.type-not-found", id)
                        .build());
    }

    public List<Map<String, Integer>> getAverageMonthlyFuelConsumptionPerGallon() {
        return consumptionRepository.averageMonthlyFuelConsumptionPerGallon();
    }

    public List<Map<String, Integer>> getAverageMonthlyElectricalEnergy() {
        return consumptionRepository.averageMonthlyElectricalEnergy();
    }

    public Consumption save(final CreateConsumptionRequest request, final long typeFuelId) {

        final TypeFuel typeFuel = getTypeFuel(typeFuelId);
        final TypeConsumption typeConsumption = getTypeConsumption(request.getTypeConsumptionId());
        final Measure measure = getMeasure(request.getMeasureId());
        final TypeEmission typeEmission = getMTypeEmission(request.getTypeEmissionId());
        final String nameConsumption = request.getName().toUpperCase();

        final Consumption consumption = Consumption.builder()
                .name(nameConsumption)
                .description(request.getDescription())
                .typeFuel(typeFuel)
                .typeConsumption(typeConsumption)
                .measure(measure)
                .quantity(request.getQuantity())
                .typeEmission(typeEmission)
                .build();

        return consumptionRepository.save(consumption);
    }

    public Consumption updateQuantity(final long consumptionId, final long newQuantity) {
        final Consumption consumption = getConsumption(consumptionId);
        consumption.setQuantity(newQuantity);

        return consumptionRepository.save(consumption);
    }
}
