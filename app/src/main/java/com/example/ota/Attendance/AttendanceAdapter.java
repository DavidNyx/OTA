package com.example.ota.Attendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ota.R;

import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder> {
    Context context;
    List<Attendance> attendance_list;
    public AttendanceAdapter(Context context, List<Attendance> attendance_list){
        this.context=context;
        this.attendance_list=attendance_list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_1,parent, false);
        return new AttendanceAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Attendance model=attendance_list.get(position);
        holder.SubId_tv.setText(String.valueOf(model.getSubID()));
        holder.SubName_tv.setText(model.getSubName());
        holder.Week_1_tv.setText(String.valueOf(model.getWeek1()));
        holder.Week_2_tv.setText(String.valueOf(model.getWeek2()));
        holder.Week_3_tv.setText(String.valueOf(model.getWeek3()));
        holder.Week_4_tv.setText(String.valueOf(model.getWeek4()));
        holder.Week_5_tv.setText(String.valueOf(model.getWeek5()));
        holder.Week_6_tv.setText(String.valueOf(model.getWeek6()));
        holder.Week_7_tv.setText(String.valueOf(model.getWeek7()));
        holder.Week_8_tv.setText(String.valueOf(model.getWeek8()));
        holder.Week_9_tv.setText(String.valueOf(model.getWeek9()));
        holder.Week_10_tv.setText(String.valueOf(model.getWeek10()));
    }

    @Override
    public int getItemCount(){
        return attendance_list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView SubId_tv,SubName_tv,Week_1_tv,Week_2_tv,Week_3_tv,Week_4_tv,Week_5_tv,Week_6_tv,Week_7_tv,Week_8_tv,Week_9_tv,Week_10_tv;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            SubId_tv=itemView.findViewById(R.id.SubId_tv);
            SubName_tv=itemView.findViewById(R.id.SubName_tv);
            Week_1_tv=itemView.findViewById(R.id.Week_1_tv);
            Week_2_tv=itemView.findViewById(R.id.Week_2_tv);
            Week_3_tv=itemView.findViewById(R.id.Week_3_tv);
            Week_4_tv=itemView.findViewById(R.id.Week_4_tv);
            Week_5_tv=itemView.findViewById(R.id.Week_5_tv);
            Week_6_tv=itemView.findViewById(R.id.Week_6_tv);
            Week_7_tv=itemView.findViewById(R.id.Week_7_tv);
            Week_8_tv=itemView.findViewById(R.id.Week_8_tv);
            Week_9_tv=itemView.findViewById(R.id.Week_9_tv);
            Week_10_tv=itemView.findViewById(R.id.Week_10_tv);

        }
    }

}

