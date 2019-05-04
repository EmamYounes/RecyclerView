package com.example.smartec.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartec.recyclerview.R;
import com.example.smartec.recyclerview.data.DataBase;
import java.util.List;

/**
 * Created by Smartec on 3/18/2018.
 */

public class DataBaseAdapter extends RecyclerView.Adapter<DataBaseAdapter.ViewHolder> {

    Context context;
    List<DataBase> dataBaseList;
    public DataBaseAdapter(Context context, List<DataBase> dataBaseList) {
        this.context = context;
        this.dataBaseList = dataBaseList;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView questionTextView;
        TextView answerTextView;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            questionTextView =itemView.findViewById(R.id.question_txt_id);
            answerTextView=itemView.findViewById(R.id.answer_txt_id);
            cardView=itemView.findViewById(R.id.card_view_id2);

        }
    }
    @Override
    public DataBaseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom_data_view,parent,false);
        return new DataBaseAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.questionTextView.setText(dataBaseList.get(position).getQuestion());
        holder.answerTextView.setText(dataBaseList.get(position).getAnswer());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,""+dataBaseList.get(position).getId(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBaseList.size();
    }
}
