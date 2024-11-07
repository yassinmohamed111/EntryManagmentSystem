package org.example.entrymanagmentsystem.Controller;


import org.example.entrymanagmentsystem.DTO.Candidate.CandidateRequestDTO;
import org.example.entrymanagmentsystem.Service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
