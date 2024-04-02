package com.example.quiz.models;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private int id;
    private int quizId; // Add this property
    private String questionText;
    private List<Option> options;

    public Question() {
    }

    public int getId() {
        return id;
    }

    public int getQuizId() {
        return quizId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }


    /*-----*/

    public void addOption(Option option) {
        if (options == null) {
            options = new ArrayList<>();
        }
        options.add(option);
    }
}
