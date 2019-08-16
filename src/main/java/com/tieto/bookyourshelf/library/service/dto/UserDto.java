package com.tieto.bookyourshelf.library.service.dto;

public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String picture;
    private String email;
    private String password;
    private String role;


    public int getId() {
        return id;
    }
    public void setId(int id) {
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


    @Override
    public String toString() { return "UserDto{" + "id=" + id +", firstName=" + firstName;}
}
