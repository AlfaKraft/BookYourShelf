package com.tieto.bookyourshelf.library.service.dto;

import com.tieto.bookyourshelf.library.validation.PasswordsEqualConstraint;
import com.tieto.bookyourshelf.library.validation.ValidEmail;
import com.tieto.bookyourshelf.library.validation.ValidPassword;

import javax.validation.constraints.NotEmpty;

@PasswordsEqualConstraint(baseField = "password", matchField = "matchingPassword", message = "Passwords have to match")
public class UserDto {

    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    private String picture;

    @ValidEmail
    private String email;
    @NotEmpty
    @ValidPassword
    private String password;
    @NotEmpty
    private String matchingPassword;
    private String role;

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

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {this.matchingPassword = matchingPassword;}

    public void setRole(String role) {
        this.role = role;
    }
}
