package org.example.entrymanagmentsystem.Controller;


import org.example.entrymanagmentsystem.Service.EntryLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("log")
public class EntryLogController {

    @Autowired
    private EntryLogService entryLogService;

    @PostMapping("{nid}")
    public String createLog(@PathVariable String nid)
    {
        System.out.println(nid);
        return entryLogService.createLog(nid);
    }
}
