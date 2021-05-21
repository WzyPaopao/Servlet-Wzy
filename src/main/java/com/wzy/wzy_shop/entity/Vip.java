package com.wzy.wzy_shop.entity;

import java.io.Serializable;

public class Vip implements Serializable {
    private String username;
    private String password;
    private String name;
    private String gender;
    private String profile;
    private String salt;

    public Vip() {}

    public Vip(String username, String password, String gender) {
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public Vip(String username, String password, String gender, String salt) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.salt = salt;
    }

    public Vip(String username, String password, String name, String gender, String profile) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "Vip {" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", profile='" + profile + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
