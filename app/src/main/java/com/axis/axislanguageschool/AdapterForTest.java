package com.axis.axislanguageschool;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterForTest extends RecyclerView.Adapter<AdapterForTest.Myviewholder> {

    ArrayList<String>arrayList,arrayList1;
    int count=1;

    public AdapterForTest(ArrayList<String> arrayList, ArrayList<String> arrayList1) {
        this.arrayList=arrayList;
        this.arrayList1=arrayList1;
    }


    @NonNull
    @Override
    public AdapterForTest.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.test_recycle,parent,false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForTest.Myviewholder holder, int position) {
        Log.w("vvvvcccvcvcccv", String.valueOf(position));

        holder.t1.setText(position+1  +". "+ arrayList1.get(position));
        //count++;


    }

    @Override
    public int getItemCount() {
        return arrayList1.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        TextView t1;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.gettextvc);

        }
    }
}
