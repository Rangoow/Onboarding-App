package com.example.onboardingapplication;

import android.transition.Scene;

public class TopicItem {

    String Title, Description;
    int ScreenImg;

     public TopicItem(String title, String description, int screenImg){
         Title = title;
         Description = description;
         ScreenImg = screenImg;
     }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getScreenImg() {
        return ScreenImg;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }






}
