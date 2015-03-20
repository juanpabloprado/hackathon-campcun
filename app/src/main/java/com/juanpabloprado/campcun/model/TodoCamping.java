package com.juanpabloprado.campcun.model;

/**
 * Created by Juan on 3/20/2015.
 */
public class TodoCamping {
    private String mTodo;
    private boolean mIsDone;

    public TodoCamping(String todo, boolean isDone) {
        mTodo = todo;
        mIsDone = isDone;
    }

    public String getTodo() {
        return mTodo;
    }

    public void setTodo(String todo) {
        mTodo = todo;
    }

    public boolean isDone() {
        return mIsDone;
    }

    public void setDone(boolean isDone) {
        mIsDone = isDone;
    }
}
