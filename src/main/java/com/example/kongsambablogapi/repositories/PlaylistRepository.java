package com.example.kongsambablogapi.repositories;

import com.example.kongsambablogapi.models.playlists.Playlist;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends MongoRepository<Playlist, String> {
}