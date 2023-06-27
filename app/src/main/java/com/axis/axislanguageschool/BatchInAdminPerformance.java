package com.axis.axislanguageschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

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

public class BatchInAdminPerformance extends AppCompatActivity {

    String url_batchget="http://language.axisjobs.in/api/batch/batch_name";
    ArrayList<DataModelClass_Batch_In_PerformanceAdmin>arrayList;
    RecyclerView recyclerView;
    AdapterforBatchInPerformance adapterforBatchInPerformance;
    LinearLayoutManager linearLayoutManager;
    ImageView backbuttoninAdminAddAssignment7;




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

                        arrayList.add(new DataModelClass_Batch_In_PerformanceAdmin(jsonArray.getJSONObject(i).getString("batch_name"),jsonArray.getJSONObject(i).getString("date_create")));

                    }
                    Log.w("enterd getbatch","ypppp");
                    adapterforBatchInPerformance.notifyDataSetChanged();














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
        setContentView(R.layout.activity_batch_in_admin_performance);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        backbuttoninAdminAddAssignment7=findViewById(R.id.backbuttoninAdminAddAssignment7);
        backbuttoninAdminAddAssignment7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        recyclerView=findViewById(R.id.batches_in_performanceAdmin);
        arrayList=new ArrayList<>();
        getBatch();
        linearLayoutManager=new LinearLayoutManager(this);
        adapterforBatchInPerformance=new AdapterforBatchInPerformance(this,arrayList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterforBatchInPerformance);


    }
}