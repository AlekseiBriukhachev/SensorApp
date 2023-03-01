package com.aleksei.sensorappclient.dto;

import lombok.Data;

@Data
public class MeasurementDTO {
    private Double value;
    private Boolean isRaining;
    private SensorDTO sensor;
}
