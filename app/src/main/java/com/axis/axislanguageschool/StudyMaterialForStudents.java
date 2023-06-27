package com.axis.axislanguageschool;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudyMaterialForStudents extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<DataClassForVideos> arrayList;
    LinearLayoutManager linearLayoutManager;
    VideoView videoView;
    AdapterForStudyMaterialStudents adapterForVideos;


    String video_url="http://video.axisjobs.in/a.3gpp";
    SQLB sqlb;
    String batch;




    public void get_video(String batch){
        RequestQueue que = Volley.newRequestQueue(this);
        StringRequest req = new StringRequest(Request.Method.POST, video_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String > map= new HashMap<>();
                map.put("batch",batch);

                return map;

            }
        };



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_material_for_students);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        recyclerView=findViewById(R.id.recyclerforstudymaterial);
        arrayList=new ArrayList<>();
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        arrayList.add(new DataClassForVideos(video_url,"Data1"));
        arrayList.add(new DataClassForVideos(video_url,"Data2"));
        arrayList.add(new DataClassForVideos(video_url,"Data3"));
        arrayList.add(new DataClassForVideos(video_url,"Data4"));
        adapterForVideos=new AdapterForStudyMaterialStudents(this,arrayList);
        //recyclerView.setHorizontalScrollBarEnabled(true);

        recyclerView.setAdapter(adapterForVideos);

    }
}