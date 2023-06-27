package com.axis.axislanguageschool;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_for_Assign_in_performance extends RecyclerView.Adapter<Adapter_for_Assign_in_performance.ViewHolder> {
    ArrayList<Assign_modal_data_in_performance> arrayList;

    public Adapter_for_Assign_in_performance(ArrayList<Assign_modal_data_in_performance> arrayList) {
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_for_assign_in_performance,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.T1.setText(arrayList.get(position).getAssignment_name());
            holder.T2.setText(arrayList.get(position).getSubmitted_date());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView T1,T2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            T1=itemView.findViewById(R.id.name_txt_assign);
            T2=itemView.findViewById(R.id.date_txt_assign);
        }
    }
}
