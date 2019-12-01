package com.bugcreators.makeyourownsurvey.Controller.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bugcreators.makeyourownsurvey.Model.Question;
import com.bugcreators.makeyourownsurvey.Model.QuestionairreList;
import com.bugcreators.makeyourownsurvey.R;

public class AnswerQuestionnaireActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textViewQuestion;
    TextView textViewQuestionNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_questionnaire);

        Bundle extras = getIntent().getExtras();
        int position = extras.getInt("position");
        Question question = QuestionairreList.getQuestionairresList().get(0).getQuestionList().get(position);
        int size = QuestionairreList.getQuestionairresList().get(0).getQuestionList().size();
        textViewQuestion = findViewById(R.id.answerQuestionTextView);
        textViewQuestionNumber = findViewById(R.id.answerQuestionNumberTextView);
        radioGroup = findViewById(R.id.radioGroup);
        textViewQuestion.setText(question.getQuestionText());
        textViewQuestionNumber.setText(Integer.toString(question.getItemNumber()) + ". ");
        Button buttonApply = findViewById(R.id.button_apply);
        final Intent intent = new Intent(this, AnswerQuestionnaireActivity.class);
        final boolean flag = position == size - 1;
        if (flag) {
            buttonApply.setText("Finish Survey");
            buttonApply.setTextColor(Color.RED);
            buttonApply.setBackgroundResource(R.drawable.shape_rounded_red);
        }
        intent.putExtra("position", position + 1);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                if (flag) {
                    finishAffinity();
                    System.exit(0);
                }
                radioButton = findViewById(radioId);
                startActivity(intent);
            }
        });
    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this, "Selected Answer: " + radioButton.getText(),
                Toast.LENGTH_SHORT).show();
    }
}
