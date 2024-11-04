package com.example.kongsambablogapi.services;

import com.example.kongsambablogapi.models.playlists.Metadata;
import com.example.kongsambablogapi.models.playlists.Playlist;
import com.example.kongsambablogapi.models.playlists.PlaylistInput;
import com.example.kongsambablogapi.models.playlists.Single;
import com.example.kongsambablogapi.repositories.AdminRepository;
import com.example.kongsambablogapi.repositories.PlaylistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private AdminRepository adminRepository;

    public List<Playlist> getAllPlaylists () {
        return playlistRepository.findAll();
    }
    public Optional<Playlist> getPlaylistById (String id) {
        return  playlistRepository.findById(id);
    }
    public void deletePlaylist (String id) {
        playlistRepository.deleteById(id);
    }
    public Playlist createPlaylist (PlaylistInput playlistInput) {
        if (adminRepository.findById(playlistInput.getAuthor()).isEmpty()) {
            throw new IllegalArgumentException("Error when creating : Author " + playlistInput.getAuthor() + " not found");
        }
        for (Single single: playlistInput.getSingles()) {
            if (single.getSingleLinks().isEmpty()) {
                throw new IllegalArgumentException("Error when creating: singles links cannot be null ou empty " + single.getImage() + " " + single.getTitle() + " " + single.getSingleLinks());
            }
        }
        Metadata metadata = new Metadata();
        metadata.setCreatedAt(LocalDateTime.now());
        Playlist playlist = new Playlist();
        playlist.setPosted(false);
        playlist.setMetadata(metadata);
        playlist.setPlaylistInput(playlistInput);
        return playlistRepository.save(playlist);
    }
    public Playlist updatePlaylist (String id, PlaylistInput playlistInput) {
        if (playlistRepository.existsById(id)) {
            Optional<Playlist> playlistOpt = playlistRepository.findById(id);
            if (playlistOpt.isPresent()) {
                Playlist existingPlaylist = playlistOpt.get();
                existingPlaylist.getMetadata().setUpdatedAt(LocalDateTime.now());
                playlistInput.setAuthor(existingPlaylist.getPlaylistInput().getAuthor());
                existingPlaylist.setPlaylistInput(playlistInput);
                return playlistRepository.save(existingPlaylist);
            }
        }
        throw new IllegalArgumentException("Error when updating: playlist " + id + " not found");
    }
    public Playlist updatePlaylistStatus (String id) {
        if (playlistRepository.existsById(id)) {
            Optional<Playlist> playlistOpt = playlistRepository.findById(id);
            if (playlistOpt.isPresent()) {
                Playlist existingPlaylist = playlistOpt.get();
                Boolean posted = !existingPlaylist.getPosted();
                existingPlaylist.setPosted(posted);
                return playlistRepository.save(existingPlaylist);
            }
        }
        throw new IllegalArgumentException("Error when updating status: playlist " + id + " not found");
    }
}