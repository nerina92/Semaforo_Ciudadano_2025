package com.example.semaforociudadano;

import java.util.UUID;

public class User {
    private int id;
    private String name;
    private String user;
    private String password;
    private String state;
    private String type;

    public User(int id, String name, String user, String password, String state, String type) {
        this.id =id;//Integer.valueOf(UUID.randomUUID().toString());
        this.name = name;
        this.user = user;
        this.password = password;
        this.state = state;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getState() {
        return state;
    }

    public String getType() {
        return type;
    }
}