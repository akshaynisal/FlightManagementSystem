package com.cts.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "passenger")
public class Passenger {

    public Passenger() {
    }

    public Passenger(Long passengerId, String emailAddress, String firstName, String gender, String lastName, Long mobileNumber, Long bookingId) {
        this.passengerId = passengerId;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.gender = gender;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.bookingId = bookingId;
    }

    public Passenger(Long passengerId, String emailAddress, String firstName, String gender, String lastName, Long mobileNumber, Long bookingId, List<BookingDetails> bookingDetails) {
        this.passengerId = passengerId;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.gender = gender;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.bookingId = bookingId;
        this.bookingDetails = bookingDetails;
    }

    @Column(name = "passenger_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long passengerId;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobile_number")
    private Long mobileNumber;

    @Column(name = "booking_id")
    private Long bookingId;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = BookingDetails.class)
    @JoinColumn(name = "passenger_id")
    private List<BookingDetails> bookingDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private BookingRecord bookingRecord;

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public List<BookingDetails> getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(List<BookingDetails> bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    public BookingRecord getBookingRecord() {
        return bookingRecord;
    }

    public void setBookingRecord(BookingRecord bookingRecord) {
        this.bookingRecord = bookingRecord;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", bookingId=" + bookingId +
                '}';
    }
}
