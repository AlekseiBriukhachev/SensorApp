package com.aleksei.sensorapp.repositories;

import com.aleksei.sensorapp.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
}
