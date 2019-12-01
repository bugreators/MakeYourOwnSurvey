package com.bugcreators.makeyourownsurvey.Controller.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bugcreators.makeyourownsurvey.Controller.Adapters.CreateQuestionsAdapter;
import com.bugcreators.makeyourownsurvey.Model.Question;
import com.bugcreators.makeyourownsurvey.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateNewSurveyFragment extends Fragment implements FloatingActionButton.OnClickListener {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CreateQuestionsAdapter questionsAdapter;
    private FloatingActionButton floatingActionButton;
    private ArrayList<Question> questions = new ArrayList<>();
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
        floatingActionButton = view.findViewById(R.id.floating_action_button);
        questions.add(new Question(serialNumber++, ""));
        recyclerView = view.findViewById(R.id.recyclerViewCreateQuestions);
        layoutManager = new LinearLayoutManager(getActivity());
        questionsAdapter = new CreateQuestionsAdapter(questions);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(questionsAdapter);

        floatingActionButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        questions.add(new Question(serialNumber++, ""));
        questionsAdapter.notifyDataSetChanged();
    }
}
