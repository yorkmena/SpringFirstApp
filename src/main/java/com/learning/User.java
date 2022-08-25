package com.learning;

import javax.validation.constraints.NotNull;

public class User {

    @NotNull
    private  String usernameName;
    @NotNull
    private  String password;


    public String getUsernameName() {
        return usernameName;
    }

    public void setUsernameName(String usernameName) {
        this.usernameName = usernameName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
