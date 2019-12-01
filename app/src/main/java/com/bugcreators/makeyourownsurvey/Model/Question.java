package com.bugcreators.makeyourownsurvey.Model;

public class Question {
    private int itemNumber;
    private String questionText;

    public Question(int itemNumber, String questionText) {
        this.itemNumber = itemNumber;
        this.questionText = questionText;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}
