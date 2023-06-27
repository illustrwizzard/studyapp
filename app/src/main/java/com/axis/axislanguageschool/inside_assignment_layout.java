package com.axis.axislanguageschool;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class inside_assignment_layout extends AppCompatActivity {
   TextView batchname_assign,classwork,retext,textre;
   ImageView yoyoyoyoyoy32,upimgggggw;
   RelativeLayout uploadstu_assignment,bubububububu,uploadassignmnet,lastrelative;
   String batchname,assignmentname,link;
   String Submitteddate,verify_code;
   SQLB sqlb;
   String role;
    String urle="http://language.axisjobs.in/api/studymaterial/assignment_pending";
ImageView backbuttoninAdminAddAssignment10;






   //////////////////////////////////



    String url="http://language.axisjobs.in/api/studymaterial/upload_assignment_ans";


    /////////////









    public void get_assignment_pending(){
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest req=new StringRequest(Request.Method.POST, urle, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.w("responsee",response);
                if (response.equals("Pendingnull")){


                }else {
                    textre.setText("Submitted");
                    textre.setBackgroundResource(R.color.submit_color);
                }
//                JSONArray jsn ;
//                try {
//                    jsn = new JSONArray(response);
//
//                    for (int i=0;i<jsn.length();i++){
//                        //array1.add(new DataClassForStudentAssignment(jsn.getJSONObject(i).getString("name"),jsn.getJSONObject(i).getString("date"),jsn.getJSONObject(i).getString("batch"),jsn.getJSONObject(i).getString("link")));
//
//                        //arrayList.add(new StudyMaterialDataclass(jsn.getJSONObject(i).getString("name"),jsn.getJSONObject(i).getString("link")));
//                        //adapterForInsideStudyMaterials.notifyDataSetChanged();
//
//
//                        //   sqlb.insert_meetingdetails(jsonArray.getJSONObject(i).getString("batch"),jsonArray.getJSONObject(i).getString("meet_code") ,jsonArray.getJSONObject(i).getString("verify_code") ,jsonArray.getJSONObject(i).getString("date"),jsonArray.getJSONObject(i).getString("status"),jsonArray.getJSONObject(i).getString("time"),jsonArray.getJSONObject(i).getString("total_time"));
//
//                        // meetarray.add(new MeetingDetailsDataClass(jsonArray.getJSONObject(i).getString("batch"),jsonArray.getJSONObject(i).getString("meet_code") ,jsonArray.getJSONObject(i).getString("verify_code") ,jsonArray.getJSONObject(i).getString("date"),jsonArray.getJSONObject(i).getString("status"),jsonArray.getJSONObject(i).getString("time"),jsonArray.getJSONObject(i).getString("total_time")));
//                        //jsonArray.getJSONObject(i).getString("date")
//                        //arrayList.add(new AdminDataClass(jsonArray.getJSONObject(i).getString("batch_name"),jsonArray.getJSONObject(i).getString("date_create")));
//
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//               // gg.notifyDataSetChanged();


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
                Log.w("lslslslslslsl",verify_code);
                Log.w("msmsnsnsnsnsns",assignmentname);
                map.put("verify_code",verify_code);
                map.put("name",assignmentname);
                return map;
            }
        };
        queue.add(req);



    }

















    private int PICK_PDF_REQUEST = 1;
    ArrayList<Uri> filepathA;
    String formatted;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_PDF_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            filepathA.add( data.getData());



            upimgggggw.setImageResource(R.drawable.upsuccess);


        }
    }

    public String getStringPdf (Uri filepath){
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream =  getContentResolver().openInputStream(filepath);

            byte[] buffer = new byte[1024];
            byteArrayOutputStream = new ByteArrayOutputStream();

            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        byte[] pdfByteArray = byteArrayOutputStream.toByteArray();

        return Base64.encodeToString(pdfByteArray, Base64.DEFAULT);
    }
    private void showFileChooser(View v) {
        Log.w("","entered showfile");
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Pdf"), PICK_PDF_REQUEST);










    }

    public boolean add_assigmnt(String batch){
        RequestQueue que= Volley.newRequestQueue(getApplicationContext());
        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("RESPONSE...FIEE",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String >map=new HashMap<>();
//                    map.put("batch",batch);
//                    map.put("title",title);
//                    map.put("date",date);
//                    map.put("submission_date",submission_date);
                // Log.w("...........",);

                map.put("batch",batchname);
               map.put("name",assignmentname);
                map.put("date",Submitteddate);
                map.put("verify_code",verify_code);


                for(int i = 0 ;i<filepathA.size();i++){
                    map.put("application",getStringPdf(filepathA.get(i)));
                }
                return map;
            }
        };
        que.add(request);
        request.setRetryPolicy(new DefaultRetryPolicy(15000,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));




        return  true;
    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_assignment_layout);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        filepathA=new ArrayList<>();
        sqlb=new SQLB(this);
        backbuttoninAdminAddAssignment10=findViewById(R.id.backbuttoninAdminAddAssignment10);
        backbuttoninAdminAddAssignment10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        Intent extra=getIntent();
        batchname=extra.getStringExtra("batchname_assignmnet");
        assignmentname= extra.getStringExtra("assignmnment_name");
        link=extra.getStringExtra("link_name");
        Submitteddate=extra.getStringExtra("submission_name");

        role=extra.getStringExtra("role");
        retext=findViewById(R.id.retext);
        textre=findViewById(R.id.textre);




        batchname_assign=findViewById(R.id.batchname_assign);
        classwork=findViewById(R.id.classwork);
        yoyoyoyoyoy32=findViewById(R.id.yoyoyoyoyoy32);
        uploadstu_assignment=findViewById(R.id.uploadstu_assignment);
        bubububububu=findViewById(R.id.bubububububu);
        upimgggggw=findViewById(R.id.upimgggggw);
        uploadassignmnet=findViewById(R.id.uploadassignmnet);
        lastrelative=findViewById(R.id.lastrelative);
        batchname_assign.setText(batchname);
        classwork.setText(assignmentname);

        get_assignment_pending();


        if (role.equals("Tutor")){
            Log.w("rorlrlrlrlr",role);
            bubububububu.setClickable(false);
            yoyoyoyoyoy32.setVisibility(View.GONE);
           // bubububububu.setVisibility(View.GONE);
            uploadassignmnet.setVisibility(View.GONE);
            lastrelative.setVisibility(View.GONE);
            retext.setVisibility(View.GONE);

        }else if (role.equals("Admin")){
            Log.w("kkskskslllalala",role);
            yoyoyoyoyoy32.setVisibility(View.GONE);
            bubububububu.setClickable(false);
           /// bubububububu.setVisibility(View.GONE);
            uploadassignmnet.setVisibility(View.GONE);
            lastrelative.setVisibility(View.GONE);
            retext.setVisibility(View.GONE);

        }else {
            verify_code=sqlb.getLoginstudentDetails().get(0).getVerify_code();
        }




        yoyoyoyoyoy32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setPackage("com.android.chrome");
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(link));
                startActivity(i);

            }
        });

        uploadassignmnet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser(v);

            }
        });


        lastrelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_assigmnt(batchname);
            }
        });







    }
}