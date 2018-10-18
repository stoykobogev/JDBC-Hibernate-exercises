package org.softuni.fdmc.data.models;

public class User {

    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.setUsername(username);
        this.setPassword(password);
        this.setRole(role);
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
