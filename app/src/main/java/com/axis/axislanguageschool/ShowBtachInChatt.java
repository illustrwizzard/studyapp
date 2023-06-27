package com.axis.axislanguageschool;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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


public class ShowBtachInChatt extends Fragment {
    View view;
    String url_batch="http://language.axisjobs.in/api/batch";
    String batch_name,Role,verify_id;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AdapterForChatInBatch adapterForChatInBatch;
    ArrayList<AdminDataClass>arrayList;
    String url_batchget="http://language.axisjobs.in/api/batch/batch_name";
    SQLB sqlb;
    ArrayList <StudentDetailsDataClass> arrayList1;
    String getbatch_url="http://language.axisjobs.in/api/batch/fetch_batch";







    public void getBatch(){
        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest request= new StringRequest(Request.Method.GET, url_batchget, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                @SuppressLint("SimpleDateFormat") SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
//                Date todayDate = new Date();
//                String thisDate = currentDate.format(todayDate);
                try {
                    JSONObject jsn = new JSONObject(response);
                    JSONArray jsonArray=jsn.getJSONArray("batch");
                    for (int i=0;i<jsonArray.length();i++){

                        arrayList.add(new AdminDataClass(jsonArray.getJSONObject(i).getString("batch_name"),jsonArray.getJSONObject(i).getString("date_create")));

                    }
                    Log.w("enterd getbatch","ypppp");
                    adapterForChatInBatch.notifyDataSetChanged();














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




    public void getBatch_name(String verify_id){

        Log.w("lllslsls/....",verify_id);

        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest request= new StringRequest(Request.Method.POST, getbatch_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("response.....",response);

                try {
                    JSONObject jsn = new JSONObject(response);
                    JSONArray jsonArray=jsn.getJSONArray("batch");
                    for (int i =-0; i<jsonArray.length();i++){

                        Log.w("response111", (String) jsonArray.getJSONObject(i).get("batch"));

                        arrayList.add(new AdminDataClass(jsonArray.getJSONObject(i).getString("batch"),""));





                    }
                    adapterForChatInBatch.notifyDataSetChanged();
                    // BatchAdapterTuTOR.notifyDataSetChanged();













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
                Map<String,String> map=new HashMap<>();
                map.put("token",verify_id);
                return map;
            }
        };


        queue.add(request);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_show_btach_in_chatt, container, false);
        arrayList=new ArrayList<>();
        arrayList1=new ArrayList<>();
        sqlb=new SQLB(getContext());
        arrayList1=sqlb.getLoginstudentDetails();
       // Role=sqlb.getrole_admin();
        Role=sqlb.getrole();

        Log.w("ROLE IN ROLE",Role);


        recyclerView=view.findViewById(R.id.recycle_for_chatbatch);


        if (sqlb.getrole().equals("Admin")){
            getBatch();


        }else if (sqlb.getrole().equals("Tutor")){
            verify_id=sqlb.getLoginstudentDetails().get(0).getVerify_code();

            getBatch_name(verify_id);

        }

        adapterForChatInBatch=new AdapterForChatInBatch(getContext(),arrayList);
        linearLayoutManager =new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
recyclerView.setAdapter(adapterForChatInBatch);

        return view;
    }
}