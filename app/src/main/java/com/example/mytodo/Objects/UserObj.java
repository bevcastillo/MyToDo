package com.example.mytodo.Objects;

public class UserObj {
    int userID;
    String name, username, passw;

    public UserObj() {
    }

    public UserObj(int userID, String name, String username, String passw) {
        this.userID = userID;
        this.name = name;
        this.username = username;
        this.passw = passw;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }
}
