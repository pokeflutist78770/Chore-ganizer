package com.example.aagua.hackaz2018;

/**
 * Created by roxas on 1/13/2018.
 * modified by ejara 1/13/2018
 */

public class EventNode {

    private String eventName;
    private String eventDescription;
    private String cycle;
    private int hour;
    private int minute;
    private EventNode next;
    private int totalmin;

    public EventNode(String inEventName, String inEventDescription,
                     String inCycle, int inHour, int inMinute) {

        eventName = inEventName;
        eventDescription = inEventDescription;
        cycle = inCycle; //AM or PM
        //REMEMBER TO ACCOUNT FOR 12 pm
        if(inCycle == "pm") {
           totalmin += 720; //pm
        }
        hour = inHour;
        totalmin += (hour * 60);
        minute = inMinute;
        totalmin += minute;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getCycle() {
        return cycle;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public EventNode getNext() {
        return next;
    }

    public void setEventName(String newEventName) {
        eventName = newEventName;
    }

    public void setEventDescription(String newEventDescription) {
        eventDescription = newEventDescription;
    }

    public void setCycle(String newCycle) {
        cycle = newCycle;
    }

    public void setHour(int newHour) {
        hour = newHour;
    }

    public void setMinute(int newMinute) {
        minute = newMinute;
    }

    public void setNext(EventNode newNext) {
        next = newNext;
    }

    public int getTotalMin() {
        return totalmin;
    }

    public void output() {
        System.out.println("Event Name: " + eventName + " Description: " + eventDescription +
        " Am/Pm: " + cycle + " Time: " + hour + ":" + minute);
    }
}
