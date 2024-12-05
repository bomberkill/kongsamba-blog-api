package com.example.kongsambablogapi.repositories;

import com.example.kongsambablogapi.models.admins.Admin;
import com.example.kongsambablogapi.models.users.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    boolean existsByEmail(String email);
    User findByEmail(String email);
}