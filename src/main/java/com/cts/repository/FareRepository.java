package com.cts.repository;

import com.cts.entities.Fare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FareRepository extends JpaRepository<Fare, Long> {
}
