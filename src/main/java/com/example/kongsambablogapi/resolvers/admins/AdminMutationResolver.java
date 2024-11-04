package com.example.kongsambablogapi.resolvers.admins;

import com.example.kongsambablogapi.models.admins.Admin;
import com.example.kongsambablogapi.models.admins.AdminInput;
import com.example.kongsambablogapi.models.admins.AuthResponse;
import com.example.kongsambablogapi.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class AdminMutationResolver {
    @Autowired
    private AdminService adminService;

    @MutationMapping
    public Admin createAdmin (@Argument AdminInput adminInput) {
        try {
            return adminService.createAdmin(adminInput);
        } catch (IllegalArgumentException e) {
            // Handle the exception, e.g., log it and return a specific error message
            System.out.println(e.getMessage());
            return null; // Or handle as needed
        }
    }

    @MutationMapping
    public AuthResponse login (@Argument AdminInput adminInput) {
        try {
            return adminService.login(adminInput);
        } catch (IllegalArgumentException e) {
            // Handle the exception, e.g., log it and return a specific error message
            System.out.println(e.getMessage() + " " + LocalDateTime.now());
            return null; // Or handle as needed
        }
    }

    @MutationMapping
    public Admin updateAdmin (@Argument String id, @Argument AdminInput adminInput) {
        try {
            return adminService.updateAdmin(id, adminInput);
        } catch (IllegalArgumentException e) {
            // Handle the exception, e.g., log it and return a specific error message
            System.out.println(e.getMessage());
            return null; // Or handle as needed
        }
    }
}