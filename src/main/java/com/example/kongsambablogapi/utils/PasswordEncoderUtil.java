package com.example.kongsambablogapi.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;

import javax.crypto.SecretKey;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class PasswordEncoderUtil {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "motdepasse123"; // Your plain text password
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("Encoded password: " + encodedPassword);
        // Generate a secure key for HS512
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        // Encode the key in Base64
        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println("Base64 Encoded Key: " + base64Key);
    }
}