package com.bugcreators.makeyourownsurvey.Model;

import java.util.ArrayList;
import java.util.List;

public class Questionairre {
    private String questionairreName;
    private ArrayList<Question> questionList;

    public Questionairre(String questionairreName, ArrayList<Question> questionList) {
        this.questionairreName = questionairreName;
        this.questionList = questionList;
    }

    public String getQuestionairreName() {
        return questionairreName;
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }
}
