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

public class BatchAdapter extends RecyclerView.Adapter<BatchAdapter.ViewHolder> {
    private ArrayList<batchModel> arrayList;
    SQLB sqlb;
    Context context;

    public BatchAdapter(Context context, ArrayList<batchModel> arrayList1) {
        this.context=context;
      arrayList=arrayList1;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.batches_rv,parent,false);
        sqlb=new SQLB(context);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.t1.setText(arrayList.get(position).getCourse_title());
        //holder.t2.setText(arrayList.get(position).getApp_name());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sqlb.getrole().equals("Admin")){
                    Intent o=new Intent(context,ShowStudentsFromTutorBatch.class);
                    o.putExtra("batchname_from_adapter",arrayList.get(position).getCourse_title());

                    view.getContext().startActivity(o);
                }else if(sqlb.getrole().equals("Tutor")){
                    Intent o=new Intent(context,ShowStudentsFromTutorBatch.class);
                    o.putExtra("batchname_from_adapter",arrayList.get(position).getCourse_title());

                    view.getContext().startActivity(o);

                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.textbatch);
            t2=itemView.findViewById(R.id.textbatch1);
        }
    }
}
