package org.example.entrymanagmentsystem.Service;

import org.example.entrymanagmentsystem.DTO.Candidate.CandidateRequestDTO;
import org.example.entrymanagmentsystem.models.Candidate;

public interface CandidateService {

    void createCandidate(CandidateRequestDTO candidateRequestDTO);
}
