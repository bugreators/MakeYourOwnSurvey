package com.bugcreators.makeyourownsurvey.Controller.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bugcreators.makeyourownsurvey.Model.Question;
import com.bugcreators.makeyourownsurvey.Model.Questionairre;
import com.bugcreators.makeyourownsurvey.Model.QuestionairreList;
import com.bugcreators.makeyourownsurvey.R;

import java.util.ArrayList;

public class StartAnsweringActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_answering);

        button = findViewById(R.id.startSurveyButton);
        textView = findViewById(R.id.startSurveyQuestionsNumber);

        ArrayList<Question> questions = new ArrayList<>();
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

        Questionairre questionairre = QuestionairreList.getQuestionairresList().get(0);

        textView.setText("Questions: " + questionairre.getQuestionList().size());

        final Intent intent = new Intent(this, AnswerQuestionnaireActivity.class);
        intent.putExtra("position", 0);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
