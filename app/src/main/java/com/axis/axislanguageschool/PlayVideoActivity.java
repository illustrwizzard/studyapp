package com.axis.axislanguageschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayVideoActivity extends AppCompatActivity {
    String url;
    VideoView videoView;

//    @Override
//    public void onBackPressed() {
//        Intent extra=getIntent();
//        if (extra.getStringExtra("Videourl")!=null){
//
//            finish();
//        }else{
//           // super.onBackPressed();
//            finish();
//
//        }
//
//
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        videoView=findViewById(R.id.videoview_id);

        Intent extra=getIntent();
        url=extra.getStringExtra("Videourl");
        videoView.setVideoURI(Uri.parse(url));
        videoView.seekTo(100);
        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);



    }
}