package com.example.kongsambablogapi.models.playlists;

public class SingleLink {
    private String link;
    private StreamingPlatform platform;

    public StreamingPlatform getPlatform() {
        return platform;
    }

    public void setPlatform(StreamingPlatform platform) {
        this.platform = platform;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}