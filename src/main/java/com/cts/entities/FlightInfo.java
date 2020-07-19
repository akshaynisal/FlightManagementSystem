package com.cts.entities;


import javax.persistence.*;
import java.util.List;

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

    @OneToMany(targetEntity = Flight.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_infoid")
    private List<Flight> flight;

    @OneToMany(targetEntity = FlightsInfo.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_infoid")
    private List<FlightsInfo> flightsInfos;

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

    public List<Flight> getFlight() {
        return flight;
    }

    public void setFlight(List<Flight> flight) {
        this.flight = flight;
    }

    public List<FlightsInfo> getFlightsInfos() {
        return flightsInfos;
    }

    public void setFlightsInfos(List<FlightsInfo> flightsInfos) {
        this.flightsInfos = flightsInfos;
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
