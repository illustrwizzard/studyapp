package com.axis.axislanguageschool;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class BatchTest extends Fragment {
    String studentname,batchname;
    String verify_name,role;
    ArrayList<DataClassForStudentAssignment> array1;

    SQLB sqlb;
    String batch;
    String url="http://language.axisjobs.in/api/studymaterial/get_test";
    RecyclerView recycler_for_test_for_student;
    AdapterForStudentTest adapterForStudentTest;






    public void get_std_meterial(String batchname){
        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest req=new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("responsee",response);
                JSONArray jsn ;
                try {
                    jsn = new JSONArray(response);

                    for (int i=0;i<jsn.length();i++){
                        array1.add(new DataClassForStudentAssignment(jsn.getJSONObject(i).getString("name"),jsn.getJSONObject(i).getString("date"),jsn.getJSONObject(i).getString("batch"),jsn.getJSONObject(i).getString("link")));

                        //arrayList.add(new StudyMaterialDataclass(jsn.getJSONObject(i).getString("name"),jsn.getJSONObject(i).getString("link")));
                        //adapterForInsideStudyMaterials.notifyDataSetChanged();


                        //   sqlb.insert_meetingdetails(jsonArray.getJSONObject(i).getString("batch"),jsonArray.getJSONObject(i).getString("meet_code") ,jsonArray.getJSONObject(i).getString("verify_code") ,jsonArray.getJSONObject(i).getString("date"),jsonArray.getJSONObject(i).getString("status"),jsonArray.getJSONObject(i).getString("time"),jsonArray.getJSONObject(i).getString("total_time"));

                        // meetarray.add(new MeetingDetailsDataClass(jsonArray.getJSONObject(i).getString("batch"),jsonArray.getJSONObject(i).getString("meet_code") ,jsonArray.getJSONObject(i).getString("verify_code") ,jsonArray.getJSONObject(i).getString("date"),jsonArray.getJSONObject(i).getString("status"),jsonArray.getJSONObject(i).getString("time"),jsonArray.getJSONObject(i).getString("total_time")));
                        //jsonArray.getJSONObject(i).getString("date")
                        //arrayList.add(new AdminDataClass(jsonArray.getJSONObject(i).getString("batch_name"),jsonArray.getJSONObject(i).getString("date_create")));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adapterForStudentTest.notifyDataSetChanged();



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
                //Log.w("ksksksksks",batch);
                map.put("batch",batchname);
                return map;
            }
        };
        queue.add(req);



    }




    public BatchTest(String studentname, String verify_name,String batchname) {
        this.studentname=studentname;
        this.verify_name=verify_name;
        this.batchname=batchname;


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_batch_test, container, false);
        sqlb=new SQLB(getContext());
        recycler_for_test_for_student=view.findViewById(R.id.recycler_for_test_for_student1);
        array1=new ArrayList<>();
        role=sqlb.getrole();
//        if (role.equals("Admin")){
//
//        }
      //  batch=sqlb.getLoginstudentDetails().get(0).getBatchname();
        get_std_meterial(batchname);
        LinearLayoutManager op=new LinearLayoutManager(getContext());
        recycler_for_test_for_student.setLayoutManager(op);
        adapterForStudentTest=new AdapterForStudentTest(array1,getContext(),verify_name);
        recycler_for_test_for_student.setAdapter(adapterForStudentTest);


        return view;
    }
}