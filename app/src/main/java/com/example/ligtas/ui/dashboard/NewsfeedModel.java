package com.example.ligtas.ui.dashboard;

public class NewsfeedModel {

    String title, dateposted, newsfeedId;

    public NewsfeedModel() {}

    public NewsfeedModel(String title, String dateposted, String newsfeedId) {
        this.title = title;
        this.dateposted = dateposted;
        this.newsfeedId = newsfeedId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateposted() {
        return dateposted;
    }

    public void setDateposted(String dateposted) {
        this.dateposted = dateposted;
    }

    public String getNewsfeedId() {
        return newsfeedId;
    }

    public void setNewsfeedId(String newsfeedId) {
        this.newsfeedId = newsfeedId;
    }
}
