package org.example.entrymanagmentsystem.Repositories;

import org.example.entrymanagmentsystem.models.EntryLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryLogRepo extends JpaRepository<EntryLog, Long> {
}
