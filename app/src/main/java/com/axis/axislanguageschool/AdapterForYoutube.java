package com.axis.axislanguageschool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterForYoutube extends RecyclerView.Adapter<AdapterForYoutube.ViewHolder> {
    String batch;
    ArrayList<data_for_video> arrayList;
    Context context;
    String date;

    public AdapterForYoutube(Context context, String batch, ArrayList<data_for_video> arrayList2, String thisDate) {
        this.batch=batch;
        this.context=context;
        arrayList=arrayList2;
        date=thisDate;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_for_videos_youtube_upload,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                holder.batch.setText(arrayList.get(position).getBatch());
                holder.url.setText(arrayList.get(position).getType());
                holder.date.setText(arrayList.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            TextView batch,url,date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            batch=itemView.findViewById(R.id.batch_name_v_y);
            url=itemView.findViewById(R.id.batch_url_v_y);
            date=itemView.findViewById(R.id.batch_date_v_y);


        }
    }
}
