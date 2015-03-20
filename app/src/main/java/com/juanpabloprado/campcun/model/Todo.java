package com.juanpabloprado.campcun.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Juan on 3/20/2015.
 */
public class Todo implements Parcelable {
    private String mTodo;
    private boolean mIsDone;

    public Todo(String todo, boolean isDone) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTodo);
        dest.writeValue(mIsDone);
    }

    private Todo(Parcel in) {
        mTodo = in.readString();
        mIsDone = (boolean) in.readValue(null);
    }

    public Todo() { }

    public static final Creator<Todo> CREATOR = new Creator<Todo>() {
        @Override
        public Todo createFromParcel(Parcel source) {
            return new Todo(source);
        }

        @Override
        public Todo[] newArray(int size) {
            return new Todo[size];
        }
    };
}
