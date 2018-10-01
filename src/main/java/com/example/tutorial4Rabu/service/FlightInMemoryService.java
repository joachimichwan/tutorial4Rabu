package com.example.tutorial4Rabu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.tutorial4Rabu.model.FlightModel;
import com.example.tutorial4Rabu.repository.FlightDB;

@Service
@Transactional
public class FlightInMemoryService implements FlightService {

    @Autowired
    private FlightDB flightDB;

    @Override
    public FlightModel findById(long id) {
        return flightDB.findById(id);
    }

    @Override
    public void addFlight(FlightModel flight) {
        flightDB.save(flight);
    }

    @Override
    public boolean deletePilot(long id) {
        if (flightDB.existsById(id)) {
            flightDB.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void updateFlight(FlightModel flightModel) {
        if(flightDB.findByFlightNumber(flightModel.getFlightNumber()) != null) {
            FlightModel flight = flightDB.findByFlightNumber(flightModel.getFlightNumber());
            flight.setOrigin(flightModel.getOrigin());
            flight.setDestination(flightModel.getDestination());
            flight.setTime(flightModel.getTime());
            flightDB.save(flight);
        }
    }

}
