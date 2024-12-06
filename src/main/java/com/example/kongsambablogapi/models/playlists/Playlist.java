package com.example.kongsambablogapi.models.playlists;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "playlists")
public class Playlist {

    @Id
    private String id;
    private Boolean posted;
    private Metadata metadata;
    private PlaylistInput playlistInput;

    public PlaylistInput getPlaylistInput() {
        return playlistInput;
    }

    public void setPlaylistInput(PlaylistInput playlistInput) {
        this.playlistInput = playlistInput;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Boolean getPosted() {
        return posted;
    }

    public void setPosted(Boolean posted) {
        this.posted = posted;
    }
}