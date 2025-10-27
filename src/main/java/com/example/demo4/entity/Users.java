package com.example.demo4.entity;

public class Users {
    private Long id;
    private String userId; // unique username/email

    public Users() {}

    public Users(Long id, String userId) {
        this.id = id;
        this.userId = userId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
}

