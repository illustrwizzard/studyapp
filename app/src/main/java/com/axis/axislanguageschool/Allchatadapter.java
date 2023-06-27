package com.axis.axislanguageschool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Allchatadapter extends RecyclerView.Adapter {
    ArrayList <Reciever>arrayList ;
    Context context;

    public Allchatadapter(ArrayList<Reciever> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;


    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.chatrecycle,parent,false);
        return new VieH(view) ;
    }

    class VieH extends RecyclerView.ViewHolder{

TextView txt;
        public VieH(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.chattext);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        VieH vieH = (VieH) holder;
        vieH.txt.setText(arrayList.get(position).getName());

        vieH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,ChatActivity.class);
                i.putExtra("reciever_code",arrayList.get(position).getUsercode());
                i.putExtra("reciever_name",arrayList.get(position).getName());
                i.putExtra("reciever_role",arrayList.get(position).getRole());
               v.getContext().startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
