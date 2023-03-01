package com.aleksei.sensorapp.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SensorDTO {
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "The name of sensor must be in range 2 and 30 characters")
    private String name;

    public SensorDTO(String name) {
        this.name = name;
    }
}
