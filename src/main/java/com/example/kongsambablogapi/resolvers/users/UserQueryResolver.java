package com.example.kongsambablogapi.resolvers.users;

import com.example.kongsambablogapi.models.users.User;
import com.example.kongsambablogapi.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserQueryResolver {
    @Autowired
    private UserService userService;

    @QueryMapping
    public List<User> getAllUsers () {
        return userService.getAllUsers();
    }
    @QueryMapping
    public User getUserById (@Argument String id) {
        return userService.getUserById(id).orElse(null);
    }
}