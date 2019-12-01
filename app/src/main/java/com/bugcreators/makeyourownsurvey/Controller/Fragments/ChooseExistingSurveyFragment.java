package com.bugcreators.makeyourownsurvey.Controller.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bugcreators.makeyourownsurvey.Controller.Activities.ShowQuestionnaireActivity;
import com.bugcreators.makeyourownsurvey.Controller.Adapters.ShowListOfQuestionnairesAdapter;
import com.bugcreators.makeyourownsurvey.Controller.Adapters.ShowQuestionnaireAdapter;
import com.bugcreators.makeyourownsurvey.Model.Question;
import com.bugcreators.makeyourownsurvey.Model.Questionairre;
import com.bugcreators.makeyourownsurvey.Model.QuestionairreList;
import com.bugcreators.makeyourownsurvey.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseExistingSurveyFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ShowListOfQuestionnairesAdapter showListOfQuestionnairesAdapter;
    public ChooseExistingSurveyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_existing_survey, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<Questionairre> questionairres = QuestionairreList.getQuestionairresList();
        recyclerView = view.findViewById(R.id.recyclerViewQuestionnaireList);
        layoutManager = new LinearLayoutManager(getActivity());
        showListOfQuestionnairesAdapter = new ShowListOfQuestionnairesAdapter(questionairres, getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(showListOfQuestionnairesAdapter);

    }
}
