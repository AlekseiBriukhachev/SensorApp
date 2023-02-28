package com.aleksei.sensorapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Measurement")
@Data
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "value")
    @NotNull
    @Min(-100)
    @Max(100)
    private double value;
    @Column(name = "raining")
    @NotNull
    private boolean raining;
    @Column(name = "measurement_date_time")
    @NotNull
    private LocalDateTime measurementDateTime;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "sensor", referencedColumnName = "name")
    private Sensor sensor;
    public Measurement(){}

    public Measurement(double value, boolean raining, LocalDateTime measurementDateTime) {
        this.value = value;
        this.raining = raining;
        this.measurementDateTime = measurementDateTime;
    }
}
