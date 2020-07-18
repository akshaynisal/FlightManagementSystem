package com.cts.entities;

import javax.persistence.*;

@Entity
@Table(name = "fare")
public class Fare {
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

    @Override
    public String toString() {
        return "Fare{" +
                "fareId=" + fareId +
                ", currency='" + currency + '\'' +
                ", fare=" + fare +
                '}';
    }
}
