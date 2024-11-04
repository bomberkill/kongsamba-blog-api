package com.example.kongsambablogapi.controllers;

import com.example.kongsambablogapi.models.admins.Admin;
import com.example.kongsambablogapi.models.admins.AdminInput;
import com.example.kongsambablogapi.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<Admin> getAllAdmins () {
        System.out.println("Fetched admins in controllers: " + adminService.getAllAdmins());
        return adminService.getAllAdmins();
    }
    @GetMapping("/{id}")
    public Optional<Admin> getAdminById (@PathVariable  String id) {
        return adminService.getAdminById(id);
    }
//    @PostMapping
//    public Admin createAdmin (@RequestBody Admin admin) {
//        return adminService.createAdmin(admin);
//    }
    @PutMapping("/{id}")
    public Admin updateAdmin (@PathVariable String id, @RequestBody AdminInput adminInput) {
        return adminService.updateAdmin(id, adminInput);
    }
    @DeleteMapping("/{id}")
    public void deleteAdmin (@PathVariable String id) {
        adminService.deleteAdmin(id);
    }
}