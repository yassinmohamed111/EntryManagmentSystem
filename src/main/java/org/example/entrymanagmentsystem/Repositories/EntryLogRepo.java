package org.example.entrymanagmentsystem.Repositories;

import org.example.entrymanagmentsystem.models.EntryLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EntryLogRepo extends JpaRepository<EntryLog, Long> {
    List<EntryLog> findAllByRole(String role);
    List<EntryLog> findByDateBetweenOrderByDateAsc(LocalDate startDate, LocalDate endDate);
}
