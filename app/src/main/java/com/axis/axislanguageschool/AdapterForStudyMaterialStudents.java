package com.axis.axislanguageschool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class  AdapterForStudyMaterialStudents extends RecyclerView.Adapter<AdapterForStudyMaterialStudents.Myview> {
    Context context;
    ArrayList<DataClassForVideos> arrayList;
    String video_url;

    public AdapterForStudyMaterialStudents(Context context, ArrayList<DataClassForVideos> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.video_url = video_url;
    }

    @NonNull
    @Override
    public Myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_for_videostudy_material,parent,false);
        return new Myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myview holder, @SuppressLint("RecyclerView") int position) {


        holder.t1.setText(arrayList.get(position).getDescription());
//        holder.videoView.setVideoURI(Uri.parse(arrayList.get(position).getDescription()));
//        holder.videoView.seekTo(100);

        Glide.with(context).load("https://i.ytimg.com/vi/wyhQZTOiy1A/hqdefault.jpg?sqp=-oaymwEXCNACELwBSFryq4qpAwkIARUAAIhCGAE=&rs=AOn4CLC52FPTe_IlNZINn49tuFdlSN8w6Q").into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,PlayVideoActivity.class);
                i.putExtra("Videourl",arrayList.get(position).getUrl());
                v.getContext().startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Myview extends RecyclerView.ViewHolder {

        TextView t1;
        VideoView videoView;
        ImageView img;
        public Myview(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.tt2);
            img=itemView.findViewById(R.id.imgg1n);
        }
    }
}
