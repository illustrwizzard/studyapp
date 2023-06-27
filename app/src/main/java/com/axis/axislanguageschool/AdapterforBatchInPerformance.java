package com.axis.axislanguageschool;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AdapterforBatchInPerformance extends RecyclerView.Adapter<AdapterforBatchInPerformance.myviewholder> {

    Context context;
    ArrayList<DataModelClass_Batch_In_PerformanceAdmin> arrayList;

    public AdapterforBatchInPerformance(Context context, ArrayList<DataModelClass_Batch_In_PerformanceAdmin> arrayList) {
        this.arrayList=arrayList;
        this.context=context;

    }

    @NonNull
    @Override
    public AdapterforBatchInPerformance.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_for_show_batch_in_performance,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterforBatchInPerformance.myviewholder holder, int position) {

        holder.batchname.setText(arrayList.get(position).getBatchname());
        holder.bachdate.setText(arrayList.get(position).getJoiningDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,Tutor_perf_for_tutor_login.class);
                v.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView batchname,bachdate;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            batchname=itemView.findViewById(R.id.BatchName_id_id1);
            bachdate=itemView.findViewById(R.id.Batchdate);

        }
    }
}
