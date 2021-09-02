package com.example.ota.ViewAttendance;

import android.annotation.SuppressLint;
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



public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder> {
    Context context;
    List<AttendanceModel> attendance_list;
    public AttendanceAdapter(Context context, List<AttendanceModel> attendance_list){
        this.context=context;
        this.attendance_list=attendance_list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_layout,parent, false);
        return new AttendanceAdapter.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AttendanceAdapter.ViewHolder holder, int position) {
        AttendanceModel model = attendance_list.get(position);
        holder.StudentID_tv.setText(model.getStudentID());
        holder.StudentName_tv.setText(model.getStudentName());
        holder.week_1_tv.setText(String.valueOf(model.getWeek1()));
        holder.week_2_tv.setText(String.valueOf(model.getWeek2()));
        holder.week_3_tv.setText(String.valueOf(model.getWeek3()));
        holder.week_4_tv.setText(String.valueOf(model.getWeek4()));
        holder.week_5_tv.setText(String.valueOf(model.getWeek5()));
        holder.week_6_tv.setText(String.valueOf(model.getWeek6()));
        holder.week_7_tv.setText(String.valueOf(model.getWeek7()));
        holder.week_8_tv.setText(String.valueOf(model.getWeek8()));
        holder.week_9_tv.setText(String.valueOf(model.getWeek9()));
        holder.week_10_tv.setText(String.valueOf(model.getWeek10()));
    }

    @Override
    public int getItemCount(){ return attendance_list.size(); }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView StudentID_tv, StudentName_tv,week_1_tv,week_2_tv,week_3_tv,week_4_tv,week_5_tv,week_6_tv,week_7_tv,week_8_tv,week_9_tv,week_10_tv;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            StudentID_tv=itemView.findViewById(R.id.StudentID_tv);
            StudentName_tv=itemView.findViewById(R.id.StudentName_tv);
            week_1_tv=itemView.findViewById(R.id.week_1_tv);
            week_2_tv=itemView.findViewById(R.id.week_2_tv);
            week_3_tv=itemView.findViewById(R.id.week_3_tv);
            week_4_tv=itemView.findViewById(R.id.week_4_tv);
            week_5_tv=itemView.findViewById(R.id.week_5_tv);
            week_6_tv=itemView.findViewById(R.id.week_6_tv);
            week_7_tv=itemView.findViewById(R.id.week_7_tv);
            week_8_tv=itemView.findViewById(R.id.week_8_tv);
            week_9_tv=itemView.findViewById(R.id.week_9_tv);
            week_10_tv=itemView.findViewById(R.id.week_10_tv);

        }
    }
}
