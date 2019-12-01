package com.bugcreators.makeyourownsurvey.Controller.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.bugcreators.makeyourownsurvey.Controller.Activities.ShowQuestionnaireActivity;
import com.bugcreators.makeyourownsurvey.Controller.Adapters.CreateQuestionsAdapter;
import com.bugcreators.makeyourownsurvey.Model.Question;
import com.bugcreators.makeyourownsurvey.Model.Questionairre;
import com.bugcreators.makeyourownsurvey.Model.QuestionairreList;
import com.bugcreators.makeyourownsurvey.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateNewSurveyFragment extends Fragment implements FloatingActionButton.OnClickListener {
    private Button saveButton;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CreateQuestionsAdapter questionsAdapter;
    private FloatingActionButton floatingActionButton;
    private ArrayList<Question> questions;
    private int serialNumber = 1;


    public CreateNewSurveyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_new_survey, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        questions = new ArrayList<>();
        floatingActionButton = view.findViewById(R.id.floating_action_button);
        saveButton = view.findViewById(R.id.saveButton);
        questions.add(new Question(serialNumber++, ""));
        recyclerView = view.findViewById(R.id.recyclerViewCreateQuestions);
        layoutManager = new LinearLayoutManager(getActivity());
        questionsAdapter = new CreateQuestionsAdapter(questions);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(questionsAdapter);

        floatingActionButton.setOnClickListener(this);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questions.size() > 0) {
                    boolean flag = true;
                    for (Question question : questions) {
                        if (question.getQuestionText().isEmpty()) {
                            Toast.makeText(getActivity(), "Please fill the empty field before saving the survey", Toast.LENGTH_LONG).show();
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        QuestionairreList.AddQuestionairreList(new Questionairre("Just Created", questions));
                        Intent intent = new Intent(getActivity(), ShowQuestionnaireActivity.class);
                        intent.putExtra("position", QuestionairreList.getQuestionairresList().size() - 1);
                        startActivity(intent);
                        questions = new ArrayList<>();
                        questions.add(new Question(1, ""));
                        questionsAdapter = new CreateQuestionsAdapter(questions);
                        recyclerView.setAdapter(questionsAdapter);
                    }
                } else {
                    Toast.makeText(getActivity(), "Please enter at least 1 question", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (questions.size() == 0) {
            serialNumber = 1;
        }
        boolean flag = true;
        for (Question question : questions) {
            if (question.getQuestionText().isEmpty()) {
                Toast.makeText(getActivity(), "Please fill the empty field before adding new question", Toast.LENGTH_LONG).show();
                flag = false;
                break;
            }
        }
        if (flag) {
            questions.add(new Question(serialNumber++, ""));
            questionsAdapter.notifyDataSetChanged();
        }
    }
}
