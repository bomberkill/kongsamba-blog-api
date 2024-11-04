package com.example.kongsambablogapi.repositories;

import com.example.kongsambablogapi.models.admins.Admin;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
    boolean existsByEmail(String email);
    Admin findByEmail(String email);
}