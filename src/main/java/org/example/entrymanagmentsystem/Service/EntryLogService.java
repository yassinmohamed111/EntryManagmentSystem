package org.example.entrymanagmentsystem.Service;

import org.example.entrymanagmentsystem.DTO.EntryLogDTO;
import org.example.entrymanagmentsystem.models.EntryLog;
import org.springframework.http.ResponseEntity;

public interface EntryLogService {
    public ResponseEntity<String> createLog(EntryLogDTO entryLogDTO);
}
