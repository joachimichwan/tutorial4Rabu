package com.example.tutorial4Rabu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tutorial4Rabu.model.PilotModel;
import com.example.tutorial4Rabu.service.PilotService;

@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/pilot/add")
	public String add(@RequestParam(value ="id", required = true) String id, 
			@RequestParam(value ="licenseNumber", required = true) String licenseNumber, 
			@RequestParam(value ="name", required = true) String name, 
			@RequestParam(value ="flyHour", required = true) Integer flyHour){
		PilotModel pilot = new PilotModel(id, licenseNumber, name, flyHour);
		pilotService.addPilot(pilot);
		return"add";
	}
	
	@RequestMapping("/pilot/view/license-number/{licenseNumber}")
	public String view(@PathVariable String licenseNumber, Model model){
		if(pilotService.getPilotDetailByLicenseNumber(licenseNumber) != null){
			PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
			model.addAttribute("pilot", pilot);
			return "view-pilot";
		} else {
			model.addAttribute("pilot", licenseNumber);
			return "errorUpdate";
		}
	}
	
	@RequestMapping("/pilot/viewall")
	public String viewall( Model model){
		List<PilotModel> pilotList = (List<PilotModel>) pilotService.getPilotList();
		model.addAttribute("pilotList", pilotList);
		return "viewall-pilot";
	}
	
	@RequestMapping("/pilot/license-number/{licenseNumber}/flyHour/{flyHour}")
	public String update(@PathVariable String licenseNumber, @PathVariable Integer flyHour, Model model){
		if(pilotService.getPilotDetailByLicenseNumber(licenseNumber) != null){
			model.addAttribute("pilot", licenseNumber);
			return "update";
		} else {
			model.addAttribute("pilot", licenseNumber);
			return "errorUpdate";
		}
	}
	
	@RequestMapping("/pilot/delete/{id}")
	public String delete(@PathVariable String id, Model model){
		if(pilotService.deletePilot(id)){
			return "delete";
		}
		model.addAttribute("pilot", id);
		return "error";
	}	
}
