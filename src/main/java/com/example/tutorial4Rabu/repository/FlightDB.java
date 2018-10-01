package com.example.tutorial4Rabu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tutorial4Rabu.model.FlightModel;

@Repository
public interface FlightDB extends JpaRepository<FlightModel, Long>{
    FlightModel findById (long id);
    FlightModel findByFlightNumber(String flightNumber);
    boolean existsById(long id);
    void deleteById(long id);
}
