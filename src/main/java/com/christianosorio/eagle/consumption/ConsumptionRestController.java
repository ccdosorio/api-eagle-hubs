package com.christianosorio.eagle.consumption;

import com.christianosorio.eagle.consumption.model.CreateConsumptionRequest;
import com.christianosorio.eagle.consumption.service.ConsumptionService;
import com.christianosorio.eagle.model.consumption.Consumption;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/consumption")
public class ConsumptionRestController {

    private static final long FUEL_CONSUMPTION_ID = 1;
    private static final long ELECTRICITY_CONSUMPTION_ID = 2;

    private static final long PETROLEUM_CONSUMPTION_ID = 3;

    private final ConsumptionService consumptionService;

    public ConsumptionRestController(final ConsumptionService consumptionService) {
        this.consumptionService = consumptionService;
    }

    @GetMapping(value = "/monthly/gallon", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public List<Map<String, Integer>> getAverageMonthlyFuelConsumptionPerGallon() {
        return consumptionService.getAverageMonthlyFuelConsumptionPerGallon();
    }

    @GetMapping(value = "/monthly/electrical", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public List<Map<String, Integer>> getAverageMonthlyElectricalEnergy() {
        return consumptionService.getAverageMonthlyElectricalEnergy();
    }

    @PostMapping(
            value = "/fuel",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(CREATED)
    public Consumption saveFuel(@RequestBody final CreateConsumptionRequest request) {
        return consumptionService.save(request, FUEL_CONSUMPTION_ID);
    }

    @PostMapping(
            value = "/electricity",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(CREATED)
    public Consumption saveElectricity(@RequestBody final CreateConsumptionRequest request) {
        return consumptionService.save(request, ELECTRICITY_CONSUMPTION_ID);
    }

    @PostMapping(
            value = "/petroleum",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    @ResponseStatus(CREATED)
    public Consumption savePetroleum(@RequestBody final CreateConsumptionRequest request) {
        return consumptionService.save(request, PETROLEUM_CONSUMPTION_ID);
    }

    @PutMapping(value = "/update/quantity/{consumptionId}")
    @ResponseStatus(OK)
    public Consumption updateQuantity(@PathVariable final long consumptionId, @RequestParam final long newQuantity) {
        return consumptionService.updateQuantity(consumptionId, newQuantity);
    }
}
