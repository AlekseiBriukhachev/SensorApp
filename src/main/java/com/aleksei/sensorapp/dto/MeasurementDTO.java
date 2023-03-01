package com.aleksei.sensorapp.dto;

import com.aleksei.sensorapp.models.Sensor;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class MeasurementDTO {
    @NotNull
    @Min(-100)
    @Max(100)
    private Double value;
    @NotNull
    private Boolean raining;
    @NotNull
    private LocalDateTime measurementDateTime;
    @ManyToOne
    @JoinColumn(name = "sensor", referencedColumnName = "name")
    private SensorDTO sensor;

    public MeasurementDTO(double value, boolean raining, LocalDateTime measurementDateTime, SensorDTO sensor) {
        this.value = value;
        this.raining = raining;
        this.measurementDateTime = measurementDateTime;
        this.sensor = sensor;
    }
}
