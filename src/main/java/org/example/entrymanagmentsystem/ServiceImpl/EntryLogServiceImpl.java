package org.example.entrymanagmentsystem.ServiceImpl;

import org.example.entrymanagmentsystem.DTO.EntryLogDTO;
import org.example.entrymanagmentsystem.DTO.EntryLogResponseDTO;
import org.example.entrymanagmentsystem.Repositories.CandidateRepo;
import org.example.entrymanagmentsystem.Repositories.EntryLogRepo;
import org.example.entrymanagmentsystem.Repositories.VisitorRepo;
import org.example.entrymanagmentsystem.Service.EntryLogService;
import org.example.entrymanagmentsystem.models.Candidate;
import org.example.entrymanagmentsystem.models.EntryLog;
import org.example.entrymanagmentsystem.models.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntryLogServiceImpl implements EntryLogService {

    @Autowired
    EntryLogRepo entryLogRepo;
    @Autowired
    VisitorRepo visitorRepo;
    @Autowired
    CandidateRepo candidateRepo;


    public ResponseEntity<String> createLog(EntryLogDTO entryLogDTO) {
        try {
            boolean visitorExists = visitorRepo.existsVisitorBySSN(entryLogDTO.getNid());
            boolean candidateExists = candidateRepo.existsCandidateBySsn(entryLogDTO.getNid());

            if (visitorExists && !candidateExists) {
                Visitor visitor = visitorRepo.findVisitorBySSN(entryLogDTO.getNid());
                EntryLog entryLog = new EntryLog();
                entryLog.setPerson_id(visitor.getId());
                entryLog.setRole(visitor.getRole());
                entryLogRepo.save(entryLog);
                return new ResponseEntity<>("Logged in as visitor", HttpStatus.OK);

            } else if (!visitorExists && candidateExists) {
                Candidate candidate = candidateRepo.findBySsn(entryLogDTO.getNid());
                EntryLog entryLog = new EntryLog();
                entryLog.setPerson_id(candidate.getId());
                entryLog.setRole(candidate.getRole());
                entryLogRepo.save(entryLog);
                return new ResponseEntity<>("Logged in as candidate", HttpStatus.OK);

            } else {
                return new ResponseEntity<>("Not registered", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            // Log the exception here if needed
            return new ResponseEntity<>("Internal server error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @Override
    public List<EntryLogResponseDTO> filterByrole(String role) {

        List<EntryLog> entryLogs = entryLogRepo.findAllByRole(role);
        return getAllLogs(entryLogs);
    }

    @Override
    public List<EntryLogResponseDTO> findAllLogs() {

        List<EntryLog> entryLogs = entryLogRepo.findAll();
        return getAllLogs(entryLogs);
    }


    public List<EntryLogResponseDTO> getAllLogs(List<EntryLog> entryLogs) {

        List<EntryLogResponseDTO> entryLogResponseDTOs = new ArrayList<EntryLogResponseDTO>();
        for(EntryLog entryLog : entryLogs) {
            if(entryLog.getRole().equals("visitor")) {

                EntryLogResponseDTO entryLogResponseDTO = new EntryLogResponseDTO();
                Visitor visitor = visitorRepo.findById(entryLog.getPerson_id()).orElseThrow();
                entryLogResponseDTO.setName(visitor.getName());
                entryLogResponseDTO.setSsn(visitor.getSSN());
                entryLogResponseDTO.setRole(visitor.getRole());
                entryLogResponseDTO.setPhoneNumber(visitor.getPhone());
                entryLogResponseDTO.setDate(entryLog.getDate());
                entryLogResponseDTO.setTime(entryLog.getTime());
                entryLogResponseDTOs.add(entryLogResponseDTO);
            }
            else if (entryLog.getRole().equals("candidate"))
            {
                EntryLogResponseDTO entryLogResponseDTO = new EntryLogResponseDTO();
                Candidate candidate = candidateRepo.findById(entryLog.getPerson_id()).orElseThrow();
                entryLogResponseDTO.setName(candidate.getName());
                entryLogResponseDTO.setSsn(candidate.getSsn());
                entryLogResponseDTO.setRole(candidate.getRole());
                entryLogResponseDTO.setPhoneNumber(candidate.getPhone());
                entryLogResponseDTO.setDate(entryLog.getDate());
                entryLogResponseDTO.setTime(entryLog.getTime());
                entryLogResponseDTOs.add(entryLogResponseDTO);
            }
        }
        return entryLogResponseDTOs;
    }



}
