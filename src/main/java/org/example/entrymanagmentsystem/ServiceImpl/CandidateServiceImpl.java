package org.example.entrymanagmentsystem.ServiceImpl;

import org.example.entrymanagmentsystem.DTO.Candidate.CandidateRequestDTO;
import org.example.entrymanagmentsystem.Mapper.CandidateMapper;
import org.example.entrymanagmentsystem.Repositories.AttendanceRepo;
import org.example.entrymanagmentsystem.Repositories.CandidateRepo;
import org.example.entrymanagmentsystem.Service.CandidateService;
import org.example.entrymanagmentsystem.models.Attendance;
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
    private AttendanceRepo attendanceRepo;
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
        Attendance attendance = new Attendance();
        candidateRepo.save(candidate);
        attendance.setRole(candidate.getRole());
        attendance.setPerson_id(candidate.getId());
        attendanceRepo.save(attendance);
    }
}
