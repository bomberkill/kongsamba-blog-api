package com.example.kongsambablogapi.models.admins;

public class AuthResponse {

    private String userId;
    private String token;
//    private  Long expiration;

//    public Long getExpiration() {
//        return expiration;
//    }
//
//    public void setExpiration(Long expiration) {
//        this.expiration = expiration;
//    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}