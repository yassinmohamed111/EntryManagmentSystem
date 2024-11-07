package org.example.entrymanagmentsystem.ServiceImpl;

import org.example.entrymanagmentsystem.Repositories.CandidateRepo;
import org.example.entrymanagmentsystem.Repositories.EntryLogRepo;
import org.example.entrymanagmentsystem.Repositories.VisitorRepo;
import org.example.entrymanagmentsystem.Service.EntryLogService;
import org.example.entrymanagmentsystem.models.Candidate;
import org.example.entrymanagmentsystem.models.EntryLog;
import org.example.entrymanagmentsystem.models.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryLogServiceImpl implements EntryLogService {

    @Autowired
    EntryLogRepo entryLogRepo;
    @Autowired
    VisitorRepo visitorRepo;
    @Autowired
    CandidateRepo candidateRepo;

    public String createLog(String nid)
    {

        boolean visitorExists = visitorRepo.existsVisitorBySSN(nid);
        boolean candidateExists = candidateRepo.existsCandidateBySsn(nid);
        if (visitorExists && !candidateExists)
        {
            Visitor visitor = visitorRepo.findVisitorBySSN(nid);
            EntryLog entryLog = new EntryLog();
            entryLog.setPerson_id(visitor.getId());
            entryLog.setRole(visitor.getRole());
            entryLogRepo.save(entryLog);

            return  "logged in as visitor";

        }

        else if(!visitorExists && candidateExists)  {
            Candidate candidate = candidateRepo.findBySsn(nid);
            EntryLog entryLog = new EntryLog();
            entryLog.setPerson_id(candidate.getId());
            entryLog.setRole(candidate.getRole());
            entryLogRepo.save(entryLog);
            return  "logged in as candidate";
        }
        else {
            return "not registered";
        }
    }
}
