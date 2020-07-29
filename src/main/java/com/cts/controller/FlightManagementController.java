package com.cts.controller;

import com.cts.entities.*;
import com.cts.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/flightMgmt")
public class FlightManagementController {
    //https://stackoverflow.com/questions/56102676/java-sql-sqlsyntaxerrorexception-unknown-column-jpa-entity-issue
    //https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FareRepository fareRepository;
    @Autowired
    private FlightInfoRepository flightInfoRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private BookingRecordRepository bookingRecordRepository;


    @RequestMapping(method = RequestMethod.POST, path = "/getFlightByOriginDestNum")
    public void flights(@RequestBody Flight flight) {
        System.out.println(flight);

    }

    @GetMapping

  /*  @RequestMapping(method = RequestMethod.GET, path = "/getFlight/{date}/{airlineName}")
    public void getFlightsByNameAndDate(@PathVariable String date, @PathVariable String airlineName) throws ParseException {
        System.out.println("Date :" + date + " ," + "AirlineName :" + airlineName);
        List<Flight> flightList = flightRepository.getIndigoOn21Aug(new SimpleDateFormat("yyyy-MM-dd").parse(date), airlineName);
        flightList.stream().forEach(System.out::println);


    }*/

    /* @RequestMapping(method = RequestMethod.GET, path = "/getDelhiFlightsOn21Aug/{date}/{origin}")
     public void getDelhiFlightsOn21Aug(@PathVariable String date, @PathVariable String origin) throws ParseException {
         List<Flight> flightList = flightRepository.getDelhiFlightsOn21Aug(origin, new SimpleDateFormat("yyyy-MM-dd").parse(date));
         flightList.stream().forEach(System.out::println);
     }
 */


    @RequestMapping(method = RequestMethod.GET, path = "/getResult")
    public void getByOriginAndDestination() throws ParseException {
        //Assignment 2.1
       /* System.out.println("retrieve all Indigo flight trips of August 21st 2020 Start");
        List<Flight> flightList = flightRepository.getDelhiFlightsOn21Aug("Delhi", new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-21"));
        flightList.stream().forEach(System.out::println);
        System.out.println("retrieve all Indigo flight trips of August 21st 2020 End");*/

        //Assignment 2.2
       /* System.out.println("find all the flights leaving from Delhi on 21st of August 2020 Start");
        List<Flight> flightList1 = flightRepository.findByOriginAndFlightDate("Delhi", new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-21"));
        flightList1.stream().forEach(System.out::println);
        System.out.println("find all the flights leaving from Delhi on 21st of August 2020 End");*/

        // Assignment 2.3
     /*   System.out.println("search for flights flying between Delhi to Chennai on 21st August 2020 by flight fare low to high start");
        List<Flight> flightList3 = flightRepository.findByOriginAndDestinationAndFlightDateOrderByFareFare("Delhi", "Chennai",new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-21"));
        flightList3.stream().forEach(System.out::println);
        System.out.println("search for flights flying between Delhi to Chennai on 21st August 2020 by flight fare low to high End");*/

        // Assignment 2.4
        /*System.out.println("for flights with combination of flight number and origin and destination Start");
        List<Flight> flightList4 = flightRepository.findByOriginAndDestinationAndFlightNumber("Delhi", "Chennai", "2T-519");
        flightList4.stream().forEach(System.out::println);
        System.out.println("for flights with combination of flight number and origin and destination End");*/

        // Assignment 2.5
        System.out.println("search for a single flight with combination of flight number and flight date and flight time");
        List<Flight> flightList5 = flightRepository.findByFlightNumberAndFlightDateAndFlightTime("AI-840", new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-21"), new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-08-21 02:12:00"));
        flightList5.stream().forEach(System.out::println);
        System.out.println("search for a single flight with combination of flight number and flight date and flight time");
        // assignment 2.6
        //System.out.println("Schedule 6 additional flights from Pune to Chennai on August 22nd with different times on the same day Start");
        //Long id, String destination, String duration, java.util.Date flightDate, String flightNumber, Date flightTime, String origin, Long fareId, Long flightInfoid, Long invId, Fare fare, FlightInfo fligthInfo, Inventory inventory
        // Inv Id starts from 93;
        // Flight Id starts from 91
        //Flight infoid starts from 36
        /*Inventory inv = inventoryRepository.findById(Long.valueOf(92)).get();
        FlightInfo flightInfo = flightInfoRepository.findById(Long.valueOf(35)).get();
        Fare fare = fareRepository.findById(Long.valueOf(37)).get();
        List<Flight> saveList = new ArrayList<Flight>();
        saveList.add(new Flight(null,"Chennai", "4 hours", new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-22"), "PC001",new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-08-21 06:12:00"), "Pune", Long.valueOf(37), Long.valueOf(35), Long.valueOf(92), fare, flightInfo, inv));
        saveList.add(new Flight(null,"Chennai", "5 hours", new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-22"), "PC002",new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-08-21 07:00:00"), "Pune", Long.valueOf(37), Long.valueOf(35), Long.valueOf(92), fare, flightInfo, inv));
        saveList.add(new Flight(null,"Chennai", "6 hours", new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-22"), "PC003",new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-08-21 08:00:00"), "Pune", Long.valueOf(37), Long.valueOf(35), Long.valueOf(92), fare, flightInfo, inv));
        saveList.add(new Flight(null,"Chennai", "5.5 hours", new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-22"), "PC004",new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-08-21 09:00:00"), "Pune", Long.valueOf(37), Long.valueOf(35), Long.valueOf(92), fare, flightInfo, inv));
        saveList.add(new Flight(null,"Chennai", "1.5hours", new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-22"), "PC005",new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-08-21 10:00:00"), "Pune", Long.valueOf(37), Long.valueOf(35), Long.valueOf(92), fare, flightInfo, inv));
        saveList.add(new Flight(null,"Chennai", "2.5 hours", new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-22"), "PC006",new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-08-21 11:00:00"), "Pune", Long.valueOf(37), Long.valueOf(35), Long.valueOf(92), fare, flightInfo, inv));
        flightRepository.saveAll(saveList);*/

