package com.notes.iit.simplenotesmanager;


public class User {
    public int id;
    public String email;
    public String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

}