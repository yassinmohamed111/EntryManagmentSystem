package org.example.entrymanagmentsystem.ServiceImpl;

import org.example.entrymanagmentsystem.Repositories.AdminRepo;
import org.example.entrymanagmentsystem.Service.AdminService;
import org.example.entrymanagmentsystem.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepo adminRepo;

    @Override
    public Admin addAdmin(Admin admin) {
      Admin new_admin = new Admin();
      new_admin.setEmail(admin.getEmail());
      new_admin.setPassword(admin.getPassword());
      new_admin.setUser_name(admin.getUser_name());
      return adminRepo.save(new_admin);
    }

}
