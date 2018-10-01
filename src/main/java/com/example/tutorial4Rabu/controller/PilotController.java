package com.example.tutorial4Rabu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.tutorial4Rabu.model.PilotModel;
import com.example.tutorial4Rabu.service.PilotService;

@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;

	@RequestMapping("/")
	public String home() {
		return"home";
	}

	@RequestMapping("/pilot/add")
	public String add(Model model) {
		PilotModel pilot = new PilotModel();
		model.addAttribute("pilot", pilot);
		return"addPilot";
	}

	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	public String addPilotSubmit(@ModelAttribute PilotModel pilot) {
		pilotService.addPilot(pilot);
		return"add";
	}

	@RequestMapping("/pilot/view")
	public String view(@RequestParam("licenseNumber") String licenseNumber, Model model){
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
	public String viewall(Model model){
		List<PilotModel> pilotList = (List<PilotModel>) pilotService.getPilotList();
		model.addAttribute("pilotList", pilotList);
		return "viewall-pilot";
	}

	@RequestMapping("/pilot/update/{id}")
	public String update(Model model, @PathVariable(value = "id") long id) {
		PilotModel pilot = pilotService.findById(id);
		model.addAttribute("pilot", pilot);
		return"updatePilot";
	}

	@RequestMapping(value = "/pilot/update", method = RequestMethod.POST)
	public String updatePilotSubmit(@ModelAttribute PilotModel pilot, Model model){
		pilotService.updatePilot(pilot);
		model.addAttribute("pilot", pilot.getLicenseNumber());
		return "update";
	}

	@RequestMapping("/pilot/delete/{id}")
	public String delete(@PathVariable long id, Model model){
		if(pilotService.deletePilot(id)){
			return "delete";
		}
		model.addAttribute("pilot", id);
		return "error";
	}
}
