package com.example.kongsambablogapi.resolvers.playlists;

import com.example.kongsambablogapi.models.playlists.Playlist;
import com.example.kongsambablogapi.services.PlaylistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public  class PlaylistQueryResolver {
    @Autowired
    private PlaylistService playlistService;

    @QueryMapping
    public List<Playlist> getAllPlaylists () {
        return playlistService.getAllPlaylists();
    }

    @QueryMapping
    public Playlist getPlaylistById (@Argument String id) {
        return playlistService.getPlaylistById(id).orElse(null);
    }
}