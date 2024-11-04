package com.example.kongsambablogapi.models.playlists;

public enum StreamingPlatform {
    YOUTUBEMUSIC("youtube music"),
    YOUTUBE("youtube"),
    SPOTIFY("spotify"),
    DEEZER("deezer"),
    APPLEMUSIC("apple music"),
    BOOMPLAY("boomplay");

    private final String value;

    StreamingPlatform (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}