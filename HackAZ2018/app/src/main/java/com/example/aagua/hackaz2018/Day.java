package com.example.aagua.hackaz2018;

/**
 * Created by roxas on 1/13/2018.
 */

//HashMap to store days.

public class Day {

    private EventLinkedList events;


    public Day() {
        events = new EventLinkedList();
    }

    public EventLinkedList getEvents() {
        return events;
    }
}
