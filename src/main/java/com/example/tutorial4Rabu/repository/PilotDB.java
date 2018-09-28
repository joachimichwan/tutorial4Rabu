package com.example.tutorial4Rabu.repository;

import com.example.tutorial4Rabu.model.PilotModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PilotDB extends CrudRepository<PilotModel, Long> {
    PilotModel findByLicenseNumber(String licenseNumber);
    List<PilotModel> findAll();
    boolean existsById(Integer id);
    void deleteById(Integer id);
    Integer countByLicenseNumber(String licenseNumber);
}
