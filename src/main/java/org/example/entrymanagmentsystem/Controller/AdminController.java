package org.example.entrymanagmentsystem.Controller;

import jakarta.websocket.server.PathParam;
import org.example.entrymanagmentsystem.Repositories.AdminRepo;
import org.example.entrymanagmentsystem.Service.AdminService;
import org.example.entrymanagmentsystem.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminRepo adminRepo;

    @PostMapping
    public ResponseEntity<String> Add_admin(@RequestBody Admin admin){
         adminService.addAdmin(admin);
         return ResponseEntity.ok("new Admin added successfully");
    }

    @DeleteMapping("{email}")
    public ResponseEntity<String> delete_Admin(@PathVariable String email){
        if(adminRepo.existsByEmail(email)){
            adminRepo.deleteByEmail(email);
            return new ResponseEntity<>("Admin deleted successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Admin not found",HttpStatus.NOT_FOUND);
        }
    }
}
