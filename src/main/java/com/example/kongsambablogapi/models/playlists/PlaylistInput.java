package com.example.kongsambablogapi.models.playlists;

import java.util.ArrayList;
import java.util.List;

public class PlaylistInput {
    private String title;
    private  String description;
    private String image;
    private String author;
    private List<Single> singles;

    public PlaylistInput() {
        this.singles = new ArrayList<Single>();
    }

    public List<Single> getSingles() {
        return singles;
    }

    public void setSingles(List<Single> singles) {
        this.singles = singles;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}