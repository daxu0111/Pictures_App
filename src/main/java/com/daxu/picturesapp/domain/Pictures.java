package com.daxu.picturesapp.domain;

public class Pictures {

    private int pid;
    private String url;
    private int liked;
    private String picturename;
    private String username;
    private boolean isCollect;

    public int getPid() {
        return pid;
    }

    public String getUrl() {
        return url;
    }

    public int getLiked() {
        return liked;
    }

    public String getPicturename() {
        return picturename;
    }

    public String getUsername() {
        return username;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public void setPicturename(String picturename) {
        this.picturename = picturename;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isCollect() {
        return isCollect;
    }

    public void setCollect(boolean collect) {
        isCollect = collect;
    }

    @Override
    public String toString() {
        return "Pictures{" +
                "pid=" + pid +
                ", url='" + url + '\'' +
                ", liked=" + liked +
                ", picturename='" + picturename + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
