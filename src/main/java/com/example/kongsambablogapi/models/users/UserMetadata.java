package com.example.kongsambablogapi.models.users;

import java.util.ArrayList;
import java.util.List;

public class UserMetadata {
    private List<String> views;
    private List<String> likes;

    public UserMetadata() {
        this.likes = new ArrayList<>();
        this.views = new ArrayList<>();
    }

    public List<String> getViews() {
        return views;
    }

    public void setViews(List<String> views) {
        this.views = views;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }
}