package com.cts.repository;

import com.cts.entities.BookingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRecordRepository extends JpaRepository<BookingRecord, Long> {
}
