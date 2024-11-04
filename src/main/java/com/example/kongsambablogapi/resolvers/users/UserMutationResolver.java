package com.example.kongsambablogapi.resolvers.users;

import com.example.kongsambablogapi.models.users.User;
import com.example.kongsambablogapi.models.users.UserInput;
import com.example.kongsambablogapi.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class UserMutationResolver {
    @Autowired
    private UserService userService;

    @MutationMapping
    public User createUser (@Argument UserInput userInput) {
        try {
            return userService.createUser(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " " + LocalDateTime.now());
            return null;
        }
    }

    @MutationMapping
    public User updateUser (@Argument String id,@Argument UserInput userInput) {
        try {
            return userService.updateUser(id, userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " " + LocalDateTime.now());
            return null;
        }
    }

    @MutationMapping
    public void deleteUser (@Argument String id) {
        try {
            userService.deleteUser(id);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " " + LocalDateTime.now());
        }
    }
}