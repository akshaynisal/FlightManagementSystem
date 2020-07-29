package com.cts.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "flight" )
public class Flight implements Serializable {
    public Flight() {
    }

    public Flight(Long id, String destination, String duration, Date flightDate, String flightNumber, Date flightTime, String origin, Long fareId, Long flightInfoid, Long invId, Fare fare, FlightInfo fligthInfo, Inventory inventory) {
        this.id = id;
        this.destination = destination;
        this.duration = duration;
        this.flightDate = flightDate;
        this.flightNumber = flightNumber;
        this.flightTime = flightTime;
        this.origin = origin;
        this.fareId = fareId;
        this.flightInfoid = flightInfoid;
        this.invId = invId;
        this.fare = fare;
        this.fligthInfo = fligthInfo;
        this.inventory = inventory;
    }

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "destination")
    private String destination;

    @Column(name = "duration")
    private String duration;

    @Column(name = "flight_date")
    //@Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date flightDate;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "flight_time")
    @Temporal(value = TemporalType.TIME)
    private java.util.Date flightTime;

    @Column(name = "origin")
    private String origin;

    @Column(name = "fare_id")
    private Long fareId;

    @Column(name = "flight_infoid")
    private Long flightInfoid;

    @Column(name = "inv_id")
    private Long invId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Fare fare;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private FlightInfo fligthInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Inventory inventory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public java.util.Date getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(java.util.Date flightTime) {
        this.flightTime = flightTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Long getFareId() {
        return fareId;
    }

    public void setFareId(Long fareId) {
        this.fareId = fareId;
    }

    public Long getFlightInfoid() {
        return flightInfoid;
    }

    public void setFlightInfoid(Long flightInfoid) {
        this.flightInfoid = flightInfoid;
    }

    public Long getInvId() {
        return invId;
    }

    public void setInvId(Long invId) {
        this.invId = invId;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public FlightInfo getFligthInfo() {
        return fligthInfo;
    }

    public void setFligthInfo(FlightInfo fligthInfo) {
        this.fligthInfo = fligthInfo;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", destination='" + destination + '\'' +
                ", duration='" + duration + '\'' +
                ", flightDate=" + flightDate +
                ", flightNumber='" + flightNumber + '\'' +
                ", flightTime=" + flightTime +
                ", origin='" + origin + '\'' +
                ", FareId=" + fareId +
                ", flightInfoid=" + flightInfoid +
                ", invId=" + invId +
                '}';
    }
}
