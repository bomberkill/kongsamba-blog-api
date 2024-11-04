package com.example.kongsambablogapi.resolvers.playlists;

import com.example.kongsambablogapi.models.playlists.Playlist;
import com.example.kongsambablogapi.models.playlists.PlaylistInput;
import com.example.kongsambablogapi.services.PlaylistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class PlaylistMutationResolver {
    @Autowired
    private PlaylistService playlistService;

    @MutationMapping
    public Playlist createPlaylist (@Argument PlaylistInput playlistInput) {
        try {
//            for (Single single : playlistInput.getSingles()) {
//                System.out.println("playlistInput: " + single.getTitle() + " " + single.getImage() + " " + single.getSingleLinks());
//                for (SingleLink link : single.getSingleLinks()) {
//                    throw new IllegalArgumentException("single link: " + link.getPlatform()+ " " + link.getLink());
//                }
//            }
            return  playlistService.createPlaylist(playlistInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " " + LocalDateTime.now());
            return null;
        }
    }

    @MutationMapping
    public Playlist updatePlaylist (@Argument String id, @Argument PlaylistInput playlistInput) {
        try {
            return playlistService.updatePlaylist(id, playlistInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " " + LocalDateTime.now());
            return null;
        }
    }
    @MutationMapping
    public Playlist updatePlaylistStatus (@Argument String id) {
        try {
            return playlistService.updatePlaylistStatus(id);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " " + LocalDateTime.now());
            return null;
        }
    }

    @MutationMapping
    public void deletePlaylist (@Argument String id) {
        try {
            playlistService.deletePlaylist(id);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + " " + LocalDateTime.now());
        }
    }
}
