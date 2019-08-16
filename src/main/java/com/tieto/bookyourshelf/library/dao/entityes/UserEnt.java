package com.tieto.bookyourshelf.library.dao.entityes;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "bys_db")

public class UserEnt {
    private long id;
    private String firstName;
    private String lastName;
    private String picture;
    private String email;
    private String password;
    private String role;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEnt userEnt = (UserEnt) o;
        return id == userEnt.id &&
                Objects.equals(firstName, userEnt.firstName) &&
                Objects.equals(lastName, userEnt.lastName) &&
                Objects.equals(picture, userEnt.picture) &&
                Objects.equals(email, userEnt.email) &&
                Objects.equals(password, userEnt.password) &&
                Objects.equals(role, userEnt.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, picture, email, password, role);
    }
}
