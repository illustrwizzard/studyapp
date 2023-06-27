package com.axis.axislanguageschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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

public class Tutor_perf_for_tutor_login extends AppCompatActivity {
    RecyclerView recycler_tutor;
    Adapter_for_tutor_performance adapter;
    ArrayList<tutor_stu_model> arrayList;
    String url_batchget="http://language.axisjobs.in/api/batch/batch_name";


    public void getBatch(){
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request= new StringRequest(Request.Method.GET, url_batchget, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("responsesiiiii",response);

                @SuppressLint("SimpleDateFormat") SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
//                Date todayDate = new Date();
//                String thisDate = currentDate.format(todayDate);
                try {
                    JSONObject jsn = new JSONObject(response);
                    JSONArray jsonArray=jsn.getJSONArray("batch");
                    for (int i=0;i<jsonArray.length();i++){

                        arrayList.add(new tutor_stu_model(jsonArray.getJSONObject(i).getString("batch_name"),jsonArray.getJSONObject(i).getString("date_create")));

                    }
                    Log.w("enterd getbatch","ypppp");
                    adapter.notifyDataSetChanged();














                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);


    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance_acty);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


        recycler_tutor=findViewById(R.id.recycle_tutor_perfromance);
        arrayList=new ArrayList<>();
        getBatch();

//        arrayList.add(new tutor_stu_model("gladson","04/07/2022"));
//        arrayList.add(new tutor_stu_model("gladson","04/07/2022"));
//        arrayList.add(new tutor_stu_model("gladson","04/07/2022"));
//        arrayList.add(new tutor_stu_model("gladson","04/07/2022"));
//        arrayList.add(new tutor_stu_model("gladson","04/07/2022"));


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        adapter=new Adapter_for_tutor_performance(arrayList);
        recycler_tutor.setLayoutManager(linearLayoutManager);
        recycler_tutor.setAdapter(adapter);


    }
}