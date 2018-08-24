package com.deepaksharma.webaddicted.databinding.ui.recyclerActivity;

import android.databinding.BaseObservable;


public class ProfileModel extends BaseObservable {
    private String name;
    private String age;
    private String description;
    private String img;

    public ProfileModel(String name, String age, String description, String img) {
        this.name = name;
        this.age = age;
        this.description = description;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
