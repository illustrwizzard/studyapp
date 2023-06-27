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

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.ViewHolder> {
    ArrayList<DataClassForStudentAssignment> array1;
    Context c1;
    String role;
    String verify_name;

    public AssignmentAdapter(Context c1, ArrayList<DataClassForStudentAssignment> array1,String role,String verify_name) {
        this.array1 = array1;
        this.c1 = c1;
        this.role=role;
        this.verify_name=verify_name;
    }

    @NonNull
    @Override
    public AssignmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vv= LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment_batch,parent,false);
        return new ViewHolder(vv) ;
    }

    @Override
    public void onBindViewHolder(@NonNull AssignmentAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.t1.setText(array1.get(position).getAssign_name());
        holder.t2.setText(array1.get(position).getSubmitted_date());
       holder.t3.setText(array1.get(position).getBatchname());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent UU = new Intent(c1, inside_assignment_layout.class);
                    UU.putExtra("batchname_assignmnet", array1.get(position).getBatchname());
                    UU.putExtra("assignmnment_name", array1.get(position).getAssign_name());
                    UU.putExtra("submission_name", array1.get(position).getSubmitted_date());
                    UU.putExtra("link_name", array1.get(position).getLink());
                    UU.putExtra("role", role);
                    view.getContext().startActivity(UU);


            }
        });

    }

    @Override
    public int getItemCount() {
        return array1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.testname_in_student);
            t2=itemView.findViewById(R.id.submission_test_date);
            t3=itemView.findViewById(R.id.batchtest_name);
        }
    }
}
