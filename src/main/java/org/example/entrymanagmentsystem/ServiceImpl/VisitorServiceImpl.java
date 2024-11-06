package org.example.entrymanagmentsystem.ServiceImpl;

import org.example.entrymanagmentsystem.DTO.Visitor.VisitorRequestDTO;
import org.example.entrymanagmentsystem.Repositories.AttendanceRepo;
import org.example.entrymanagmentsystem.Repositories.VisitorRepo;
import org.example.entrymanagmentsystem.Service.VisitorService;
import org.example.entrymanagmentsystem.models.Visitor;
import org.example.entrymanagmentsystem.utils.DTOConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {
    VisitorRepo visitorRepo;
    AttendanceRepo attendanceRepo;

    @Override
    public VisitorRequestDTO createVisitor(@RequestBody VisitorRequestDTO visitor) {
        return DTOConverter.convertToEntity(visitorRepo.save(DTOConverter.convertToEntity(visitor, Visitor.class)), VisitorRequestDTO.class);
    }

    @Override
    public List<VisitorRequestDTO> getAllVisitors() {
        return visitorRepo.findAll().stream().map(e -> DTOConverter.convertToEntity(e, VisitorRequestDTO.class)).toList();
    }

}
