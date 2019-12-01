package com.bugcreators.makeyourownsurvey.Controller.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bugcreators.makeyourownsurvey.Controller.Adapters.CreateQuestionsAdapter;
import com.bugcreators.makeyourownsurvey.Controller.Adapters.ShowQuestionnaireAdapter;
import com.bugcreators.makeyourownsurvey.Model.Question;
import com.bugcreators.makeyourownsurvey.R;

import java.util.ArrayList;

public class ShowQuestionnaireActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ShowQuestionnaireAdapter showQuestionnaireAdapter ;
    private ArrayList<Question> questions = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_questionnaire);

        recyclerView = findViewById(R.id.recyclerViewQuestionnaire);
        layoutManager = new LinearLayoutManager(this);
        questions.add(new Question(1, "On a scale of 1 to 10, how happy are you at work?"));
        questions.add(new Question(2, "On a scale of 1 to 10, how challenged do you on a daily basis at work?"));
        questions.add(new Question(3, "On a scale of 1 to 10, how would you rate your work-life balance?"));
        questions.add(new Question(4, "On a scale of 1 to 10, how good is your direct supervisor at recognizing your contributions at work?"));
        questions.add(new Question(5, "How transparent is the management team?"));
        questions.add(new Question(6, "Do you feel respected by your direct supervisor?"));
        questions.add(new Question(7, "Has a manager given you any recognition in the past month?"));
        questions.add(new Question(8, "Are you proud to work for our organization?"));
        questions.add(new Question(9, "Are we a better organization now than we were 6 months ago?"));
        questions.add(new Question(10, "What do you see in our organization's future?"));
        showQuestionnaireAdapter = new ShowQuestionnaireAdapter(questions);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(showQuestionnaireAdapter);
    }
}
