package com.example.tutorial4Rabu.service;

import com.example.tutorial4Rabu.model.FlightModel;
import com.example.tutorial4Rabu.repository.FlightDB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightInMemoryService implements FlightService{
    private FlightDB flightDB;

    @Override
    public List<FlightModel> getFlightList() {
        return flightDB.findAll();
    }

    @Override
    public FlightModel getFlightDetailByFlightNumber(String flightNumber) {
        return flightDB.findByFlightNumber(flightNumber);
    }
}
