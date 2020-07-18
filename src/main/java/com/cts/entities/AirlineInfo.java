package com.cts.entities;


import javax.persistence.*;

@Entity
@Table(name = "airline_info")
public class AirlineInfo {
    public AirlineInfo() {
    }

    public AirlineInfo(Long airlineId, String airlineLogo, String nameOfAirline) {
        this.airlineId = airlineId;
        this.airlineLogo = airlineLogo;
        this.nameOfAirline = nameOfAirline;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "airline_id")
    private Long airlineId;

    @Column(name = "airline_logo")
    private String airlineLogo;

    @Column(name = "name_of_airline")
    private String nameOfAirline;

    public Long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Long airlineId) {
        this.airlineId = airlineId;
    }

    public String getAirlineLogo() {
        return airlineLogo;
    }

    public void setAirlineLogo(String airlineLogo) {
        this.airlineLogo = airlineLogo;
    }

    public String getNameOfAirline() {
        return nameOfAirline;
    }

    public void setNameOfAirline(String nameOfAirline) {
        this.nameOfAirline = nameOfAirline;
    }

    @Override
    public String toString() {
        return "AirLineInfo{" +
                "airlineId=" + airlineId +
                ", airlineLogo='" + airlineLogo + '\'' +
                ", nameOfAirline='" + nameOfAirline + '\'' +
                '}';
    }
}
