package com.example.ligtasscanner;

public class AcceptedListContent {

    String fullName;
    String idNumber;

    public AcceptedListContent() {

    }

    public AcceptedListContent(String fullName, String idNumber) {
        this.fullName = fullName;
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
