package org.example.entrymanagmentsystem.Controller;


import org.example.entrymanagmentsystem.DTO.EntryLogDTO;
import org.example.entrymanagmentsystem.Service.EntryLogService;
import org.example.entrymanagmentsystem.models.EntryLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("log")
public class EntryLogController {

    @Autowired
    private EntryLogService entryLogService;

    @PostMapping()
    public ResponseEntity<String> createLog(@RequestBody EntryLogDTO entryLogDTO)
    {
        return entryLogService.createLog(entryLogDTO);
    }
}
