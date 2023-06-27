package com.axis.axislanguageschool;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_for_tutor_performance extends RecyclerView.Adapter<Adapter_for_tutor_performance.ViewHolder> {
    ArrayList<tutor_stu_model> arrayList;

    public Adapter_for_tutor_performance(ArrayList<tutor_stu_model> arrayList) {
        this.arrayList=arrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_for_tutor_perfom_tutor_login,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.T1.setText(arrayList.get(position).getStuname());
         holder.T2.setText(arrayList.get(position).getStu_date_of_joing());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(view.getContext(),Student_perfromance_activity_for_tutor_login.class);
                view.getContext().startActivity(i);


            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
          TextView T1,T2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            T1=itemView.findViewById(R.id.textname);
            T2=itemView.findViewById(R.id.textjoing2);


        }
    }
}
