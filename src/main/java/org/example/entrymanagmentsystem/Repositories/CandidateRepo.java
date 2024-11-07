package org.example.entrymanagmentsystem.Repositories;

import jdk.dynalink.linker.LinkerServices;
import org.example.entrymanagmentsystem.DTO.Candidate.CandidateResponseDTO;
import org.example.entrymanagmentsystem.models.Admin;
import org.example.entrymanagmentsystem.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepo extends JpaRepository<Candidate, Long> {
    boolean existsCandidateBySsn(String ssn);
    Candidate findBySsn(String ssn);

}
