package com.example.ota.ViewGrade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ota.ViewGrade.GradeModel;
import com.example.ota.R;

import java.util.List;



public class GradeAdapter extends RecyclerView.Adapter<GradeAdapter.ViewHolder> {
    Context context;
    List<GradeModel> grade_list;
    public GradeAdapter(Context context, List<GradeModel> grade_list){
        this.context=context;
        this.grade_list=grade_list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grade_layout,parent, false);
        return new GradeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GradeAdapter.ViewHolder holder, int position){
        GradeModel model=grade_list.get(position);
        holder.StudentName_tv.setText(model.getStudentName());
        holder.phut_15_1_tv.setText(String.valueOf(model.getGrade_15_1()));
        holder.phut_15_2_tv.setText(String.valueOf(model.getGrade_15_2()));
        holder.phut_15_3_tv.setText(String.valueOf(model.getGrade_15_3()));
        holder.phut_15_4_tv.setText(String.valueOf(model.getGrade_15_4()));
        holder.phut_45_1_tv.setText(String.valueOf(model.getGrade_45_1()));
        holder.phut_45_2_tv.setText(String.valueOf(model.getGrade_45_2()));
        holder.giuaki_tv.setText(String.valueOf(model.getMidterm()));
        holder.cuoiki_tv.setText(String.valueOf(model.getFinal()));
    }

    @Override
    public int getItemCount(){
        return grade_list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView StudentName_tv,phut_15_1_tv,phut_15_2_tv,phut_15_3_tv,phut_15_4_tv,phut_45_1_tv,phut_45_2_tv,giuaki_tv,cuoiki_tv;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            StudentName_tv=itemView.findViewById(R.id.StudentName_tv);
            phut_15_1_tv=itemView.findViewById(R.id.phut_15_1_tv);
            phut_15_2_tv=itemView.findViewById(R.id.phut_15_2_tv);
            phut_15_3_tv=itemView.findViewById(R.id.phut_15_3_tv);
            phut_15_4_tv=itemView.findViewById(R.id.phut_15_4_tv);
            phut_45_1_tv=itemView.findViewById(R.id.phut_45_1_tv);
            phut_45_2_tv=itemView.findViewById(R.id.phut_45_2_tv);
            giuaki_tv=itemView.findViewById(R.id.giuaki_tv);
            cuoiki_tv=itemView.findViewById(R.id.cuoiki_tv);
        }
    }
}
