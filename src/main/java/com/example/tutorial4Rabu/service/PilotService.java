package com.example.tutorial4Rabu.service;

import com.example.tutorial4Rabu.model.PilotModel;
import java.util.List;

public interface PilotService {
	PilotModel findById(long id);
	void addPilot(PilotModel pilot);
	List<PilotModel> getPilotList();
	PilotModel getPilotDetailByLicenseNumber(String licenseNumber);
	boolean deletePilot(long id);
	void updatePilot(PilotModel pilot);
}
