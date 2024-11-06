package org.example.entrymanagmentsystem.Mapper;

import org.example.entrymanagmentsystem.DTO.Visitor.VisitorRequestDTO;
import org.example.entrymanagmentsystem.models.Visitor;
import org.springframework.stereotype.Component;

@Component
public class VisitorMapper {
    public Visitor mapper(VisitorRequestDTO source, Visitor target) {
        target.setName(source.getName());
        target.setAddress(source.getAddress());
        target.setPhone(source.getPhone());
        target.setDob(source.getDob());
        target.setGender(source.getGender());
        target.setSSN(source.getSSN());
        target.setVisitee(source.getVisitee());
        return target;
    }
}
