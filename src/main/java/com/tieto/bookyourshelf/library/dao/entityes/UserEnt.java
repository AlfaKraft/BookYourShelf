package com.tieto.bookyourshelf.library.dao.entityes;

import com.tieto.bookyourshelf.library.validation.ValidEmail;

import javax.persistence.*;

@Entity
@Table(name="USERS", schema = "bys_db")
public class UserEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "picture")
    private String picture;
    @Column(name = "email")
    @ValidEmail
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

    public UserEnt(String firstName, String lastName, String picture, String email, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.picture = picture;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public UserEnt(){

    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPicture() {
        return picture;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
