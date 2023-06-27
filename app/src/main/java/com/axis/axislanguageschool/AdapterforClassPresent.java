package com.axis.axislanguageschool;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterforClassPresent extends RecyclerView.Adapter<AdapterforClassPresent.ViewHolder> {
      ArrayList<classPresent_data_modal> arrayList;

    public AdapterforClassPresent(ArrayList<classPresent_data_modal> arrayList) {
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardforclasspresent,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.t1.setText(arrayList.get(position).getPresent_date());
        holder.t2.setText(arrayList.get(position).getPresent_status());



        //int th= Integer.parseInt(arrayList.get(position).getDuration());
      // float total_hours=((float) th/(float) 3600);
       // Log.w("gggggggggggg", String.valueOf(total_hours));
        //hour_attend.setText(String.valueOf(total_hours));
        //holder.t3.setText(String.valueOf(total_hours));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.present_date);
            t2=itemView.findViewById(R.id.present_status);


        }
    }
}
