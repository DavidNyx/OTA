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

public class score_adapter extends RecyclerView.Adapter<score_adapter.ViewHolder> {
    Context context;
    List<score> score_list;
    public score_adapter(Context context, List<score> score_list){
        this.context=context;
        this.score_list=score_list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent, false);
        return new score_adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
            score model=score_list.get(position);
            holder.SubId_tv.setText(String.valueOf(model.getSubId()));
            holder.SubName_tv.setText(model.getSubName());
            holder.phut_15_1_tv.setText(String.valueOf(model.getGrade_15_1()));
            holder.phut_15_2_tv.setText(String.valueOf(model.getGrade_15_2()));
            holder.phut_15_3_tv.setText(String.valueOf(model.getGrade_15_3()));
            holder.phut_15_4_tv.setText(String.valueOf(model.getGrade_15_4()));
            holder.phut_45_1_tv.setText(String.valueOf(model.getGrade_45_1()));
            holder.phut_45_2_tv.setText(String.valueOf(model.getGrade_45_2()));
            holder.giuaki_tv.setText(String.valueOf(model.getGiuaki()));
            holder.cuoiki_tv.setText(String.valueOf(model.getCuoiki()));
    }

    @Override
    public int getItemCount(){
        return score_list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView SubId_tv,SubName_tv,phut_15_1_tv,phut_15_2_tv,phut_15_3_tv,phut_15_4_tv,phut_45_1_tv,phut_45_2_tv,giuaki_tv,cuoiki_tv;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            SubId_tv=itemView.findViewById(R.id.SubId_tv);
            SubName_tv=itemView.findViewById(R.id.SubName_tv);
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
