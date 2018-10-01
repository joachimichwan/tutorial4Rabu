package com.example.tutorial4Rabu.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "pilot")
public class PilotModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 50)
	@Column(name = "license_number")
	private String licenseNumber;

	@NotNull
	@Size(max = 50)
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "fly_hour")
	private int flyHour;

	@OneToMany(mappedBy = "pilot", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<FlightModel> pilotFlight = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public int getFlyHour() {
		return flyHour;
	}

	public void setFlyHour(int flyHour) {
		this.flyHour = flyHour;
	}

	public List<FlightModel> getPilotFlight() {
		return pilotFlight;
	}

	public void setPilotFlight(List<FlightModel> pilotFlight) {
		this.pilotFlight = pilotFlight;
	}
}
