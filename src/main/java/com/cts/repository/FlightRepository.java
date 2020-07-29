package com.cts.repository;

import com.cts.entities.Fare;
import com.cts.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {


    //List<Flight> findByFlightDate(Date date);
    @Query(value = "SELECT  * FROM Flight WHERE flight_date = :date AND flight_infoid IN (SELECT flight_infoid  FROM flight_info WHERE flight_infoid IN (SELECT flight_infoid  FROM  flights_info WHERE airline_id in( select airline_id from airline_info where name_of_airline = :flightName)));", nativeQuery = true)
    List<Flight> getIndigoOn21Aug(@Param("date") Date date, @Param("flightName") String flightName);

    @Query("select f from Flight f where f.origin= :origin and f.flightDate = :date")
    List<Flight> getDelhiFlightsOn21Aug(@Param("origin") String origin, @Param("date") Date fltDate);

    List<Flight> findByOriginAndFlightDate(String origin, Date date);
/*
    @Query("select f from Flight f where f.origin= :origin and f.destination = :destination and f.flightNumber = :flightNumber")
    List<Flight> getFlightByOriginDestNum(@Param("origin") String origin,@Param("destination") String destination,@Param("flightNumber") String flightNumber);*/

    List<Flight> findByOriginAndDestinationAndFlightNumber(String origin, String destination, String flightNumber);

    List<Flight> findByFlightNumberAndFlightDateAndFlightTime(String flightNumber, Date flightDate, Date flightTime);


    List<Flight> findByOriginAndDestinationAndFlightDateOrderByFareFare(String origin, String destination, Date flightDate);
    List<Flight>  findByOriginAndDestinationAndFlightDateAndFlightTime(String origin, String destination, Date flightDate, Date flightTime);



}
