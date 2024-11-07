package org.example.entrymanagmentsystem.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.example.entrymanagmentsystem.DTO.Visitor.VisitorRequestDTO;
import org.example.entrymanagmentsystem.Repositories.AttendanceRepo;
import org.example.entrymanagmentsystem.Repositories.VisitorRepo;
import org.example.entrymanagmentsystem.Service.VisitorService;
import org.example.entrymanagmentsystem.models.Attendance;
import org.example.entrymanagmentsystem.models.Visitor;
import org.example.entrymanagmentsystem.utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class VisitorServiceImpl implements VisitorService {
    @Autowired
    AttendanceRepo attendanceRepo;
    @Autowired
    VisitorRepo visitorRepo;

    @Override
    public VisitorRequestDTO createVisitor(@RequestBody VisitorRequestDTO visitor) {
        Attendance attendance = new Attendance();
        Visitor v = visitorRepo.save(DTOConverter.convertToEntity(visitor, Visitor.class));
        attendance.setRole(v.getRole());
        attendance.setPerson_id(v.getId());
        attendanceRepo.save(attendance);
        return DTOConverter.convertToEntity(v, VisitorRequestDTO.class);
    }

    @Override
    public List<VisitorRequestDTO> getAllVisitors() {
        return visitorRepo.findAll().stream().map(e -> DTOConverter.convertToEntity(e, VisitorRequestDTO.class)).toList();
    }

}
