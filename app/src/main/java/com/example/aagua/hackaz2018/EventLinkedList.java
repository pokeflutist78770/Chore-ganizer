package com.example.aagua.hackaz2018;

/**
 * Created by roxas on 1/13/2018.
 * modified by ejara 1/13/2018
 */

public class EventLinkedList {

    EventNode head;

    public EventLinkedList() {
        head = null;
    }

//////////////////////////////////////
    public EventNode tempdontkeep() {
        return head;
    }
/////////////////////////////////////


    public void push(String eventName, String eventDescription, String cycle, int hour, int minute) {
        EventNode current = new EventNode(eventName, eventDescription, cycle, hour, minute);
        EventNode temp = head;
        EventNode holder;

      
        if (head == null) {
            head = current;      
        } 
        else if(current.getTotalMin()<head.getTotalMin()){
            current.setNext(head);
            head=current;
        }
        else if(current.getTotalMin()>head.getTotalMin() && head.getNext()==null){
            head.setNext(current);
        }
        else {
            while(temp != null) {
                
                if(temp.getNext()!=null && 
                    temp.getNext().getTotalMin() >= current.getTotalMin()) {

                    current.setNext(temp.getNext());
                    temp.setNext(current);
                    return;
                }
                temp=temp.getNext();
            }
        }
    }

    //test later, no way to test rn
    public void pop(String eventName) {
        if (head != null) {
            if (head.getEventName().equals(eventName)) {
                head = head.getNext();
            }
            else {
                EventNode current = head;
                while (current.getNext() != null &&
                            !current.getNext().getEventName().equals(eventName)) {
                    current = current.getNext();
                }
                if (current.getNext() != null) {
                    current.setNext(current.getNext().getNext());
                }
            }
        }
    }

}