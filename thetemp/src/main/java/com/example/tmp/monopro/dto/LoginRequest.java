package com.example.tmp.monopro.dto;

public class LoginRequest {
    private String usermail;
    private String password;


    public LoginRequest(String usermail, String password) {
        this.usermail = usermail;
        this.password = password;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}