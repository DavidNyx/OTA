package com.example.ota;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ViewHolder> {
    Context context;
    List<Score> score_list;
    public ScoreAdapter(Context context,List<Score> score_list){
        this.context=context;
        this.score_list=score_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        if(score_list!=null && score_list.size()>0){
            Score model=score_list.get(position);
            holder.SubId_tv.setText(model.getSubId());
            holder.SubName_tv.setText(model.getSubName());
            holder.min_15_1_tv.setText(model.getGrade_15_1());
            holder.min_15_2_tv.setText(model.getGrade_15_2());
            holder.min_15_3_tv.setText(model.getGrade_15_3());
            holder.min_15_4_tv.setText(model.getGrade_15_4());
            holder.min_45_1_tv.setText(model.getGrade_45_1());
            holder.min_45_2_tv.setText(model.getGrade_45_2());
            holder.Midterm_tv.setText(model.getMidterm());
            holder.Final_tv.setText(model.getFinal());
        }
        else{
            return;
        }
    }

    @Override
    public int getItemCount(){
        return score_list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView SubId_tv,SubName_tv,min_15_1_tv,min_15_2_tv,min_15_3_tv,min_15_4_tv,min_45_1_tv,min_45_2_tv,Midterm_tv,Final_tv;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            SubId_tv=itemView.findViewById(R.id.SubId_tv);
            SubName_tv=itemView.findViewById(R.id.SubName_tv);
            min_15_1_tv=itemView.findViewById(R.id.min_15_1_tv);
            min_15_2_tv=itemView.findViewById(R.id.min_15_2_tv);
            min_15_3_tv=itemView.findViewById(R.id.min_15_3_tv);
            min_15_4_tv=itemView.findViewById(R.id.min_15_4_tv);
            min_45_1_tv=itemView.findViewById(R.id.min_45_1_tv);
            min_45_2_tv=itemView.findViewById(R.id.min_45_2_tv);
            Midterm_tv=itemView.findViewById(R.id.Midterm_tv);
            Final_tv=itemView.findViewById(R.id.Final_tv);
        }
    }

}
