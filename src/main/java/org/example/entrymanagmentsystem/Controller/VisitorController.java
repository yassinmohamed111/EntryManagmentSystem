package org.example.entrymanagmentsystem.Controller;

import lombok.RequiredArgsConstructor;
import org.example.entrymanagmentsystem.DTO.Visitor.VisitorRequestDTO;
import org.example.entrymanagmentsystem.Service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("visitor")

public class VisitorController {
    @Autowired
    private  VisitorService visitorService;

    @PostMapping
    public ResponseEntity<?> createVisitor(@RequestBody VisitorRequestDTO visitor) {
        return ResponseEntity.ok().body(visitorService.createVisitor(visitor));
    }

    @GetMapping
    public ResponseEntity<?> getAllVisitors() {
        return ResponseEntity.ok().body(visitorService.getAllVisitors());
    }
}
