package com.cts.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "flights_info")
public class FlightsInfo {

    public FlightsInfo() {
    }

    public FlightsInfo(Long airlineId, Long flightInfoId) {
        this.airlineId = airlineId;
        this.flightInfoId = flightInfoId;
    }

    @Column(name = "airline_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long airlineId;

    @Column(name = "flight_infoid")
    private Long flightInfoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private AirlineInfo airlineInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private FlightInfo  flightInfo;

    public Long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Long airlineId) {
        this.airlineId = airlineId;
    }

    public Long getFlightInfoId() {
        return flightInfoId;
    }

    public void setFlightInfoId(Long flightInfoId) {
        this.flightInfoId = flightInfoId;
    }

    public AirlineInfo getAirlineInfo() {
        return airlineInfo;
    }

    public void setAirlineInfo(AirlineInfo airlineInfo) {
        this.airlineInfo = airlineInfo;
    }

    public FlightInfo getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(FlightInfo flightInfo) {
        this.flightInfo = flightInfo;
    }

    @Override
    public String toString() {
        return "FlightsInfo{" +
                "airlineId=" + airlineId +
                ", flightInfoId=" + flightInfoId +
                '}';
    }
}
