package com.axis.axislanguageschool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_for_Student extends RecyclerView.Adapter<Adapter_for_Student.ViewHolder> {

    Context cc1;
    ArrayList<Student_data_model> arrayList_stu;

    public Adapter_for_Student(Context context, ArrayList<Student_data_model> arrayList_stu) {

        this.cc1=context;
        this.arrayList_stu=arrayList_stu;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View yy= LayoutInflater.from(parent.getContext()).inflate(R.layout.student_card_rv,parent,false);
        return new ViewHolder(yy);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.t1.setText(arrayList_stu.get(position).STUname);
        holder.t2.setText(arrayList_stu.get(position).STUbatch);
        holder.t3.setText(arrayList_stu.get(position).STUPhone);
        holder.t4.setText(arrayList_stu.get(position).STUAttendence);
    }

    @Override
    public int getItemCount() {

        return arrayList_stu.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView t1,t2,t3,t4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            t1=itemView.findViewById(R.id.text_tutor2);
            t2=itemView.findViewById(R.id.text_tutor4);
            t3=itemView.findViewById(R.id.text_tutor6);
            t4=itemView.findViewById(R.id.text_tutor8);

        }
    }
}
