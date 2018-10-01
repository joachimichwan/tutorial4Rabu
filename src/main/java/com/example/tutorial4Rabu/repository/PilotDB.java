package com.example.tutorial4Rabu.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tutorial4Rabu.model.PilotModel;

@Repository
public interface PilotDB extends JpaRepository<PilotModel, Long> {
    PilotModel findById(long id);
    PilotModel findByLicenseNumber(String licenseNumber);
    List<PilotModel> findAll();
    boolean existsById(long id);
    void deleteById(long id);
    int countByLicenseNumber(String licenseNumber);
}
