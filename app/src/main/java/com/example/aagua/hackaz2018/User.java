package com.example.aagua.hackaz2018;

/**
 * Created by aagua on 1/13/2018.
 */

public class User {
    private boolean isAdmin;
    String firstName, lastName, email, phone, password;
    EventLinkedList eventList;

    //required constructor for calls to DataSnapshot.getValue(User.class)
    public User(){
        firstName=null;
        lastName=null;
        this.phone=null;
        this.email=null;
        password=null;
        isAdmin=false;
    }

    public User(String first, String last, String phone, String email, String psswd,
                boolean admin){
        firstName=first;
        lastName=last;
        this.phone=phone;
        this.email=email;
        password=psswd;
        isAdmin=admin;
    }

    public EventLinkedList getEvents(){
        return eventList;
    }

    public String getfirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPasswd() {
        return password;
    }

    public boolean isAdmin(){
        return isAdmin;
    }
}
