package com.axis.axislanguageschool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AdapterForTutorInAdmin extends RecyclerView.Adapter<AdapterForTutorInAdmin.viewholder> {
    Context context;
    ArrayList<DataClassForTutorInAdmin> arrayList;

    public AdapterForTutorInAdmin(Context context, ArrayList<DataClassForTutorInAdmin> arrayList) {
        this.arrayList=arrayList;
        this.context=context;

    }

    @NonNull
    @Override
    public AdapterForTutorInAdmin.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_for_tutor_in_admin,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForTutorInAdmin.viewholder holder, int position) {
        holder.tutorname.setText(arrayList.get(position).getTutor_name());
        Glide.with(context).load(arrayList.get(position).getTutor_img()).into(holder.tutor_img);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView tutorname;
        ImageView tutor_img;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            tutor_img=itemView.findViewById(R.id.tutor_img);
            tutorname=itemView.findViewById(R.id.tutorname);

        }
    }
}
