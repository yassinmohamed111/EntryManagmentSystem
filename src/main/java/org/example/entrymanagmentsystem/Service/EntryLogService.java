package org.example.entrymanagmentsystem.Service;

import org.example.entrymanagmentsystem.DTO.EntryLogDTO;
import org.example.entrymanagmentsystem.DTO.EntryLogDateFilterDto;
import org.example.entrymanagmentsystem.DTO.EntryLogResponseDTO;
import org.example.entrymanagmentsystem.models.EntryLog;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface EntryLogService {
    public ResponseEntity<String> createLog(EntryLogDTO entryLogDTO);
    public  List<EntryLogResponseDTO> filterByrole(String role);

    List<EntryLogResponseDTO> findAllLogs();

    List<EntryLogResponseDTO> getAllLogs(List<EntryLog> entryLogs);

    List<EntryLogResponseDTO> findAllByDate(EntryLogDateFilterDto dateFilterDto);
}
