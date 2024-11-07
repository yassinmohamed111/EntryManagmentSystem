package org.example.entrymanagmentsystem.Repositories;

import org.example.entrymanagmentsystem.models.EntryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EntryLogRepo extends JpaRepository<EntryLog, Long> {
    List<EntryLog> findAllByRole(String role);
    @Query(value = "SELECT * FROM entry_log WHERE date >= ?1 AND date <= ?2 ORDER BY date DESC", nativeQuery = true)
    List<EntryLog> findAllByDate(LocalDate startDate, LocalDate endDate);

}