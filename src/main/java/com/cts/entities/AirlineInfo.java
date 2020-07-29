package com.cts.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "airline_info")
public class AirlineInfo implements Serializable {
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

    @OneToMany(targetEntity = FlightsInfo.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "airline_id")
    private List<FlightsInfo> flightsInfos;

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

    public List<FlightsInfo> getFlightsInfos() {
        return flightsInfos;
    }

    public void setFlightsInfos(List<FlightsInfo> flightsInfos) {
        this.flightsInfos = flightsInfos;
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
