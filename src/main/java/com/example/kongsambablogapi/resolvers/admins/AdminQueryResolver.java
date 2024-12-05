package com.example.kongsambablogapi.resolvers.admins;

import com.example.kongsambablogapi.models.admins.Admin;
import com.example.kongsambablogapi.services.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class AdminQueryResolver  {
    @Autowired
    private AdminService adminService;

    @QueryMapping
    public List<Admin> getAllAdmins () {
        System.out.println("Fetched admins: " + adminService.getAllAdmins());
        return adminService.getAllAdmins();
    }
    @QueryMapping
    public Admin getAdminById (@Argument String id) {
        System.out.println("Fetched admin: " + adminService.getAdminById(id));
        return adminService.getAdminById(id).orElse(null);
    }

    @QueryMapping
    public Boolean verifyToken (@Argument String token) {
        return adminService.verifyToken(token);
    }
}