package com.aleksei.sensorappclient.dto;

import lombok.Data;

import java.util.List;

@Data
public class MeasurementResponse {
    private List<MeasurementDTO> measurements;
}
