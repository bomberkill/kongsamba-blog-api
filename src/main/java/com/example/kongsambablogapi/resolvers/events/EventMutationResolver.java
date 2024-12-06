package com.example.kongsambablogapi.resolvers.events;

import com.example.kongsambablogapi.models.events.Event;
import com.example.kongsambablogapi.models.events.EventInput;
import com.example.kongsambablogapi.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class EventMutationResolver {

    @Autowired
    private EventService eventService;

    @MutationMapping
    public Event createEvent (@Argument EventInput eventInput) {
        return eventService.createEvent(eventInput);
    }
    @MutationMapping
    public Event updateEvent (@Argument String id, @Argument EventInput eventInput) {
        return eventService.updateEvent(id, eventInput);
    }
    @MutationMapping
    public Event updateEventStatus (@Argument String id) {
        return eventService.updateEventStatus(id);
    }
    @MutationMapping
    public void deleteEvent (@Argument String id) {
        eventService.deleteEvent(id);
    }
}