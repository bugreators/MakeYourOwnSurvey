package com.bugcreators.makeyourownsurvey.Controller.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bugcreators.makeyourownsurvey.Controller.Adapters.CreateQuestionsAdapter;
import com.bugcreators.makeyourownsurvey.Controller.Adapters.ShowQuestionnaireAdapter;
import com.bugcreators.makeyourownsurvey.Model.Question;
import com.bugcreators.makeyourownsurvey.Model.QuestionairreList;
import com.bugcreators.makeyourownsurvey.R;

import java.util.ArrayList;
import java.util.List;

public class ShowQuestionnaireActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ShowQuestionnaireAdapter showQuestionnaireAdapter ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_questionnaire);

        Bundle extras = getIntent().getExtras();
        int position = extras.getInt("position");
        ArrayList<Question> questions = QuestionairreList.getQuestionairresList().get(position).getQuestionList();
        recyclerView = findViewById(R.id.recyclerViewQuestionnaire);
        layoutManager = new LinearLayoutManager(this);

        showQuestionnaireAdapter = new ShowQuestionnaireAdapter(questions);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(showQuestionnaireAdapter);
    }
}
