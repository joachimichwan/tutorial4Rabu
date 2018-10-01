package com.example.tutorial4Rabu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.tutorial4Rabu.model.FlightModel;
import com.example.tutorial4Rabu.model.PilotModel;
import com.example.tutorial4Rabu.service.FlightService;
import com.example.tutorial4Rabu.service.PilotService;

@Controller
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private PilotService pilotService;

    @RequestMapping("/flight/add/{licenseNumber}")
    public String add(Model model, @PathVariable(value = "licenseNumber") String licenseNumber) {
        FlightModel flight = new FlightModel();
        PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
        flight.setPilot(pilot);
        model.addAttribute("flight", flight);
        return"addFlight";
    }

    @RequestMapping(value = "/flight/add", method = RequestMethod.POST)
    public String addPilotSubmit(@ModelAttribute FlightModel flight) {
        flightService.addFlight(flight);
        return "add";
    }


    @RequestMapping("/flight/update/{id}")
    public String update(Model model, @PathVariable(value = "id") long id) {
        FlightModel flight = flightService.findById(id);
        model.addAttribute("flight", flight);
        return"updateFlight";
    }

    @RequestMapping(value = "/flight/update", method = RequestMethod.POST)
    public String updateFlightSubmit(@ModelAttribute FlightModel flight, Model model){
        flightService.updateFlight(flight);
        model.addAttribute("flight", flight.getFlightNumber());
        return "update";
    }

    @RequestMapping("/flight/delete/{id}")
    public String delete(@PathVariable long id, Model model){
        if(flightService.deletePilot(id)){
            return "delete";
        }
        model.addAttribute("pilot", id);
        return "error";
    }

}
