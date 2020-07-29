package com.cts.com.cts.security.service.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

public class UserRegistrationDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;

    @NotEmpty
    private String mobile;

    @NotEmpty
    private String gender;

    @AssertTrue
    private Boolean terms;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getTerms() {
        return terms;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTerms(Boolean terms) {
        this.terms = terms;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}