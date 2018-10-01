package com.example.tutorial4Rabu.service;

import java.util.List;
import com.example.tutorial4Rabu.repository.PilotDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.tutorial4Rabu.model.PilotModel;

@Service
@Transactional
public class PilotInMemoryService implements PilotService {

    @Autowired
    private PilotDB pilotDB;

    @Override
    public PilotModel findById(long id) {
        return pilotDB.findById(id);
    }

    @Override
    public void addPilot(PilotModel pilot) {
        pilotDB.save(pilot);
    }

    @Override
    public List<PilotModel> getPilotList() {
        return pilotDB.findAll();
    }

    @Override
    public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
        return pilotDB.findByLicenseNumber(licenseNumber);
    }

    @Override
    public boolean deletePilot(long id) {
        if (pilotDB.existsById(id)) {
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
