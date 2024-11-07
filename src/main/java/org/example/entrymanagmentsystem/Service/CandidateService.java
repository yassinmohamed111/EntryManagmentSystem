package org.example.entrymanagmentsystem.Service;

import org.example.entrymanagmentsystem.DTO.Candidate.CandidateRequestDTO;
import org.example.entrymanagmentsystem.models.Candidate;

import java.util.List;

public interface CandidateService {

    List<Candidate> getAllCandidates();
    void createCandidate(CandidateRequestDTO candidateRequestDTO);
    List<String> findAllByName(String name);
}
