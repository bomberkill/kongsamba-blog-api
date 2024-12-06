package com.example.kongsambablogapi.models.events;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events")
public  class Event {

    @Id
    private String id;
    private boolean posted;
    private EventInput eventInput;
    private Metadata metadata;


    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public EventInput getEventInput() {
        return eventInput;
    }

    public void setEventInput(EventInput eventInput) {
        this.eventInput = eventInput;
    }

    public boolean getPosted() {
        return posted;
    }

    public void setPosted(boolean posted) {
        this.posted = posted;
    }
}