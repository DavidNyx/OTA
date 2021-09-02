package com.example.ota.Fee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ota.R;

import java.util.List;

public class fee_adapter extends RecyclerView.Adapter<fee_adapter.ViewHolder> {
    Context context;
    List<fee> fee_list;
    public fee_adapter(Context context, List<fee> fee_list){
        this.context=context;
        this.fee_list=fee_list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fee_item_layout,parent, false);
        return new fee_adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        fee model=fee_list.get(position);
        holder.content_tv.setText("- " + model.getContent());
        holder.title_tv.setText("" + model.getTitle());
    }

    @Override
    public int getItemCount(){
        return fee_list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView content_tv, title_tv;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title_tv=itemView.findViewById(R.id.fee_titleId);
            content_tv=itemView.findViewById(R.id.fee_contentId);
        }
    }

}
