package com.example.ligtas.ui.stayHealthy;

public class WaterIntakeDetails {

    String Goal, Progress, Current;

    public WaterIntakeDetails() {}

    public WaterIntakeDetails(String goal, String progress, String current) {
        Goal = goal;
        Progress = progress;
        Current = current;
    }

    public String getGoal() {
        return Goal;
    }

    public void setGoal(String goal) {
        Goal = goal;
    }

    public String getProgress() {
        return Progress;
    }

    public void setProgress(String progress) {
        Progress = progress;
    }

    public String getCurrent() {
        return Current;
    }

    public void setCurrent(String current) {
        Current = current;
    }
}
