package com.bugcreators.makeyourownsurvey.Controller.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bugcreators.makeyourownsurvey.Controller.Activities.ShowQuestionnaireActivity;
import com.bugcreators.makeyourownsurvey.Model.Questionairre;
import com.bugcreators.makeyourownsurvey.Model.QuestionairreList;
import com.bugcreators.makeyourownsurvey.R;

import java.util.ArrayList;

public class ShowListOfQuestionnairesAdapter extends RecyclerView.Adapter<ShowListOfQuestionnairesAdapter.ShowListOfQuestionnairesViewHolder> {
    public ArrayList<Questionairre> questionairres = new ArrayList<>();
    public Context context;

    public class ShowListOfQuestionnairesViewHolder extends RecyclerView.ViewHolder {
        TextView textViewQuestionairreName;
        TextView textViewQuestionairreSize;

        public ShowListOfQuestionnairesViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewQuestionairreName = itemView.findViewById(R.id.surveyName);
            textViewQuestionairreSize = itemView.findViewById(R.id.surveyQuestionsNumber);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ShowQuestionnaireActivity.class);
                    intent.putExtra("position", getAdapterPosition());
                    context.startActivity(intent);

                }
            });
        }
    }

    public ShowListOfQuestionnairesAdapter(ArrayList<Questionairre> list, Context context) {
        this.questionairres = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ShowListOfQuestionnairesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_questionairre, parent, false);
        ShowListOfQuestionnairesViewHolder showQuestionnaireViewHolder = new ShowListOfQuestionnairesViewHolder(view);
        return showQuestionnaireViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShowListOfQuestionnairesViewHolder holder, int position) {
        final Questionairre questionairre = questionairres.get(position);
        holder.textViewQuestionairreName.setText(questionairre.getQuestionairreName());
        holder.textViewQuestionairreSize.setText("Questions: " + Integer.toString(questionairre.getQuestionList().size()));
    }

    @Override
    public int getItemCount() {
        return questionairres.size();
    }


}
