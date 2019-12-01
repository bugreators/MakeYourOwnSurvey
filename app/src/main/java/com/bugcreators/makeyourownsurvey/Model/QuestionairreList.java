package com.bugcreators.makeyourownsurvey.Model;

import java.util.ArrayList;
import java.util.List;

public class QuestionairreList {
    private static ArrayList<Questionairre> questionairreList = new ArrayList<>();

    public static void AddQuestionairreList(Questionairre questionairre){
        questionairreList.add(questionairre);
    }

    public static ArrayList<Questionairre> getQuestionairresList() {
        return questionairreList;
    }
}
