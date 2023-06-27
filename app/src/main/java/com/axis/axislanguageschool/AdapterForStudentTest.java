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

public class AdapterForStudentTest extends RecyclerView.Adapter<AdapterForStudentTest.myviewholder> {
    ArrayList<DataClassForStudentAssignment> array1;
    Context context;
    String verify_name;

    public AdapterForStudentTest(ArrayList<DataClassForStudentAssignment> array1, Context context,String verify_name)
    {
        this.array1 = array1;
        this.context = context;
        this.verify_name=verify_name;
    }

    @NonNull
    @Override
    public AdapterForStudentTest.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.student_test_recycle,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForStudentTest.myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.testname.setText(array1.get(position).getAssign_name());
        holder.batchname.setText(array1.get(position).getBatchname());
        holder.submissiondate.setText(array1.get(position).getSubmitted_date());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inn=new Intent(context,Get_Test_For_Students.class);
                inn.putExtra("batchnameTest",array1.get(position).getBatchname());
                inn.putExtra("testname",array1.get(position).getAssign_name());
                inn.putExtra("linktest",array1.get(position).getLink());
                inn.putExtra("verify_name_get",verify_name);
                inn.putExtra("submission_date",array1.get(position).getSubmitted_date());
                v.getContext().startActivity(inn);
            }
        });

    }

    @Override
    public int getItemCount() {
        return array1.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView testname,batchname,submissiondate;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            testname=itemView.findViewById(R.id.testname_in_student1);
            batchname=itemView.findViewById(R.id.batchtest_name1);
            submissiondate=itemView.findViewById(R.id.submission_test_date1);

        }
    }
}
