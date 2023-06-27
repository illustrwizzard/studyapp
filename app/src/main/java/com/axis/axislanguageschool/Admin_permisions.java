package com.axis.axislanguageschool;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Admin_permisions extends AppCompatActivity {
ToggleButton AttendanceB,StudentB,AssignmentB,TestB,VideosB,LiveClassesB,StudyMaterialB;


String perm_url="https://language.axisjobs.in/api/permission";
String perm_get_url="https://language.axisjobs.in/api/permission/get";
int attendance,student,assignment,test,videos,liveclass,studymaterial;
ArrayList<PermissionDataClass>PermissonarrayList;
Button apply_permisssion;
SQLB sqlb;
Boolean flag=false;
ImageView backbuttoninAdminAddAssignment5;


    public Boolean get_permission(){


        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest req=new StringRequest(Request.Method.GET, perm_get_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("responsee",response);

                JSONObject jsn ;
                try {
                    jsn = new JSONObject(response);
                    JSONArray jsonArray=jsn.getJSONArray("permission");

                    for (int i=0;i<jsonArray.length();i++){
                        sqlb.insert_Permissiondetails(jsonArray.getJSONObject(i).getString("attendence"),jsonArray.getJSONObject(i).getString("students"),jsonArray.getJSONObject(i).getString("assignments"),jsonArray.getJSONObject(i).getString("tests"),jsonArray.getJSONObject(i).getString("videos"),jsonArray.getJSONObject(i).getString("study_material"),jsonArray.getJSONObject(i).getString("liveclasses"));



                        //batcharray.add(jsonArray.getJSONObject(i).getString("batch") );
                        //arrayList.add(new AdminDataClass(jsonArray.getJSONObject(i).getString("batch_name"),jsonArray.getJSONObject(i).getString("date_create")));

                    }



                    //   adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(req);
        return flag=true;


    }



    public void set_permission(){


        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest req=new StringRequest(Request.Method.POST, perm_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("responseeehjjhje",response);
                sqlb.deletetable_permission();


                JSONObject jsn ;
                try {
                    jsn = new JSONObject(response);
                    JSONArray jsonArray=jsn.getJSONArray("permission");

                    for (int i=0;i<jsonArray.length();i++){
                        sqlb.insert_Permissiondetails(jsonArray.getJSONObject(i).getString("attendence"),jsonArray.getJSONObject(i).getString("students"),jsonArray.getJSONObject(i).getString("assignments"),jsonArray.getJSONObject(i).getString("tests"),jsonArray.getJSONObject(i).getString("videos"),jsonArray.getJSONObject(i).getString("study_material"),jsonArray.getJSONObject(i).getString("liveclasses"));



                        //batcharray.add(jsonArray.getJSONObject(i).getString("batch") );
                        //arrayList.add(new AdminDataClass(jsonArray.getJSONObject(i).getString("batch_name"),jsonArray.getJSONObject(i).getString("date_create")));

                    }


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
                Log.w("attendance ....",String.valueOf(student));
                map.put("attendence",String.valueOf(attendance));
                map.put("students",String.valueOf(student));
                map.put("assignments",String.valueOf(assignment));
                map.put("tests",String.valueOf(test));
                map.put("videos",String.valueOf(videos));
                map.put("study_material",String.valueOf(studymaterial));
                map.put("liveclasses",String.valueOf(liveclass));
//               // Log.w("attendance ....",);
//                map.put("attendance","fff");
//                map.put("students","fff");
//                map.put("assignments","fff");
//                map.put("tests","fff");
//                map.put("videos","fff");
//                map.put("study_material","fff");
//                map.put("liveclasses","fff");
                return map;
            }
        };
        queue.add(req);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_permisions);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


        AttendanceB=findViewById(R.id.toggleButton1);
        StudentB=findViewById(R.id.toggleButton2);
        AssignmentB=findViewById(R.id.toggleButton3);
        TestB=findViewById(R.id.toggleButton5);
        VideosB=findViewById(R.id.toggleButton7);
        LiveClassesB=findViewById(R.id.toggleButton6);
        StudyMaterialB=findViewById(R.id.toggleButton10);
        apply_permisssion=findViewById(R.id.apply_permisssion);
        sqlb= new SQLB(this);
        backbuttoninAdminAddAssignment5=findViewById(R.id.backbuttoninAdminAddAssignment5);
        backbuttoninAdminAddAssignment5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        PermissonarrayList=new ArrayList<>();

            PermissonarrayList=sqlb.getPermissionDetails();
                attendance = Integer.parseInt(PermissonarrayList.get(0).getAttendace());
                student = Integer.parseInt(PermissonarrayList.get(0).getStudent());

                assignment = Integer.parseInt(PermissonarrayList.get(0).getAssignment());
                test = Integer.parseInt(PermissonarrayList.get(0).getTest());
                videos = Integer.parseInt(PermissonarrayList.get(0).getVideo());
                liveclass = Integer.parseInt(PermissonarrayList.get(0).getLive_class());
                studymaterial = Integer.parseInt(PermissonarrayList.get(0).getStudy_material());


            if(attendance==1){
                AttendanceB.setChecked(true);

            }else{
                AttendanceB.setChecked(false);


            }


            if(student==1){
                StudentB.setChecked(true);

            }else{
                StudentB.setChecked(false);


            }


            if(assignment==1){
                AssignmentB.setChecked(true);

            }else{
                AssignmentB.setChecked(false);


            }


            if(test==1){
                TestB.setChecked(true);

            }else{
                TestB.setChecked(false);


            }


            if(videos==1){
                VideosB.setChecked(true);

            }else{
                VideosB.setChecked(false);


            }


            if(liveclass==1){
                LiveClassesB.setChecked(true);

            }else{
                LiveClassesB.setChecked(false);


            }

            if(studymaterial==1){
                StudyMaterialB.setChecked(true);

            }else{
                StudyMaterialB.setChecked(false);


            }



        AttendanceB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                   if(attendance==1){
                       AttendanceB.setChecked(false);
                       attendance=0;
                   }else{
                       AttendanceB.setChecked(true);
                       attendance=1;

                   }




            }
        });


        StudentB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                        if(student==1){
                            StudentB.setChecked(false);
                          student=0;
                        }else{
                            StudentB.setChecked(true);
                            student=1;

                        }

            }
        });


        AssignmentB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                    if(assignment==1){
                        AssignmentB.setChecked(false);
                        assignment=0;
                    }else{
                        AssignmentB.setChecked(true);
                        assignment=1;

                    }
                    Toast.makeText(Admin_permisions.this, "button on", Toast.LENGTH_SHORT).show();


            }
        });




        TestB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                    if(test==1){
                        TestB.setChecked(false);
                        test=0;
                    }else{
                        TestB.setChecked(true);
                        test=1;

                    }
                    Toast.makeText(Admin_permisions.this, "button on", Toast.LENGTH_SHORT).show();


            }
        });

        VideosB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                    if(videos==1){
                        VideosB.setChecked(false);
                        videos=0;
                    }else{
                        VideosB.setChecked(true);
                        videos=1;

                    }


            }
        });


        LiveClassesB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                    if(liveclass==1){
                        LiveClassesB.setChecked(false);
                        liveclass=0;
                    }else{
                        LiveClassesB.setChecked(true);
                        liveclass=1;

                    }


            }
        });


        StudyMaterialB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                    if(studymaterial==1){
                        StudyMaterialB.setChecked(false);
                        studymaterial=0;
                    }else{
                        StudyMaterialB.setChecked(true);
                        studymaterial=1;

                    }
                    Toast.makeText(Admin_permisions.this, "button on", Toast.LENGTH_SHORT).show();


            }
        });
        apply_permisssion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.w("Studentttt", String.valueOf(student));
                set_permission();

            }
        });



    }
}