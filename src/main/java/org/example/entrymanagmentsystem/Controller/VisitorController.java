package org.example.entrymanagmentsystem.Controller;

import lombok.RequiredArgsConstructor;
import org.example.entrymanagmentsystem.DTO.Visitor.VisitorRequestDTO;
import org.example.entrymanagmentsystem.Service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("visitor")

public class VisitorController {
    @Autowired
    private  VisitorService visitorService;

    @PostMapping
    public ResponseEntity<?> createVisitor(@RequestBody VisitorRequestDTO visitor) {
        System.out.println(visitor.getVisitee());
        return ResponseEntity.ok().body(visitorService.createVisitor(visitor));
    }

    @PostMapping("test")
    public ResponseEntity<?> createVisitors(@RequestBody List<VisitorRequestDTO> visitor) {
        for (VisitorRequestDTO visitorRequestDTO : visitor) {
            ResponseEntity.ok().body(visitorService.createVisitor(visitorRequestDTO));
        }
        return ResponseEntity.ok().body(visitorService);
    }

    @GetMapping
    public ResponseEntity<?> getAllVisitors() {
        return ResponseEntity.ok().body(visitorService.getAllVisitors());
    }
}
