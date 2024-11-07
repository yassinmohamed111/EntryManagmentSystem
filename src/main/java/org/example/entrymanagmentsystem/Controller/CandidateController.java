package org.example.entrymanagmentsystem.Controller;


import lombok.extern.slf4j.Slf4j;
import org.example.entrymanagmentsystem.DTO.Candidate.CandidateRequestDTO;
import org.example.entrymanagmentsystem.Service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("candidate")
public class CandidateController {
    @Autowired
    CandidateService candidateService;

    @GetMapping
    public ResponseEntity<?> getAllVisitors() {
        return ResponseEntity.ok().body(candidateService.getAllCandidates());
    }

    @PostMapping
    public void createCandidate(@RequestBody  CandidateRequestDTO candidateRequestDTO) {
        candidateService.createCandidate(candidateRequestDTO);
    }

    @PostMapping("test")
    public void createCandidates(@RequestBody  List<CandidateRequestDTO> candidateRequestDTO) {
        for (CandidateRequestDTO candidateRequestDTO1 : candidateRequestDTO) {
            candidateService.createCandidate(candidateRequestDTO1);
        }
    }
}
