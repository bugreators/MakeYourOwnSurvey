package com.bugcreators.makeyourownsurvey.Controller.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.bugcreators.makeyourownsurvey.Controller.Fragments.SurveysFragment;
import com.bugcreators.makeyourownsurvey.Controller.Fragments.RecipientsFragment;
import com.bugcreators.makeyourownsurvey.Controller.Fragments.ReportsFragment;
import com.bugcreators.makeyourownsurvey.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private RecyclerView QuestionsRecyclerView;
    private RecyclerView.Adapter QuestionsAdapter;
    private RecyclerView.LayoutManager LayoutManager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new SurveysFragment()).commit();
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
