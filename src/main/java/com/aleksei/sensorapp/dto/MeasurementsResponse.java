package com.aleksei.sensorapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class MeasurementsResponse {
    private List<MeasurementDTO> measurements;

    public MeasurementsResponse(List<MeasurementDTO> measurements) {
        this.measurements = measurements;
    }
}
