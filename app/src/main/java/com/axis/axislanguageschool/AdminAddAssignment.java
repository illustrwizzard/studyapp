package com.axis.axislanguageschool;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class AdminAddAssignment extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    Allchatadapter allchatadapter;
    ArrayList<Reciever>arrayList;
    View view;
    String Role;
    SQLB sqlb;
    String url_filter_batch="http://language.axisjobs.in/api/batch/filter_batch";

    String batch;



    //public boolean addtest(){
    //        RequestQueue que=Volley.newRequestQueue(getApplicationContext());
    //        StringRequest  request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
    //            @Override
    //            public void onResponse(String response) {
    //                if(response.equals("success")){
    //                    flag=true;
    //                }
    //
    //            }
    //        }, new Response.ErrorListener() {
    //            @Override
    //            public void onErrorResponse(VolleyError error) {
    //
    //            }
    //        }){
    //            @Nullable
    //            @Override
    //            protected Map<String, String> getParams() throws AuthFailureError {
    //              Map<String,String>map=new HashMap<>();
    //
    //              for(int i = 0 ; i<question.size();i++){
    //                  map.put("question"+i, question.get(i));
    //
    //              }
    //
    //              return map;
    //            }
    //        };
    //
    //
    //      return flag;
    //    }









    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_admin_add_assignment, container, false);
        recyclerView=view.findViewById(R.id.chatrecycle);
        sqlb=new SQLB(getContext());
//        Role=sqlb.getrole();
      //  Log.w("ROLE IN ROLE",Role);
        arrayList=new ArrayList<>();
        arrayList=new ArrayList<>();
        arrayList.add(new Reciever("001","Axis Language School","admin"));



        linearLayoutManager=new LinearLayoutManager(getContext());
        allchatadapter=new Allchatadapter(arrayList,getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(allchatadapter);















        return view;
    }
}