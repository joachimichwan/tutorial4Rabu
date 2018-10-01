package com.apap.tutorial4.service;

import java.util.Optional;

import com.apap.tutorial4.model.PilotModel;

/**
 * PilotService
 */
public interface PilotService {
    PilotModel getPilotDetailByLicenseNumber(String licenseNumber);

    void addPilot(PilotModel pilot);

    long deletePilotByLicenseNumber(String licenseNumber);

    Optional<PilotModel> getPilotDetailById(long id);
}