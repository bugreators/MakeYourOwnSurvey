package com.bugcreators.makeyourownsurvey.Controller.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bugcreators.makeyourownsurvey.Model.Question;
import com.bugcreators.makeyourownsurvey.R;

import java.util.ArrayList;

public class ShowQuestionnaireAdapter extends RecyclerView.Adapter<ShowQuestionnaireAdapter.ShowQuestionnaireViewHolder> {
    public ArrayList<Question> questions = new ArrayList<>();

    public class ShowQuestionnaireViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNumberOfQuestion;
        TextView textViewQuestion;

        public ShowQuestionnaireViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNumberOfQuestion = itemView.findViewById(R.id.questionNumber);
            textViewQuestion = itemView.findViewById(R.id.question);
        }
    }

    public ShowQuestionnaireAdapter(ArrayList<Question> questions) {
        this.questions = questions;
    }

    @NonNull
    @Override
    public ShowQuestionnaireViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_question, parent, false);
        ShowQuestionnaireViewHolder showQuestionnaireViewHolder = new ShowQuestionnaireViewHolder(view);
        return showQuestionnaireViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShowQuestionnaireViewHolder holder, int position) {
        final Question question = questions.get(position);
        holder.textViewNumberOfQuestion.setText(Integer.toString(question.getItemNumber()) + ". ");
        holder.textViewQuestion.setText(question.getQuestionText());
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }


}
