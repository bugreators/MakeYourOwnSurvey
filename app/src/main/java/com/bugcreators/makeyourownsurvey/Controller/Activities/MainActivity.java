package com.bugcreators.makeyourownsurvey.Controller.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.bugcreators.makeyourownsurvey.Controller.Fragments.SurveysFragment;
import com.bugcreators.makeyourownsurvey.Controller.Fragments.RecipientsFragment;
import com.bugcreators.makeyourownsurvey.Controller.Fragments.ReportsFragment;
import com.bugcreators.makeyourownsurvey.Model.Question;
import com.bugcreators.makeyourownsurvey.Model.Questionairre;
import com.bugcreators.makeyourownsurvey.Model.QuestionairreList;
import com.bugcreators.makeyourownsurvey.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private RecyclerView QuestionsRecyclerView;
    private RecyclerView.Adapter QuestionsAdapter;
    private RecyclerView.LayoutManager LayoutManager;
    private BottomNavigationView bottomNavigationView;
    private ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new SurveysFragment()).commit();
        questions = new ArrayList<>();
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
        QuestionairreList.AddQuestionairreList(new Questionairre("Default Template", questions));
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
//    ArrayList<Question> questions = new ArrayList<>();
//        questions.add(new Question("1:", "how much u like the job"));
//        questions.add(new Question("2:", "how much u respect Boby"));
//        questions.add(new Question("3:", "how much u respect Jacob"));
//        questions.add(new Question("1:", "how much u like the job"));
//        questions.add(new Question("2:", "how much u respect Boby"));
//        questions.add(new Question("3:", "how much u respect Jacob"));
//
//        QuestionsRecyclerView = findViewById(R.id.recyclerViewCreateQuestions);
//        LayoutManager = new LinearLayoutManager(this);
//        QuestionsAdapter = new CreateQuestionsAdapter(questions);
//
//        QuestionsRecyclerView.setLayoutManager(LayoutManager);
//        QuestionsRecyclerView.setAdapter(QuestionsAdapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.surveys:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new SurveysFragment()).commit();
                return true;
            case R.id.reports:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new ReportsFragment()).commit();
                return true;
            case R.id.recipients:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new RecipientsFragment()).commit();
                return true;
        }
        return false;
    }
}
