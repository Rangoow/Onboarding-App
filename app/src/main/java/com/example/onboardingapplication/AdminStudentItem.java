package com.example.onboardingapplication;

public class AdminStudentItem {

    private String name;
    private String location;
    private String job;
    private int img;

    public AdminStudentItem(){
    }

    public AdminStudentItem(String name, String location, String job, int img) {
        this.name = name;
        this.location = location;
        this.job = job;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getJob() {
        return job;
    }

    public int getImg() {
        return img;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setImg(int logo) {
        this.img = logo;
    }
}
