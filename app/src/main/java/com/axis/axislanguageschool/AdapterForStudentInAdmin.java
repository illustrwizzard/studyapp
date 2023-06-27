package com.axis.axislanguageschool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterForStudentInAdmin extends RecyclerView.Adapter<AdapterForStudentInAdmin.myviewholder> {

    ArrayList<DataClassForStudentDetailsInAdmin> arrayList;
    Context context;



    public AdapterForStudentInAdmin(ArrayList<DataClassForStudentDetailsInAdmin> arrayList, Context context) {
        this.arrayList=arrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public AdapterForStudentInAdmin.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_for_student_in_admin,parent,false);
        return new myviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForStudentInAdmin.myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.stu_name.setText(arrayList.get(position).getTextname());
        Glide.with(context).load(arrayList.get(position).getImg()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,Student_info_StudentTab_in_Admin.class);
                i.putExtra("studentName",arrayList.get(position).getTextname());
                i.putExtra("verify_code",arrayList.get(position).getVerify_code());
                v.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView stu_name;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.student_img);
            stu_name=itemView.findViewById(R.id.studentname);



        }
    }
}
