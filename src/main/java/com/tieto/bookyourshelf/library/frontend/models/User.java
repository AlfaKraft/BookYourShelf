package com.tieto.bookyourshelf.library.frontend.models;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String picture;
    private String email;
    private String password;
    private String role;

    public User(long id, String firstName, String lastName, String picture,
                String email, String password, String role) {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.picture=picture;
        this.email=email;
        this.password=password;
        this.role=role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
