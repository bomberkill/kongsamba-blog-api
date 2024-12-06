package com.example.kongsambablogapi.services;

import com.example.kongsambablogapi.exception.RequestException;
import com.example.kongsambablogapi.models.admins.Admin;
import com.example.kongsambablogapi.models.admins.AdminInput;
import com.example.kongsambablogapi.models.admins.AuthResponse;
import com.example.kongsambablogapi.repositories.AdminRepository;
import com.example.kongsambablogapi.utils.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public List<Admin> getAllAdmins () {
        return adminRepository.findAll();
    }
    public Optional<Admin> getAdminById (String id) {
        return  adminRepository.findById(id);
    }
    public boolean verifyToken (String token)  {
        return jwtUtil.validateToken(token);
    }
    public AuthResponse login (AdminInput adminInput) {
        if (adminRepository.existsByEmail(adminInput.getEmail())) {
            Admin admin = adminRepository.findByEmail(adminInput.getEmail());
            if (passwordEncoder.matches(adminInput.getPassword(), admin.getPassword())) {
                AuthResponse authResponse = new AuthResponse();
//                JwtUtil jwtUtil = new JwtUtil();
                authResponse.setToken(jwtUtil.generateToken(admin.getId()));
//                authResponse.setExpiration(jwtUtil.getJwtExpirationInMs());
                authResponse.setUserId(admin.getId());
                return authResponse;
            }
            System.out.println("Error during login: wrong password" + " " + LocalDateTime.now());
            throw new RequestException("Error during login: wrong password");
        }
        System.out.println("Error during login: Admin not found" + " " + LocalDateTime.now());
        throw new RequestException("Error during login: Admin not found");
    }
    public Admin createAdmin (AdminInput adminInput) {
        if (adminRepository.existsByEmail(adminInput.getEmail())) {
            System.out.println("Email is already in use." + " " + LocalDateTime.now());
            throw new RequestException("Email is already in use.");
        };
        Admin admin = new Admin();
        admin.setEmail(adminInput.getEmail());
        admin.setPassword(passwordEncoder.encode(adminInput.getPassword()));
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
        System.out.println("Error when updating: Admin " + id  + " " + LocalDateTime.now());
        throw new RequestException("Error when updating: Admin not found");
    }
    public void deleteAdmin (String id) {
        adminRepository.deleteById(id);
    }
}