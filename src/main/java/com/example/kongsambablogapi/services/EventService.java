package com.example.kongsambablogapi.services;

import com.example.kongsambablogapi.exception.RequestException;
import com.example.kongsambablogapi.models.articles.Article;
import com.example.kongsambablogapi.models.events.Event;
import com.example.kongsambablogapi.models.events.EventInput;
import com.example.kongsambablogapi.models.events.Metadata;
import com.example.kongsambablogapi.repositories.AdminRepository;
import com.example.kongsambablogapi.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AdminRepository adminRepository;

    public List<Event> getAllEvents (Boolean posted) {
        if (posted != null) {
            return eventRepository.findAllByPostedOrderByMetadataCreatedAtDesc(posted);
        }
        return eventRepository.findAll();
    }
    public Optional<Event> getEventById (String id) { return eventRepository.findById(id);}
    public void deleteEvent (String id) { eventRepository.deleteById(id);}
    public Event createEvent (EventInput eventInput) {
        if (adminRepository.existsById(eventInput.getAuthor())) {
            Metadata metadata = new Metadata();
            metadata.setCreatedAt(LocalDateTime.now());
            Event event = new Event();
            event.setEventInput(eventInput);
            event.setMetadata(metadata);
            event.setPosted(false);
            return eventRepository.save(event);
        }
        System.out.println("Error when creating: Author not found" + " " + LocalDateTime.now());
        throw new RequestException("Error when creating: Author not found");
    }
    public Event updateEvent (String id, EventInput eventInput) {
        if (eventRepository.existsById(id)) {
            Optional<Event> eventOpt = eventRepository.findById(id);
            if (eventOpt.isPresent()) {
                Event existingEvent = eventOpt.get();
                eventInput.setAuthor(existingEvent.getEventInput().getAuthor());
                existingEvent.setEventInput(eventInput);
                existingEvent.getMetadata().setUpdatedAt(LocalDateTime.now());
                return eventRepository.save(existingEvent);
            }
        };
        System.out.println("Error when updating: Event not found" + " " + LocalDateTime.now());
        throw new RequestException("Error when updating: Event not found");
    }
    public Event updateEventStatus (String id) {
        if (eventRepository.existsById(id)) {
            Optional<Event> eventOpt = eventRepository.findById(id);
            if (eventOpt.isPresent()) {
                Event existingEvent = eventOpt.get();
                existingEvent.setPosted(!existingEvent.getPosted());
                return eventRepository.save(existingEvent);
            }
        };
        System.out.println("Error when updating: Event not found" + " " + LocalDateTime.now());
        throw new RequestException("Error when updating: Event not found");
    }
}