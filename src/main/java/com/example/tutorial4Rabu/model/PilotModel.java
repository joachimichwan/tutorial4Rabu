package com.example.tutorial4Rabu.model;

import javax.persistence.*;

@Entity
@Table(name = "pilot")
public class PilotModel {

	@Id
	@Column(name = "id", nullable = false)
	private String id;

	@Column(name = "license_number", nullable = false)
	private String licenseNumber;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "flyHour", nullable = false)
	private Integer flyHour;
	
	public PilotModel(String id, String licenseNumber, String name, Integer flyHour) {
		this.id = id;
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.flyHour = flyHour;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
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
}
