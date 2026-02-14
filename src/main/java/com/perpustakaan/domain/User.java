package com.perpustakaan.domain;

public class User {
    private String username;
    private boolean isLoggedIn;
    private boolean hasActiveSubscription;
    private int age;

    public User(String username, boolean isLoggedIn, boolean hasActiveSubscription, int age) {
        this.username = username;
        this.isLoggedIn = isLoggedIn;
        this.hasActiveSubscription = hasActiveSubscription;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    public boolean hasActiveSubscription() {
        return hasActiveSubscription;
    }
    public int getAge() {
        return age;
    }
}


