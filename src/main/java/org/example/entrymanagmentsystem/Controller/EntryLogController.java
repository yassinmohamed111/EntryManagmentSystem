package org.example.entrymanagmentsystem.Controller;


import org.example.entrymanagmentsystem.DTO.EntryLogDTO;
import org.example.entrymanagmentsystem.DTO.EntryLogDateFilterDto;
import org.example.entrymanagmentsystem.DTO.EntryLogResponseDTO;
import org.example.entrymanagmentsystem.Service.EntryLogService;
import org.example.entrymanagmentsystem.models.EntryLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("test")
    public ResponseEntity<?> createLogs(@RequestBody List<EntryLogDTO> entryLogDTO)
    {
        for (EntryLogDTO entryLogDTO1 : entryLogDTO){
            ResponseEntity.ok().body(entryLogService.createLog(entryLogDTO1));
        }
        return ResponseEntity.ok().body(entryLogService);
    }

    @GetMapping
    public List<EntryLogResponseDTO> getAllLogs()
    {
        return entryLogService.findAllLogs();
    }

    @PostMapping("{role}")
    public List<EntryLogResponseDTO> filterByRole(@PathVariable  String role)
    {
        return  entryLogService.filterByrole(role);
    }

    @PostMapping("filterDates")
    public List<EntryLogResponseDTO> filterByDates(@RequestBody EntryLogDateFilterDto dateFilterDto){

        System.out.println(dateFilterDto.getStartDate()  + " " +  dateFilterDto.getEndDate());
        return entryLogService.findAllByDate(dateFilterDto);
    }
}
