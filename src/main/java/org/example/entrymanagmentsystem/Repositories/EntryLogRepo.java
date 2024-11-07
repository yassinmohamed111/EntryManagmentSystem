package org.example.entrymanagmentsystem.Repositories;

import org.example.entrymanagmentsystem.models.EntryLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntryLogRepo extends JpaRepository<EntryLog, Long> {
    List<EntryLog> findAllByRole(String role);

}
