package com.example.wirtualnydziennik.model;

public class Frequency {
    private String date;
    private String dayOfWeek;
    private String numberLesson;
    private String status;
    private String teacher;
    private String time;

    public Frequency(){}

    public Frequency(String date, String dayOfWeek, String numberLesson, String status, String teacher, String time) {
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.numberLesson = numberLesson;
        this.status = status;
        this.teacher = teacher;
        this.time = time;
    }

    @Override
    public String toString() {
        return date + "/" + dayOfWeek + "/" + numberLesson + "/" +
                status + "/" + teacher + "/" + time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getNumberLesson() {
        return numberLesson;
    }

    public void setNumberLesson(String numberLesson) {
        this.numberLesson = numberLesson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTeacherFrequency() {
        return teacher;
    }

    public void setTeacherFrequency(String teacher) {
        this.teacher = teacher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
