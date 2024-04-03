package com.example.quiz.models;

public class Option {
    private int id;
    private int questionId;
    private String answerOptionText;

    public Option() {
    }

    public int getId() {
        return id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getAnswerOptionText() {
        return answerOptionText;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setAnswerOptionText(String answerOptionText) {
        this.answerOptionText = answerOptionText;
    }
}
