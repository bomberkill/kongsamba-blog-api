package com.example.kongsambablogapi.services;

import com.example.kongsambablogapi.models.admins.Admin;
import com.example.kongsambablogapi.models.admins.AdminInput;
import com.example.kongsambablogapi.models.admins.AuthResponse;
import com.example.kongsambablogapi.repositories.AdminRepository;
import com.example.kongsambablogapi.utils.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins () {
        return adminRepository.findAll();
    }
    public Optional<Admin> getAdminById (String id) {
        return  adminRepository.findById(id);
    }
    public AuthResponse login (AdminInput adminInput) {
        if (adminRepository.existsByEmail(adminInput.getEmail())) {
            Admin admin = adminRepository.findByEmail(adminInput.getEmail());
            if (admin.getPassword().equals(adminInput.getPassword())) {
                AuthResponse authResponse = new AuthResponse();
                JwtUtil jwtUtil = new JwtUtil();
                authResponse.setToken(jwtUtil.generateToken(admin.getId()));
                authResponse.setExpiration(jwtUtil.getJwtExpirationInMs());
                return authResponse;
            }
            throw new IllegalArgumentException("Error during login: wrong password");
        }
        throw new IllegalArgumentException("Error during login: Admin not found");
    }
    public Admin createAdmin (AdminInput adminInput) {
        if (adminRepository.existsByEmail(adminInput.getEmail())) {
            throw new IllegalArgumentException("Email is already in use.");
        };
        Admin admin = new Admin();
        admin.setEmail(adminInput.getEmail());
        admin.setPassword(adminInput.getPassword());
//        admin.setId(generateUniqueId());
        return adminRepository.save(admin);
    }
    public Admin updateAdmin (String id, AdminInput adminInput) {
        if (adminRepository.existsById(id)) {
            Optional<Admin> adminOpt = adminRepository.findById(id);
            if (adminOpt.isPresent()) {
                Admin existingAdmin = adminOpt.get();
                existingAdmin.setId(id);
                existingAdmin.setEmail(adminInput.getEmail());
                existingAdmin.setPassword(adminInput.getPassword());
                return adminRepository.save(existingAdmin);
            }
        }
        throw new IllegalArgumentException("Error when updating: Admin " + id + " not found");
    }
    public void deleteAdmin (String id) {
        adminRepository.deleteById(id);
    }
}