package com.cts.repository;

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
    @Query(value = "SELECT  * FROM Flight WHERE flight_date = :abc AND flight_infoid IN (SELECT flight_infoid  FROM flight_info WHERE flight_infoid IN (SELECT flight_infoid  FROM  flights_info WHERE airline_id in( select airline_id from airline_info where name_of_airline = :def)));", nativeQuery = true)
    List<String> getResult(@Param("abc") Date abc, @Param("def") String def);

    List<String> getResult1(@Param("abc") Date abc, @Param("def") String def);
}
