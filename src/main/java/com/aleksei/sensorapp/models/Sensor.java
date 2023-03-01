package com.aleksei.sensorapp.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "Sensor")
@Data
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "The name of sensor must be in range 2 and 30 characters")
    private String name;
    public Sensor(){}

    public Sensor(String name) {
        this.name = name;
    }
}
