package com.example.tutorial4Rabu.service;

import com.example.tutorial4Rabu.model.PilotModel;

import java.util.List;

public interface PilotService {
	void addPilot(PilotModel pilot);
	List<PilotModel> getPilotList();
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	boolean deletePilot(Integer id);
	void updatePilot(PilotModel pilot);
}
