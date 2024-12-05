package com.example.kongsambablogapi.configuration;

import com.example.kongsambablogapi.models.admins.Admin;
import com.example.kongsambablogapi.models.users.User;
import com.example.kongsambablogapi.repositories.AdminRepository;
import com.example.kongsambablogapi.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Check if email exists in Admin repository
        Optional<Admin> adminOpt = Optional.ofNullable(adminRepository.findByEmail(email));
        if (adminOpt.isPresent()) {
            Admin admin = adminOpt.get();
            return new org.springframework.security.core.userdetails.User(
                    admin.getEmail(),
                    admin.getPassword(),
                    new ArrayList<>()
            );
        }

        // Check if email exists in User repository
        Optional<User> userOpt = Optional.ofNullable(userRepository.findByEmail(email));
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    new ArrayList<>()
            );
        }

        // Throw exception if neither Admin nor User is found
        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}
