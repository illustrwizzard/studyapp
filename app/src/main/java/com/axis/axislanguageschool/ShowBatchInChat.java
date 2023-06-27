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

public class ShowBatchInChat extends AppCompatActivity {



    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    Allchatadapter allchatadapter;
    ArrayList<Reciever> arrayList;
    String url_filter_batch="http://language.axisjobs.in/api/batch/filter_batch";
    String batch;




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
                            arrayList.add(new Reciever((String) jsonArray.getJSONObject(i).get("verify_code"),(String) jsonArray.getJSONObject(i).get("name"),(String) jsonArray.getJSONObject(i).get("role")));
                        }




                    }
                    allchatadapter.notifyDataSetChanged();













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
        setContentView(R.layout.fragment_admin_add_assignment);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        recyclerView=findViewById(R.id.chatrecycle);
        arrayList=new ArrayList<>();
        arrayList=new ArrayList<>();
        Intent i=getIntent();
        batch=i.getStringExtra("BatchName");
        Log.w("lllslsls/....",batch);
        getBatch_name(batch);

        //arrayList.add(new Reciever("001","admin"));

        linearLayoutManager=new LinearLayoutManager(this);
        allchatadapter=new Allchatadapter(arrayList,this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(allchatadapter);

    }
}