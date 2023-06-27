package com.axis.axislanguageschool;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShowStudentsFromTutorBatch extends AppCompatActivity {
    String url_filter_batch="http://language.axisjobs.in/api/batch/filter_batch";
    String batchname;
    LinearLayoutManager linearLayoutManager;
    ArrayList<DataClassForStudentInTutor>arrayList;
    AdapterForStudentInTutor adapterForStudentInTutor;
    RecyclerView recyclerView;


    public void getBatch_name(String batchname){

        Log.w("lllslsls/....",batchname);

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request= new StringRequest(Request.Method.POST, url_filter_batch, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("response.....",response);
                //arrayList.add(new Reciever((String) "i2r5XC","Akshay","Student"));


                @SuppressLint("SimpleDateFormat") SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
//                Date todayDate = new Date();
//                String thisDate = currentDate.format(todayDate);
                try {
                    JSONObject jsn = new JSONObject(response);
                    JSONArray jsonArray=jsn.getJSONArray("batch");
                    for (int i =-0; i<jsonArray.length();i++){
                        Log.w("response111", (String) jsonArray.getJSONObject(i).get("batch"));
                        if (((String) jsonArray.getJSONObject(i).get("role")).equals("Student")){
                            arrayList.add(new DataClassForStudentInTutor((String) jsonArray.getJSONObject(i).get("name"),(String) jsonArray.getJSONObject(i).get("verify_code")));
                        }




                    }
                   adapterForStudentInTutor.notifyDataSetChanged();


                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>map=new HashMap<>();
                map.put("batch_name",batchname);
                return map;
            }
        };


        queue.add(request);


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students_from_tutor_batch);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        recyclerView=findViewById(R.id.showstudentinTutor);
        Intent extra=getIntent();
        batchname= extra.getStringExtra("batchname_from_adapter");


        arrayList=new ArrayList<>();
        getBatch_name(batchname);
        linearLayoutManager=new LinearLayoutManager(this);
        adapterForStudentInTutor=new AdapterForStudentInTutor(arrayList,this,batchname);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterForStudentInTutor);


    }
}