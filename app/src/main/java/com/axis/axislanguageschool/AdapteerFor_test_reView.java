package com.axis.axislanguageschool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapteerFor_test_reView extends RecyclerView.Adapter<AdapteerFor_test_reView.ViewHolder> {
    ArrayList<test_model_class> arrayList_test;
    Context c1test;

    public AdapteerFor_test_reView(Context context, ArrayList<test_model_class> arrayList_test) {
         c1test=context;
         this.arrayList_test=arrayList_test;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_card_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.t1.setText(arrayList_test.get(position).getTestdate());
        holder.T5.setText(arrayList_test.get(position).getListening_mark());
        holder.T6.setText(arrayList_test.get(position).getSpeaking_mark());
        holder.T7.setText(arrayList_test.get(position).Reading_mark);



    }

    @Override
    public int getItemCount() {
        return arrayList_test.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3,t4,T5,T6,T7;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            t1=itemView.findViewById(R.id.date);
            t2=itemView.findViewById(R.id.Listening);
            t3=itemView.findViewById(R.id.Speaking);
            t4=itemView.findViewById(R.id.Reading);

            T5=itemView.findViewById(R.id.testmark);
            T6=itemView.findViewById(R.id.testmark2);
            T7=itemView.findViewById(R.id.testmark3);



        }
    }
}
