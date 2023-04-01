package com.christianosorio.eagle.consumption.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CreateConsumptionRequest {
    private Long consumptionId;
    private String name;
    private Long quantity;
    private String description;
    private Long measureId;
    private Long typeConsumptionId;
    private Long typeEmissionId;
}
