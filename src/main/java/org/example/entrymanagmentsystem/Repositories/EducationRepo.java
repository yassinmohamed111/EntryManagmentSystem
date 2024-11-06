package org.example.entrymanagmentsystem.Repositories;

import org.example.entrymanagmentsystem.models.Admin;
import org.example.entrymanagmentsystem.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepo extends JpaRepository<Education, Long> {
}
