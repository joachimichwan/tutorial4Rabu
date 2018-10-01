package com.example.tutorial4Rabu.service;

import com.example.tutorial4Rabu.model.FlightModel;

public interface FlightService {
    FlightModel findById (long id);
    void addFlight(FlightModel flight);
    boolean deletePilot(long id);
    void updateFlight(FlightModel flight);
}
