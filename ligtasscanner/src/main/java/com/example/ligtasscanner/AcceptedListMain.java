package com.example.ligtasscanner;

import java.util.List;

public class AcceptedListMain {

    String date;
    List<AcceptedListContent> acceptedListContentList;

    public AcceptedListMain() {

    }

    public AcceptedListMain(String date, List<AcceptedListContent> acceptedListContentList) {
        this.date = date;
        this.acceptedListContentList = acceptedListContentList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<AcceptedListContent> getAcceptedListContentList() {
        return acceptedListContentList;
    }

    public void setAcceptedListContentList(List<AcceptedListContent> acceptedListContentList) {
        this.acceptedListContentList = acceptedListContentList;
    }
}
