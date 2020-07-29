package com.cts.repository;

import com.cts.entities.FlightInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightInfoRepository extends JpaRepository<FlightInfo, Long> {
}
