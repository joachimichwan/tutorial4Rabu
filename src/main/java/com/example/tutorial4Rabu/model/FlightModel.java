package com.example.tutorial4Rabu.model;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "flight")
public class FlightModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "flight_number")
    private String flightNumber;

    @NotNull
    @Size(max = 50)
    @Column(name = "origin")
    private String origin;

    @NotNull
    @Size(max = 50)
    @Column(name = "destination")
    private String destination;

    @NotNull
    @Column(name = "time")
    private Date time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pilot_licenseNumber", referencedColumnName = "license_number")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PilotModel pilot;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public PilotModel getPilot() {
        return pilot;
    }

    public void setPilot(PilotModel pilot) {
        this.pilot = pilot;
    }

}
