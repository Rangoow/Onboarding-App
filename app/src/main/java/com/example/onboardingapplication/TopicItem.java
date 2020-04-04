package com.example.onboardingapplication;


public class TopicItem {

    String TopicTitle, TopicDescription;
    int TopicScreenImg;



     public TopicItem(String title, String description, int screenImg){
         this.TopicTitle = title;
         this.TopicDescription = description;
         this.TopicScreenImg = screenImg;


     }

    public String getTopicTitle() {
        return TopicTitle;
    }

    public void setTopicTitle(String title) {
        this.TopicTitle = title;
    }

    public String getTopicDescription() {
        return TopicDescription;
    }

    public void setTopicDescription(String description) {
        this.TopicDescription = description;
    }

    public int getTopicScreenImg() {
        return TopicScreenImg;
    }

    public void setTopicScreenImg(int screenImg) {
        this.TopicScreenImg = screenImg;
    }


}
