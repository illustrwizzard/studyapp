package com.axis.axislanguageschool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdapterForVideos extends RecyclerView.Adapter<AdapterForVideos.Myviewholder> {
    Context context;
    ArrayList<DataClassForVideos> arrayList;
    String video_url;



    public AdapterForVideos(Context context, ArrayList<DataClassForVideos> arrayList) {
        this.arrayList=arrayList;
        this.context=context;


    }
    private String getYouTubeId (String youTubeUrl) {
        String pattern = "(?<=youtu.be/|watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(youTubeUrl);
        if(matcher.find()){
            return matcher.group();
        } else {
            return "error";
        }
    }


    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_for_videos,parent,false);
        //arrayList=new ArrayList<>();
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForVideos.Myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.t1.setText(arrayList.get(position).getDescription());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.isMemoryCacheable();
        video_url=getYouTubeId(arrayList.get(position).getUrl());
        Glide.with(context).setDefaultRequestOptions(requestOptions).load("https://img.youtube.com/vi/"+video_url+"/0.jpg").into(holder.videoView);

//        holder.videoView.setImageBitmap(ThumbnailUtils.createVideoThumbnail("https://www.youtube.com/watch?v=ewmMQtAzvQ0",
//                MediaStore.Video.Thumbnails.MICRO_KIND));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,YoutubeActivity.class);
                i.putExtra("Videourl",video_url);
                v.getContext().startActivity(i);
            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        TextView t1;
        ImageView videoView;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.tt1);
            videoView=itemView.findViewById(R.id.imgg1);



        }
    }
}
