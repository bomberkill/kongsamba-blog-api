package com.example.kongsambablogapi.resolvers.events;

import com.example.kongsambablogapi.models.articles.Article;
import com.example.kongsambablogapi.models.events.Event;
import com.example.kongsambablogapi.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EventQueryResolver {

    @Autowired
    private EventService eventService;

    @QueryMapping
    public List<Event> getAllEvents (@Argument Boolean posted) {
        return eventService.getAllEvents(posted);
    };

    @QueryMapping
    public Event getEventById (@Argument String id) {
        return eventService.getEventById(id).orElse(null);
    }
}