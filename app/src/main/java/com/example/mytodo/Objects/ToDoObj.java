package com.example.mytodo.Objects;

public class ToDoObj {

    String toDoTitle;
    int userID;
    boolean toDoDone;
    String toDoCreateAt, toDoUpdateAt, toDoDeleteAt;

    public ToDoObj() {
    }

    public ToDoObj(String toDoTitle, int userID, boolean toDoDone, String toDoCreateAt, String toDoUpdateAt, String toDoDeleteAt) {
        this.toDoTitle = toDoTitle;
        this.userID = userID;
        this.toDoDone = toDoDone;
        this.toDoCreateAt = toDoCreateAt;
        this.toDoUpdateAt = toDoUpdateAt;
        this.toDoDeleteAt = toDoDeleteAt;
    }

    public String getToDoTitle() {
        return toDoTitle;
    }

    public void setToDoTitle(String toDoTitle) {
        this.toDoTitle = toDoTitle;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isToDoDone() {
        return toDoDone;
    }

    public void setToDoDone(boolean toDoDone) {
        this.toDoDone = toDoDone;
    }

    public String getToDoCreateAt() {
        return toDoCreateAt;
    }

    public void setToDoCreateAt(String toDoCreateAt) {
        this.toDoCreateAt = toDoCreateAt;
    }

    public String getToDoUpdateAt() {
        return toDoUpdateAt;
    }

    public void setToDoUpdateAt(String toDoUpdateAt) {
        this.toDoUpdateAt = toDoUpdateAt;
    }

    public String getToDoDeleteAt() {
        return toDoDeleteAt;
    }

    public void setToDoDeleteAt(String toDoDeleteAt) {
        this.toDoDeleteAt = toDoDeleteAt;
    }
}
