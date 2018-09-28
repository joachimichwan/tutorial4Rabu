package com.example.tutorial4Rabu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flight")
public class FlightModel {

    @Id
    @Column(name = "id_flight", nullable = false)
    private Integer id;

    @Column(name = "flight_number", nullable = false)
    private String flightNumber;

    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name = "time", nullable = false)
    private Date time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "license_number")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PilotModel pilot;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getOrigin() { return origin; }

    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }

    public void setDestination(String destination) { this.destination = destination; }

    public Date getTime() { return time; }

    public void setTime(Date time) { this.time = time; }

    public String getFlightNumber() { return flightNumber; }

    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public PilotModel getPilot() { return pilot; }

    public void setPilot(PilotModel pilot) { this.pilot = pilot; }
}
