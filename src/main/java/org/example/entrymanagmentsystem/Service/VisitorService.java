package org.example.entrymanagmentsystem.Service;

import org.example.entrymanagmentsystem.DTO.Visitor.VisitorRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface VisitorService {
    VisitorRequestDTO createVisitor(@RequestBody VisitorRequestDTO visitor);

    List<VisitorRequestDTO> getAllVisitors();

}
