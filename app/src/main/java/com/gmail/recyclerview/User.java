package com.gmail.recyclerview;

public class User {
    private String name;
    private String phone;

    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", phone='" + phone + '\'' + '}';
    }
}
