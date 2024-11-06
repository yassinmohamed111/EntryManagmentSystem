package org.example.entrymanagmentsystem.Repositories;

import org.example.entrymanagmentsystem.models.Admin;
import org.example.entrymanagmentsystem.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepo extends JpaRepository<Candidate, Long> {
}
