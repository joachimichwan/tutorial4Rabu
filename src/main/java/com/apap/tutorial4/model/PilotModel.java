package com.apap.tutorial4.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * PilotModel
 */
@Entity
@Table(name = "pilot")
public class PilotModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "license_number", unique = true)
    private String licenseNumber;

    @NotNull
    @Size(max = 50)
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "fly_hour")
    private int flyHour;
    
    @OneToMany(mappedBy = "pilot", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<FlightModel> pilotFlight;

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * @param licenseNumber the licenseNumber to set
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @param flyHour the flyHour to set
     */
    public void setFlyHour(int flyHour) {
        this.flyHour = flyHour;
    }
    /**
     * @param pilotFlight the pilotFlight to set
     */
    public void setPilotFlight(List<FlightModel> pilotFlight) {
        this.pilotFlight = pilotFlight;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    /**
     * @return the licenseNumber
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the flyHour
     */
    public int getFlyHour() {
        return flyHour;
    }
    /**
     * @return the pilotFlight
     */
    public List<FlightModel> getPilotFlight() {
        return pilotFlight;
    }
}