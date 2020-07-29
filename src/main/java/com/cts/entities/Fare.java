package com.cts.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "fare")
public class Fare implements Serializable {
    public Fare() {
    }

    public Fare(Long fareId, String currency, Double fare) {
        this.fareId = fareId;
        this.currency = currency;
        this.fare = fare;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fare_id")
    private Long fareId;

    @Column(name = "currency")
    private String currency;

    @Column(name = "fare")
    private Double fare;

    @OneToMany(targetEntity = Flight.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fare_id", referencedColumnName = "fare")
    private List<Flight> flight;

    public Long getFareId() {
        return fareId;
    }

    public void setFareId(Long fareId) {
        this.fareId = fareId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public List<Flight> getFlight() {
        return flight;
    }

    public void setFlight(List<Flight> flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Fare{" +
                "fareId=" + fareId +
                ", currency='" + currency + '\'' +
                ", fare=" + fare +
                '}';
    }
}
