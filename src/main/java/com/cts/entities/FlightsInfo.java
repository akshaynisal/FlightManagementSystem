package com.cts.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
    private Long airlineId;

    @Column(name = "flight_infoid")
    private Long flightInfoId;

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

    @Override
    public String toString() {
        return "FlightsInfo{" +
                "airlineId=" + airlineId +
                ", flightInfoId=" + flightInfoId +
                '}';
    }
}
