package com.cts.controller;

import com.cts.entities.Flight;
import com.cts.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/flightMgmt")
public class FlightManagementController {

    @Autowired
    private FlightRepository flightRepository;


    @RequestMapping(method = RequestMethod.GET, path = "/getFlight/{date}/{airlineName}")
    public void getFlightsByNameAndDate(@PathVariable String date, @PathVariable String airlineName) throws ParseException {
        System.out.println("Date :"+date+" ,"+"AirlineName :"+airlineName);
        //List<Flight> flightList = flightRepository.findByFlightDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-21"));
        List<String> flightList = flightRepository.getResult(new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-21"),airlineName);
        flightList.stream().forEach(System.out::println);
    }
}

