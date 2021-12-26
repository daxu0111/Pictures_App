package com.daxu.picturesapp.domain;

public class liked {

    private String pid;
    private String username;

    public String getPid() {
        return pid;
    }

    public String getUsername() {
        return username;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "liked{" +
                "pid='" + pid + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
