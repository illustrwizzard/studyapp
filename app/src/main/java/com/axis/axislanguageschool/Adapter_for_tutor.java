package com.axis.axislanguageschool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_for_tutor extends RecyclerView.Adapter<Adapter_for_tutor.ViewHolder> {
    Context cc1;
    ArrayList<tutor_data_model> arrayList_tutor;

    public Adapter_for_tutor(Context context, ArrayList<tutor_data_model> arrayList_tutor) {
        this.arrayList_tutor=arrayList_tutor;
        this.cc1=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View yy= LayoutInflater.from(parent.getContext()).inflate(R.layout.tutor_card_view,parent,false);
        return new ViewHolder(yy);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.t1.setText(arrayList_tutor.get(position).getName());
        holder.t2.setText(arrayList_tutor.get(position).getAttendence());
        holder.t3.setText(arrayList_tutor.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return arrayList_tutor.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.text_tutor2);
            t2=itemView.findViewById(R.id.text_tutor4);
            t3=itemView.findViewById(R.id.text_tutor6);

        }
    }
}
