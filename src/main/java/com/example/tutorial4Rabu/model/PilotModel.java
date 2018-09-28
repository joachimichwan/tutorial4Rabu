package com.example.tutorial4Rabu.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pilot")
public class PilotModel {

	@Id
	@Column(name = "id_pilot", nullable = false)
	private Integer id;

	@Column(name = "license_number", nullable = false)
	private String licenseNumber;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "flyHour", nullable = false)
	private Integer flyHour;

	@OneToMany(mappedBy = "pilot", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<FlightModel> pilotFlight = new ArrayList<>();
	
	public PilotModel(Integer id, String licenseNumber, String name, Integer flyHour) {
		this.id = id;
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.flyHour = flyHour;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLicenseNumber() {
		return licenseNumber;
	}
	
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getFlyHour() {
		return flyHour;
	}
	
	public void setFlyHour(Integer flyHour) {
		this.flyHour = flyHour;
	}

	public List<FlightModel> getPilotFlight() {
		return pilotFlight;
	}

	public void setPilotFlight(List<FlightModel> pilotFlight) {
		this.pilotFlight = pilotFlight;
	}
}
