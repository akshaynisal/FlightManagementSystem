package com.cts.entities;


import javax.persistence.*;

@Entity
@Table(name = "flight_info")
public class FlightInfo {
    public FlightInfo() {
    }

    public FlightInfo(Long flightInfoId, String flightNumber, String flightType, Integer numberOfSeats) {
        this.flightInfoId = flightInfoId;
        this.flightNumber = flightNumber;
        this.flightType = flightType;
        this.numberOfSeats = numberOfSeats;
    }

    @Column(name = "flight_infoid")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flightInfoId;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "flight_type")
    private String flightType;

    @Column(name = "numberof_seats")
    private Integer numberOfSeats;

    public Long getFlightInfoId() {
        return flightInfoId;
    }

    public void setFlightInfoId(Long flightInfoId) {
        this.flightInfoId = flightInfoId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "FlightInfo{" +
                "flightInfoId=" + flightInfoId +
                ", flightNumber='" + flightNumber + '\'' +
                ", flightType='" + flightType + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }
}
