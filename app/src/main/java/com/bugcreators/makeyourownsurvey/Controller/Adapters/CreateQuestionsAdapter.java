package com.bugcreators.makeyourownsurvey.Controller.Adapters;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bugcreators.makeyourownsurvey.Model.Question;
import com.bugcreators.makeyourownsurvey.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class CreateQuestionsAdapter extends RecyclerView.Adapter<CreateQuestionsAdapter.CreateQuestionsViewHolder> {
    public ArrayList<Question> QuestionList;

    public class CreateQuestionsViewHolder extends RecyclerView.ViewHolder {
        private TextInputLayout textInputLayout;

        public CreateQuestionsViewHolder(@NonNull View itemView) {
            super(itemView);
            textInputLayout = itemView.findViewById(R.id.newQuestionTextInputLayout);
            textInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    QuestionList.get(getAdapterPosition()).setQuestionText(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
            textInputLayout.setEndIconOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    QuestionList.remove(getAdapterPosition());
                    for (int i = 0; i < QuestionList.size(); i++) {
                        QuestionList.get(i).setItemNumber(i+1);
                    }
                    notifyItemRemoved(getAdapterPosition());
                    notifyItemRangeChanged(getAdapterPosition(), QuestionList.size());
                }
            });
        }

    }

    public CreateQuestionsAdapter(ArrayList<Question> questions) {
        QuestionList = questions;
    }

    @NonNull
    @Override
    public CreateQuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_create_question, parent, false);
        CreateQuestionsViewHolder createQuestionsViewHolder = new CreateQuestionsViewHolder(view);
        return createQuestionsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CreateQuestionsViewHolder holder, final int position) {
        final Question question = QuestionList.get(position);
        holder.textInputLayout.getEditText().setText(question.getQuestionText());
    }

    @Override
    public int getItemCount() {
        return QuestionList.size();
    }

}
