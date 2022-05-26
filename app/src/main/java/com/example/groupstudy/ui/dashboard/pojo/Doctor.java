package com.example.groupstudy.ui.dashboard.pojo;

public class Doctor {

    private int imageId;
    private String name;
    private String prof;
    private int age;

    public Doctor(int imageId, String name, String prof, int age) {
        this.imageId = imageId;
        this.name = name;
        this.prof = prof;
        this.age = age;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getProf() {
        return prof;
    }

    public int getAge() {
        return age;
    }
}
