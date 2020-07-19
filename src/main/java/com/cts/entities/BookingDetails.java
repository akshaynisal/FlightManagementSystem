package com.cts.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "booking_details")
public class BookingDetails {
    public BookingDetails() {
    }

    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "passenger_id")
    private Long passengerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Passenger passenger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private BookingRecord bookingRecord;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public BookingRecord getBookingRecord() {
        return bookingRecord;
    }

    public void setBookingRecord(BookingRecord bookingRecord) {
        this.bookingRecord = bookingRecord;
    }

    @Override
    public String toString() {
        return "BookingDetails{" +
                "bookingId=" + bookingId +
                ", passengerId=" + passengerId +
                '}';
    }
}
