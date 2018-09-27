package com.example.tutorial4Rabu.service;

import java.util.ArrayList;
import java.util.List;

import com.example.tutorial4Rabu.repository.PilotDB;
import org.springframework.stereotype.Service;

import com.example.tutorial4Rabu.model.PilotModel;

@Service
public class PilotInMemoryService implements PilotService {
    private List<PilotModel> archivePilot;
    private PilotDB pilotDB;

    public PilotInMemoryService() {
        archivePilot = new ArrayList<>();
    }

    @Override
    public void addPilot(PilotModel pilot) { pilotDB.save(pilot); }

    @Override
    public List<PilotModel> getPilotList() { return pilotDB.findAll(); }

    @Override
    public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) { return pilotDB.findByLicenseNumber(licenseNumber); }

    @Override
    public boolean deletePilot(String id) {
        if(pilotDB.existsById(id)){
            pilotDB.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void updatePilot(String licenseNumber, Integer flyHour) {
        if(pilotDB.findByLicenseNumber(licenseNumber) != null){
            PilotModel pilot = pilotDB.findByLicenseNumber(licenseNumber);
            pilot.setFlyHour(flyHour);
            pilotDB.save(pilot);
        }
    }
}
