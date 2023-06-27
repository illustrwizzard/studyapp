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

public class TutorInAdmin extends Fragment {
    View view;
    RecyclerView recycleTutor;
    ArrayList<DataClassForTutorInAdmin>arrayList;
    LinearLayoutManager linearLayoutManager;
    String url_filter_batch="http://language.axisjobs.in/api/batch/filter_batch";
    String batchname;
    AdapterForTutorInAdmin adapterForTutorInAdmin;





    public void getBatch_name(String batchname){

        Log.w("lllslsls/....",batchname);

        RequestQueue queue = Volley.newRequestQueue(getContext());
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
                        if (((String) jsonArray.getJSONObject(i).get("role")).equals("Tutor")){
                            arrayList.add(new DataClassForTutorInAdmin((String) jsonArray.getJSONObject(i).get("name"),"data:image/png;base64,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"));
                        }




                    }
                    adapterForTutorInAdmin.notifyDataSetChanged();













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







    public TutorInAdmin(String batchname) {
        this.batchname=batchname;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_tutor_in_admin, container, false);


        recycleTutor=view.findViewById(R.id.recycleTutor);
        arrayList=new ArrayList<>();
        getBatch_name(batchname);
        linearLayoutManager=new LinearLayoutManager(getContext());
//        arrayList.add(new DataClassForTutorInAdmin("Jithin","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQth7v47XK4MOuhBXs_7EImedLuT7xrMQoj6A&usqp=CAU"));
//        arrayList.add(new DataClassForTutorInAdmin("Stinson","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQth7v47XK4MOuhBXs_7EImedLuT7xrMQoj6A&usqp=CAU"));
//        arrayList.add(new DataClassForTutorInAdmin("Placken","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQth7v47XK4MOuhBXs_7EImedLuT7xrMQoj6A&usqp=CAU"));

adapterForTutorInAdmin=new AdapterForTutorInAdmin(getContext(),arrayList);
recycleTutor.setLayoutManager(linearLayoutManager);
recycleTutor.setAdapter(adapterForTutorInAdmin);


        return view;
    }
}