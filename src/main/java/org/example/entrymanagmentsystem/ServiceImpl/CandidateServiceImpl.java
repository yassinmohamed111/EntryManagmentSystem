package org.example.entrymanagmentsystem.ServiceImpl;

import org.example.entrymanagmentsystem.DTO.Candidate.CandidateRequestDTO;
import org.example.entrymanagmentsystem.Mapper.CandidateMapper;
import org.example.entrymanagmentsystem.Repositories.EntryLogRepo;
import org.example.entrymanagmentsystem.Repositories.CandidateRepo;
import org.example.entrymanagmentsystem.Service.CandidateService;
import org.example.entrymanagmentsystem.models.EntryLog;
import org.example.entrymanagmentsystem.models.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {
    @Autowired
    private CandidateRepo candidateRepo;
    @Autowired
    private EntryLogRepo entryLogRepo;
    @Autowired
    private CandidateMapper candidateMapper;

    @Override
    public List<Candidate> getAllCandidates() {
        List<Candidate> candidate =  candidateRepo.findAll();
        return candidate;
    }

    @Transactional
    @Override
    public void createCandidate(CandidateRequestDTO candidateRequestDTO) {
        Candidate candidate = candidateMapper.mapperToEntity(candidateRequestDTO);
        EntryLog entryLog = new EntryLog();
        candidateRepo.save(candidate);
        entryLog.setRole(candidate.getRole());
        entryLog.setPerson_id(candidate.getId());
        entryLogRepo.save(entryLog);
    }
}
