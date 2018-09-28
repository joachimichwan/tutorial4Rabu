package com.example.tutorial4Rabu.service;

import java.util.ArrayList;
import java.util.List;

import com.example.tutorial4Rabu.repository.PilotDB;
import org.springframework.stereotype.Service;

import com.example.tutorial4Rabu.model.PilotModel;

@Service
public class PilotInMemoryService implements PilotService {
    private PilotDB pilotDB;

    @Override
    public void addPilot(PilotModel pilot) { pilotDB.save(pilot); }

    @Override
    public List<PilotModel> getPilotList() {
        return pilotDB.findAll();
    }

    @Override
    public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) { return pilotDB.findByLicenseNumber(licenseNumber); }

    @Override
    public boolean deletePilot(Integer id) {
        if(pilotDB.existsById(id)){
            pilotDB.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void updatePilot(PilotModel pilotModel) {
        if(pilotDB.findByLicenseNumber(pilotModel.getLicenseNumber()) != null){
            PilotModel pilot = pilotDB.findByLicenseNumber(pilotModel.getLicenseNumber());
            pilot.setFlyHour(pilotModel.getFlyHour());
            pilot.setName(pilotModel.getName());
            pilotDB.save(pilot);
        }
    }
}
