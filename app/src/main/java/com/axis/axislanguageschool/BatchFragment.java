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


public class BatchFragment extends Fragment {

RecyclerView recyclerView;
BatchAdapter adapter;
ArrayList<batchModel> arrayList1;
    String url_batchget="http://language.axisjobs.in/api/batch/batch_name";
    SQLB sqlb;
    String Role;
    String verify_id;
    String getbatch_url="http://language.axisjobs.in/api/batch/fetch_batch";




    public void getBatch_name(String verify_id){

        Log.w("lllslsls/....",verify_id);

        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest request= new StringRequest(Request.Method.POST, getbatch_url, new Response.Listener<String>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(String response) {
                Log.w("response.....",response);

                try {
                    JSONObject jsn = new JSONObject(response);
                    JSONArray jsonArray=jsn.getJSONArray("batch");
                    for (int i =-0; i<jsonArray.length();i++){

                        Log.w("response111", (String) jsonArray.getJSONObject(i).get("batch"));

                        arrayList1.add(new batchModel((String) jsonArray.getJSONObject(i).get("batch"),""));





                    }
                    adapter.notifyDataSetChanged();
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










    public void getBatch(){
        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest request= new StringRequest(Request.Method.GET, url_batchget, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("String...Response",response);

                @SuppressLint("SimpleDateFormat") SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
//                Date todayDate = new Date();
//                String thisDate = currentDate.format(todayDate);
                try {
                    JSONObject jsn = new JSONObject(response);
                    JSONArray jsonArray=jsn.getJSONArray("batch");
                    for (int i=0;i<jsonArray.length();i++){

                        arrayList1.add(new batchModel(jsonArray.getJSONObject(i).getString("batch_name"),jsonArray.getJSONObject(i).getString("date_create")));

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_batch, container, false);

        recyclerView =view.findViewById(R.id.re_uuu_1);
sqlb=new SQLB(getContext());
Role=sqlb.getrole();


         arrayList1=new ArrayList<>();
         if (Role.equals("Admin")){
             getBatch();

         }else if(Role.equals("Tutor")){
             verify_id=sqlb.getLoginstudentDetails().get(0).getVerify_code();

             getBatch_name(verify_id);

         }else {
             arrayList1.add(new batchModel(sqlb.getLoginstudentDetails().get(0).getBatchname(),""));
         }

//         arrayList1.add(new batchModel("IELTS GENERAL 2022",1));
//        arrayList1.add(new batchModel("IELTS GENERAL 2022 1",2));
//        arrayList1.add(new batchModel("IELTS GENERAL 2022 2",3));


        LinearLayoutManager L1=new LinearLayoutManager(getContext());
        adapter=new BatchAdapter(getContext(),arrayList1);
        recyclerView.setLayoutManager(L1);

        recyclerView.setAdapter(adapter);
        return view;

    }
}