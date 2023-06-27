package com.axis.axislanguageschool;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test_For_Student extends AppCompatActivity {
    ArrayList<DataClassForStudentAssignment> array1;
    String studentname;
    String verify_name;
    SQLB sqlb;
    String batch;
    String url="http://language.axisjobs.in/api/studymaterial/get_test";
    RecyclerView recycler_for_test_for_student;
    AdapterForStudentTest adapterForStudentTest;




    public void get_std_meterial(String batch){
        RequestQueue queue = Volley.newRequestQueue(this);
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
                Log.w("ksksksksks",batch);
                map.put("batch",batch);
                return map;
            }
        };
        queue.add(req);



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_for_student);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


        sqlb=new SQLB(this);

        recycler_for_test_for_student=findViewById(R.id.recycler_for_test_for_student);
        array1=new ArrayList<>();
       // Log.w("arraylistsizeeeee", String.valueOf(array1.size()));
        batch=sqlb.getLoginstudentDetails().get(0).getBatchname();

        get_std_meterial(batch);
        LinearLayoutManager op=new LinearLayoutManager(this);

       recycler_for_test_for_student.setLayoutManager(op);
       adapterForStudentTest=new AdapterForStudentTest(array1,this,"");
        recycler_for_test_for_student.setAdapter(adapterForStudentTest);

    }
}