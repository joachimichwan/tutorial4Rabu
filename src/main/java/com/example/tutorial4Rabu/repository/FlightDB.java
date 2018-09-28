package com.example.tutorial4Rabu.repository;

import com.example.tutorial4Rabu.model.FlightModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightDB extends CrudRepository<FlightModel, Long> {
    FlightModel findByFlightNumber(String flightNumber);
    List<FlightModel> findAllByPilotLicenseNumber(String pilotLicenseNumber);
    List<FlightModel> findAll();
}
