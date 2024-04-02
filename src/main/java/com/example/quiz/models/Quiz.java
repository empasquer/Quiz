package com.example.quiz.models;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private int id;
    private String title;
    private String description;
    private int duration;
    private List<Question> questions;

    public Quiz() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


    /*-------*/

    public void addQuestion(Question question) {
        if (questions == null) {
            questions = new ArrayList<>();
        }
        questions.add(question);
    }
}
