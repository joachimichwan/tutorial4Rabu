package com.example.tutorial4Rabu.controller;

import com.example.tutorial4Rabu.model.FlightModel;
import com.example.tutorial4Rabu.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FlightController {
    @Autowired
    private FlightService flightService;

    @RequestMapping("/flight/view/{flightNumber}")
    public String view(@PathVariable String flightNumber, Model model){
        if(flightService.getFlightDetailByFlightNumber(flightNumber) != null){
            FlightModel flight = flightService.getFlightDetailByFlightNumber(flightNumber);
            model.addAttribute("flight", flight);
            return "view-flight";
        } else {
            model.addAttribute("flight", flightNumber);
            return "error-view-flight";
        }
    }

    @RequestMapping("/flight/viewall")
    public String viewall( Model model){
        List<FlightModel> flightList = (List<FlightModel>) flightService.getFlightList();
        model.addAttribute("flightList", flightList);
        return "viewall-flight";
    }
}
