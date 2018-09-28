package com.example.tutorial4Rabu.service;

import com.example.tutorial4Rabu.model.FlightModel;

import java.util.List;

public interface FlightService {
    List<FlightModel> getFlightList();
    FlightModel getFlightDetailByFlightNumber(String flightNumber);
}
