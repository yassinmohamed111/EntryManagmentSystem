package org.example.entrymanagmentsystem.Controller;


import org.example.entrymanagmentsystem.DTO.Candidate.CandidateRequestDTO;
import org.example.entrymanagmentsystem.Service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("candidate")
public class CandidateController {
    @Autowired
    CandidateService candidateService;

    @PostMapping
    public void createCandidate(@RequestBody  CandidateRequestDTO candidateRequestDTO) {
        candidateService.createCandidate(candidateRequestDTO);
    }
}
