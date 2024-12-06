package com.example.kongsambablogapi.repositories;

import com.example.kongsambablogapi.models.events.Event;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findAllByPostedOrderByMetadataCreatedAtDesc(Boolean posted);
}