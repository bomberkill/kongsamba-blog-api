package com.example.kongsambablogapi.repositories;

import com.example.kongsambablogapi.models.playlists.Playlist;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends MongoRepository<Playlist, String> {
    List<Playlist> findAllByOrderByMetadataCreatedAtDesc(Pageable pageable);
    List<Playlist> findAllByPostedOrderByMetadataCreatedAtDesc(Boolean posted, Pageable pageable);
    List<Playlist> findAllByPostedOrderByMetadataCreatedAtDesc(Boolean posted);
}