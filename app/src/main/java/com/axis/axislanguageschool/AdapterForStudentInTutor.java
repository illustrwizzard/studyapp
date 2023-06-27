package com.axis.axislanguageschool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterForStudentInTutor extends RecyclerView.Adapter<AdapterForStudentInTutor.myviewholder> {
    ArrayList<DataClassForStudentInTutor>arrayList;
    Context context;
    String batchname;

    public AdapterForStudentInTutor(ArrayList<DataClassForStudentInTutor> arrayList, Context context, String batchname) {
        this.arrayList = arrayList;
        this.context = context;
        this.batchname=batchname;
    }

    @NonNull
    @Override
    public AdapterForStudentInTutor.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.recycle_for_students_in_tutor,parent,false);

        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForStudentInTutor.myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.count.setText(String.valueOf(position+1+" ."));
        holder.name.setText(arrayList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,Student_info_StudentTab_in_Admin.class);
                i.putExtra("studentName",arrayList.get(position).getName());
                i.putExtra("verify_code",arrayList.get(position).getVerif_id());

                i.putExtra("batchname_get",batchname);
                v.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class myviewholder extends RecyclerView.ViewHolder {
        TextView count,name;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            count=itemView.findViewById(R.id.countnum);
            name=itemView.findViewById(R.id.nameofstudent);
        }
    }
}
