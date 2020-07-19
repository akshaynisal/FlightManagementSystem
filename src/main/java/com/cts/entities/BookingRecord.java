package com.cts.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name ="booking_record")
public class BookingRecord {
    public BookingRecord() {
    }

    public BookingRecord(Long bookingId, Date bookingDate, String destination, Double fare, Date flightDate, String flightNumber, Date flightTime, String origin, String status) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.destination = destination;
        this.fare = fare;
        this.flightDate = flightDate;
        this.flightNumber = flightNumber;
        this.flightTime = flightTime;
        this.origin = origin;
        this.status = status;
    }

    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "booking_date")
    @Temporal(TemporalType.TIMESTAMP)
    private java.sql.Date bookingDate;

    @Column(name = "destination")
    private String destination;

    @Column(name = "fare")
    private Double fare;

     @Column(name = "flight_date")
     @Temporal(value = TemporalType.DATE)
     private java.sql.Date flightDate;

     @Column(name = "flight_number")
     private String flightNumber;

    @Column(name = "flight_time")
    @Temporal(TemporalType.TIME)
    private java.sql.Date flightTime;

    @Column(name = "origin")
    private String origin;

    @Column(name = "status")
    private String status;

    @OneToMany(targetEntity = Passenger.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id")
    private List<Passenger> passengers;

    @OneToMany(targetEntity = BookingDetails.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id")
    private List<BookingDetails> bookingDetails;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
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

    public Date getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Date flightTime) {
        this.flightTime = flightTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<BookingDetails> getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(List<BookingDetails> bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    @Override
    public String toString() {
        return "BookingRecord{" +
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", destination='" + destination + '\'' +
                ", fare=" + fare +
                ", flightDate=" + flightDate +
                ", flightNumber='" + flightNumber + '\'' +
                ", flightTime=" + flightTime +
                ", origin='" + origin + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
