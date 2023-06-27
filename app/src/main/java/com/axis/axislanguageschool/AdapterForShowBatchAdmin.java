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

public class AdapterForShowBatchAdmin extends RecyclerView.Adapter<AdapterForShowBatchAdmin.MyviewHolder> {
    Context context;
    ArrayList<StudentDetailsDataClass> arrayList;


    public AdapterForShowBatchAdmin(Context context, ArrayList<StudentDetailsDataClass> arrayList) {
        this.context=context;
        this.arrayList=arrayList;

    }

    @NonNull
    @Override
    public AdapterForShowBatchAdmin.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_show_admin_batch,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForShowBatchAdmin.MyviewHolder holder, int position) {
        holder.BatchName_id_id.setText(arrayList.get(position).getBatchname().toUpperCase());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                v.getContext().startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        TextView BatchName_id_id;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            BatchName_id_id=itemView.findViewById(R.id.BatchName_id_id);
        }
    }
}
