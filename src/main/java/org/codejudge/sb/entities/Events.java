package org.codejudge.sb.entities;

import java.util.ArrayList;

public class Events {
    
    private ArrayList<Event> events;

    public Events() {
        events = new ArrayList<Event>();
    }


    public void addEvent(Event event) {
        this.events.add(event);
    }

    
}
