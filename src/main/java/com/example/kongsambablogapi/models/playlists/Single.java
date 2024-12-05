package com.example.kongsambablogapi.models.playlists;

import java.util.ArrayList;
import java.util.List;

public  class Single {
    private String title;
//    private String image;
    private List<SingleLink> singleLinks;

    public Single() {
        this.singleLinks = new ArrayList<SingleLink>();
    }

    public List<SingleLink> getSingleLinks() {
        return singleLinks;
    }

    public void setSingleLinks(List<SingleLink> singleLinks) {
        this.singleLinks = singleLinks;
    }

//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}