package com.cts.model;

import java.util.Date;

public class FlightSearchPojo {

    private String origin;
    private String destination;
    private Date date;

    public FlightSearchPojo() {
    }

    public FlightSearchPojo(String origin, String destination, Date date) {
        this.origin = origin;
        this.destination = destination;
        this.date = date;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
