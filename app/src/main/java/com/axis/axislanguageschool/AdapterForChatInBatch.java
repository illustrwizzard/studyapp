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

public class AdapterForChatInBatch extends RecyclerView.Adapter<AdapterForChatInBatch.MyviewHolder> {


    Context context;
    ArrayList<AdminDataClass> arrayList;
    String verify_code;


    public AdapterForChatInBatch(Context context, ArrayList<AdminDataClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AdapterForChatInBatch.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_for_chat_in_batch,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForChatInBatch.MyviewHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.batchName.setText(arrayList.get(position).getBatchName());
        holder.DateofJoining.setText(arrayList.get(position).getDateOfJoininig());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,ShowBatchInChat.class);
                i.putExtra("BatchName",arrayList.get(position).getBatchName());
                i.putExtra("DateofJoininig",arrayList.get(position).getDateOfJoininig());
                v.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView batchName,DateofJoining;
        public MyviewHolder(@NonNull View itemView) {

            super(itemView);

            batchName=itemView.findViewById(R.id.batchname_id1);
            DateofJoining=itemView.findViewById(R.id.DateOfJOINING1);


        }
    }
}
