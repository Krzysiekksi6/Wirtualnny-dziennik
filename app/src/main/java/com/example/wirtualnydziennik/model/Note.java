package com.example.wirtualnydziennik.model;

public class Note {
    private String category;
    private String content;
    private String date;
    private String teacher;

    public Note(){}

    public Note(String category, String content, String date, String teacher) {
        this.category = category;
        this.content = content;
        this.date = date;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return category + content + date + teacher;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeacherNote() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
