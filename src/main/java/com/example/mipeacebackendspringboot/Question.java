package com.example.mipeacebackendspringboot;

public class Question {
    private String scaleName;
    private int questionNumber;
    private String questionText;

    public Question(String scaleName, int questionNumber, String questionText) {
        this.scaleName = scaleName;
        this.questionNumber = questionNumber;
        this.questionText = questionText;
    }

    // Getters and setters

    public String getScaleName() {
        return scaleName;
    }

    public void setScaleName(String scaleName) {
        this.scaleName = scaleName;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}