        //System.out.println("Schedule 6 additional flights from Pune to Chennai on August 22nd with different times on the same day End");

        // Assignment 2.7
        //s System.out.println("4 more flights from Delhi to Pune on 21st August for your desired timings Start");

        //1 Indigo, 1 Air Asia, 1 Vistara and 1 Air India flight
        // Flight infoid
        // 7 - Indigo
        //22- Vistara
        // 2 - Air India
        //13 - Air Asia
       /* Inventory inv1 = inventoryRepository.findById(Long.valueOf(92)).get();
        Fare fare1 = fareRepository.findById(Long.valueOf(37)).get();
        FlightInfo flightInfoIndigo = flightInfoRepository.findById(Long.valueOf(7)).get();
        FlightInfo flightInfoVistara = flightInfoRepository.findById(Long.valueOf(22)).get();
        FlightInfo flightInfoAirIndia = flightInfoRepository.findById(Long.valueOf(2)).get();
        FlightInfo flightInfoAirAsia = flightInfoRepository.findById(Long.valueOf(13)).get();
        flightRepository.save(new Flight(null, "Pune", "4.5 hours", new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-21"), "PD001", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-08-21 12:00:00"), "Delhi", Long.valueOf(37), Long.valueOf(7), Long.valueOf(92), fare1, flightInfoIndigo, inv1));
        flightRepository.save(new Flight(null, "Pune", "4.5 hours", new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-21"), "PD002", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-08-21 13:00:00"), "Delhi", Long.valueOf(37), Long.valueOf(22), Long.valueOf(92), fare1, flightInfoVistara, inv1));
        flightRepository.save(new Flight(null, "Pune", "4.5 hours", new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-21"), "PD003", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-08-21 15:00:00"), "Delhi", Long.valueOf(37), Long.valueOf(2), Long.valueOf(92), fare1, flightInfoAirIndia, inv1));
        flightRepository.save(new Flight(null, "Pune", "4.5 hours", new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-21"), "PD004", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-08-21 16:00:00"), "Delhi", Long.valueOf(37), Long.valueOf(13), Long.valueOf(92), fare1, flightInfoAirAsia, inv1));
        */
        //System.out.println("4 more flights from Delhi to Pune on 21st August for your desired timings End");

        //assignment 2.9
       /* System.out.println("Update Indigo flight which is schedule on 21st August 2020 3:15 AM from Delhi to Pune Start");
        //PUNE	4 hrs 07 mins	2020-08-21	6E-6686	03:15:00	DELHI
        Flight flight = flightRepository.findByFlightNumberAndFlightDateAndFlightTime("6E-6686",new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-21"),new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-08-21 03:15:00")).get(0);
        flight.setFlightDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-22"));
        flight.setFlightTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-08-22 18:30:00"));
        Flight newflight = flightRepository.save(flight);
        System.out.println("Rescheduled Flight ::"+newflight);
        System.out.println("Update Indigo flight which is schedule on 21st August 2020 3:15 AM from Delhi to Pune End");*/

        // Assignment 2.7
        // Write a class to book a flight for 2 passengers from Delhi to Hyderabad on 21st August for 01:15 AM, and update inventory accordingly.
        // Please refer table data of Passenger and booking_record,booking_details for your reference
        //Long passengerId, String emailAddress, String firstName, String gender, String lastName, Long mobileNumber, Long bookingId
//
       /* List<Passenger> passengers = new ArrayList<Passenger>();
        passengers.add(new Passenger(null,"akshaynisal@123","akshay","M","Nisal",Long.valueOf(9820), null));
        passengers.add(new Passenger(null,"Vijaynisal@123","Vijay","M","Nisal",Long.valueOf(9098), null));

        Flight flight = flightRepository.findByOriginAndDestinationAndFlightDateAndFlightTime("DELHI", "HYDERABAD", new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-21"), new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-08-21 01:15:00")).get(0);
        //System.out.println(flight);
        //Long bookingId, Date bookingDate, String destination, Double fare, java.sql.Date  flightDate, String flightNumber, java.sql.Date flightTime, String origin, String status
        BookingRecord newBooking = bookingRecordRepository.save(new BookingRecord(null,flight.getFlightDate(),flight.getDestination(),flight.getFare().getFare(), flight.getFlightDate(),flight.getFlightNumber(), flight.getFlightTime(), flight.getOrigin(),"Confirmed",passengers));
        System.out.println("New Bookign"+newBooking);*/
    }




    /*@RequestMapping(method = RequestMethod.GET, path = "/getFlightByOriginDestNum/{origin}/{destination}/{number}")
    public void getFlightByOriginDestNum(@PathVariable String origin, @PathVariable String destination, @PathVariable String number) throws ParseException {
       *//* List<Flight> flightList = flightRepository.getByOriginAndDestination(origin, new SimpleDateFormat("yyyy-MM-dd").parse(date));
        flightList.stream().forEach(System.out::println);*//*

     *//*List<Flight> flightList = flightRepository.getFlightByOriginDestNum(origin, destination, number);
        flightList.stream().forEach(System.out::println);*//*

        System.out.println("findByOriginAndDestinationAndFlightNumber");
        List<Flight> flightList = flightRepository.findByOriginAndDestinationAndFlightNumber(origin, destination, number);
        flightList.stream().forEach(System.out::println);


    }*/

}
