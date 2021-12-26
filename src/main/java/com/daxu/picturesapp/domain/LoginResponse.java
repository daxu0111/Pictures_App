package com.daxu.picturesapp.domain;

public class LoginResponse {
    private int code;
    private String token;
    private String state;
    private User user;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "code=" + code +
                ", token='" + token + '\'' +
                ", state='" + state + '\'' +
                ", user=" + user +
                '}';
    }
}
