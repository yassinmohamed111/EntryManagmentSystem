package org.example.entrymanagmentsystem.ServiceImpl;

import org.example.entrymanagmentsystem.DTO.Visitor.VisitorRequestDTO;
import org.example.entrymanagmentsystem.Repositories.EntryLogRepo;
import org.example.entrymanagmentsystem.Repositories.VisitorRepo;
import org.example.entrymanagmentsystem.Service.VisitorService;
import org.example.entrymanagmentsystem.models.EntryLog;
import org.example.entrymanagmentsystem.models.Visitor;
import org.example.entrymanagmentsystem.utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    EntryLogRepo entryLogRepo;
    @Autowired
    VisitorRepo visitorRepo;

    @Override
    public String checkVisitorExists(@RequestBody VisitorRequestDTO visitor) {
        // Convert DTO to entity
        Visitor visitorUnderInspection = DTOConverter.convertToEntity(visitor, Visitor.class);

        // Check if the visitor exists based on a unique field (e.g., email)
        Optional<Visitor> existingVisitor = visitorRepo.findBySSN(visitorUnderInspection.getSSN());

        if (existingVisitor.isPresent()) {
            return "Visitor already exists";
        } else {
            return "Visitor does not exist";
        }
    }
    @Override
    public VisitorRequestDTO createVisitor(@RequestBody VisitorRequestDTO visitor) {
        EntryLog entryLog = new EntryLog();
        Visitor v = visitorRepo.save(DTOConverter.convertToEntity(visitor, Visitor.class));
        entryLog.setRole(v.getRole());
        entryLog.setPerson_id(v.getId());
        entryLogRepo.save(entryLog);
        return DTOConverter.convertToEntity(v, VisitorRequestDTO.class);
    }

    @Override
    public List<VisitorRequestDTO> getAllVisitors() {
        return visitorRepo.findAll().stream().map(e -> DTOConverter.convertToEntity(e, VisitorRequestDTO.class)).toList();
    }

}
