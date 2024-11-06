package org.example.entrymanagmentsystem.Repositories;

import org.example.entrymanagmentsystem.models.Admin;
import org.example.entrymanagmentsystem.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
}
