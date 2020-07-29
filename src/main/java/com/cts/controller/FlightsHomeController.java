package com.cts.controller;

import com.cts.entities.BookingRecord;
import com.cts.entities.Flight;
import com.cts.entities.Passenger;
import com.cts.entities.User;
import com.cts.model.FlightSearchPojo;
import com.cts.repository.BookingRecordRepository;
import com.cts.repository.FlightRepository;
import com.cts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Controller
public class FlightsHomeController {
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    BookingRecordRepository bookingRecordRepository;

    @GetMapping("/flighthome")
    public String flightHomeform(Model model) {
        System.out.println("$$$$$$$$$$flightsearchform$$$$$$$$$$$$$$$$$$4");
        model.addAttribute("flight", new Flight());
        return "flighthome";
    }

    @GetMapping("/checkin")
    public String checkinForm(Model model) {
        model.addAttribute("booking", new BookingRecord());
        model.addAttribute("bookingRecords", new BookingRecord());

        return "checkin";
    }
    @PostMapping("/checkin")
    public String checkinSubmit(@ModelAttribute BookingRecord booking, Model model) {
        System.out.println("$$$$$$$$$$$getBookingId"+ booking.getBookingId());
        int min = 1;
        int max = 50;
        int random = (int) ((int) min + (max - min) * Math.random());
        // model.addAttribute("flight", new Flight());
         BookingRecord record = bookingRecordRepository.findById(booking.getBookingId()).get();
        record.setStatus(random+"B");
        record.setStatus(random+"B");
        BookingRecord newRec = bookingRecordRepository.save(record);
        model.addAttribute("booking", booking);
        model.addAttribute("bookingRecords", newRec);
        return "checkin";
    }
    @PostMapping("/flighthome")
    public String flightHomeSubmit(@ModelAttribute Flight flight, Model model) {
        System.out.println("Origin::"+flight.getOrigin()+" Destination::"+flight.getOrigin()+"Date::"+flight.getFlightDate());
        model.addAttribute("flights", flightRepository.findByOriginAndDestinationAndFlightDateOrderByFareFare(flight.getOrigin(), flight.getDestination(), flight.getFlightDate()));
        return "flighthome";
    }

    @PostMapping("/book/{flightId}")
    public String flightHomeSubmit(@PathVariable String flightId, Model model) {
        System.out.println("#####flightId#####"+flightId);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName  = ((org.springframework.security.core.userdetails.User)authentication.getPrincipal()).getUsername();
        System.out.println("IIIIIIIIIIIIIIIIIIii"+userName);
        User userObj = userRepository.findByUserName(userName);

        model.addAttribute("userObj",userObj);
        model.addAttribute("flightId",flightId);
        System.out.println("$$$$$$$$$flightHomeSubmit$$$$$$$$");
        return "bookflight";
    }


    @PostMapping("/bookflight/{flightId}")
    public String bookFlightForUser(@ModelAttribute User user, @PathVariable String flightId, Model model) {
            System.out.println("$$$$$$$$$$$$$flightId$$$$$$$$$$$$$$"+flightId);
        List<Passenger> passengers = Arrays.asList(new Passenger(null,user.getUserName()+"@gmail.com",user.getFirstName(),user.getGender(),user.getLastName(),Long.valueOf(user.getMobile()), null));
        Flight flight = flightRepository.findById(Long.valueOf(flightId)).get();
        //Flight flight = flightRepository.findByOriginAndDestinationAndFlightDateAndFlightTime("DELHI", "HYDERABAD", new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-21"), new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-08-21 01:15:00")).get(0);
        //System.out.println(flight);
        //Long bookingId, Date bookingDate, String destination, Double fare, java.sql.Date  flightDate, String flightNumber, java.sql.Date flightTime, String origin, String status
        BookingRecord newBooking = bookingRecordRepository.save(new BookingRecord(null,flight.getFlightDate(),flight.getDestination(),flight.getFare().getFare(), flight.getFlightDate(),flight.getFlightNumber(), flight.getFlightTime(), flight.getOrigin(),"Confirmed",passengers));
        model.addAttribute("newbookingId", newBooking.getBookingId());
        return "index";
    }

}
