package com.gaurav.api.domain;

import java.util.List;

public class UserData {

    List<User> data;

    public UserData() {
    }

    public UserData(List<User> data) {
        this.data = data;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "data=" + data +
                '}';
    }
}
