package com.example.kongsambablogapi.models.playlists;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Metadata {
//    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<String> views;
    private List<String> likes;

    public Metadata() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = null;
        this.views = new ArrayList<>();
        this.likes = new ArrayList<>();
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public List<String> getViews() {
        return views;
    }

    public void setViews(List<String> views) {
        this.views = views;
    }
    public void addView (String userId) {
        if (!views.contains(userId)){
            views.add(userId);
        }
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }
    public void addLike (String userId) {
        if (!likes.contains(userId)){
            likes.add(userId);
        }
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}