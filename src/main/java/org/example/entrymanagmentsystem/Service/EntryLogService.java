package org.example.entrymanagmentsystem.Service;

import org.example.entrymanagmentsystem.DTO.EntryLogDTO;
import org.example.entrymanagmentsystem.models.EntryLog;

public interface EntryLogService {
    public String createLog(EntryLogDTO entryLogDTO);
}
