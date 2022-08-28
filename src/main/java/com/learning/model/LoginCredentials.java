package com.learning.model;

import javax.validation.constraints.NotNull;

public class LoginCredentials {

    @NotNull
    private String userName;
    @NotNull
    private String password;

    public LoginCredentials() {
    }

    public LoginCredentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
