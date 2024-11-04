package com.example.kongsambablogapi.services;

import com.example.kongsambablogapi.models.users.User;
import com.example.kongsambablogapi.models.users.UserInput;
import com.example.kongsambablogapi.models.users.UserMetadata;
import com.example.kongsambablogapi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers () {
        return userRepository.findAll();
    }
    public Optional<User> getUserById (String id) {
        return userRepository.findById(id);
    }
    public void deleteUser (String id) {
        userRepository.deleteById(id);
    }
    public User createUser (UserInput userInput) {
        if (userRepository.existsByEmail(userInput.getEmail())) {
            throw new IllegalArgumentException("Email is already in use.");
        }
        User user = new User();
        UserMetadata userMetadata = new UserMetadata();
        user.setEmail(userInput.getEmail());
        user.setPassword(userInput.getPassword());
        user.setUserMetadata(userMetadata);
        return userRepository.save(user);
    }
    public User updateUser (String id, UserInput userInput) {
        if (userRepository.existsById(id)) {
            Optional<User> userOpt = userRepository.findById(id);
            if (userOpt.isPresent()) {
                if (userRepository.existsByEmail(userInput.getEmail())) {
                    throw new IllegalArgumentException("Email is already in use.");
                }
                User existingUser = userOpt.get();
                existingUser.setEmail(userInput.getEmail());
                existingUser.setPassword(userInput.getPassword());
                return userRepository.save(existingUser);
            }
        }
        throw new IllegalArgumentException("Error when updating: user " + id + " not found");
    }
}