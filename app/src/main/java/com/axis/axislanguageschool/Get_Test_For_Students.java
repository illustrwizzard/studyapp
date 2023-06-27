package com.axis.axislanguageschool;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Get_Test_For_Students extends AppCompatActivity {
    RelativeLayout downlaodtestpdf,SubmitTest,addTestPdf;
    TextView batchname_test,testnameee,retext1,pending,retext2,retext11;
    ImageView upimgggggwt,yoyoyoyoyoy32;
    String batchname,testlink,testname,mark;
    EditText put_mark_tutor;
    Button Submit_mark;
    LinearLayout mark_layout;
    SQLB sqlb;
    String verify_code;
    String role;
    String urle="http://language.axisjobs.in/api/studymaterial/assignment_pending";
    String submission_date;
    String url_putmark="http://language.axisjobs.in/api/perform/testindex";
    String url_getmark="http://language.axisjobs.in/api/perform/test";
ImageView backbuttoninAdminAddAssignment9;





    String url="http://language.axisjobs.in/api/studymaterial/upload_assignment_ans";


    ////////////////////////////////////////////////////////





    public void get_Test_pending(){
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest req=new StringRequest(Request.Method.POST, urle, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.w("responsee",response);
                if (response.equals("Pendingnull")){



                }else {
                    mark_layout.setVisibility(View.VISIBLE);
                    yoyoyoyoyoy32.setVisibility(View.VISIBLE);
                    pending.setText("Submitted");
                    pending.setBackgroundResource(R.color.submit_color);

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
                Log.w("msmsnsnsnsnsns",testname);
                map.put("verify_code",verify_code);
                map.put("name",testname);
                return map;
            }
        };
        queue.add(req);



    }



//////        map.put("date","22/3/22");
//               map.put("tokken","12345");
//               map.put("test","test1");
//               map.put("mark","10");
//               return map;


    //////////////PUT MARK FOR TUTOR/////////////////












    public void put_Test_mark(){
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest req=new StringRequest(Request.Method.POST, url_putmark, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.w("responsee",response);

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
                Log.w("msmsnsnsnsnsns",testname);
                Log.w("lslslslslslsl",submission_date);
                Log.w("msmsnsnsnsnsns",mark);
                map.put("tokken",verify_code);
                map.put("test",testname);
                map.put("date",submission_date);
                map.put("mark",mark);
                return map;
            }
        };
        queue.add(req);



    }










/////////////GET MARK/////////////////
public void get_Test_mark(){
    RequestQueue queue = Volley.newRequestQueue(this);
    StringRequest req=new StringRequest(Request.Method.POST, url_getmark, new Response.Listener<String>() {

        @Override
        public void onResponse(String response) {
            Log.w("responsee",response);
            try {
                JSONObject jsonObject=new JSONObject(response);
                JSONArray jsonArray=jsonObject.getJSONArray("code");
                retext2.setText(jsonArray.getJSONObject(0).getString("test_mark"));
                pending.setText("Submitted");
                pending.setBackgroundResource(R.color.submit_color);

            } catch (JSONException e) {
                e.printStackTrace();
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
            Log.w("msmsnsnsnsnsns",testname);
            Log.w("lslslslslslsl",submission_date);
           // Log.w("msmsnsnsnsnsns",mark);
            map.put("verify_code",verify_code);
            map.put("test",testname);
            map.put("date",submission_date);
          //  map.put("mark",mark);
            return map;
        }
    };
    queue.add(req);



}






















    /////////////




    private int PICK_PDF_REQUEST = 1;
    ArrayList<Uri> filepathA;
    String formatted;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_PDF_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            filepathA.add( data.getData());



            upimgggggwt.setImageResource(R.drawable.upsuccess);


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

    public boolean add_assigmnt(){
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
                    Log.w("batch",batchname);
                    Log.w("title",testname);
                    Log.w("date",verify_code);
//                    map.put("submission_date",submission_date);
                // Log.w("...........",);

                map.put("batch",batchname);
                map.put("name",testname);
               // map.put("date",Submitteddate);
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
        setContentView(R.layout.activity_get_test_for_students);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        backbuttoninAdminAddAssignment9=findViewById(R.id.backbuttoninAdminAddAssignment9);
        backbuttoninAdminAddAssignment9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        testnameee=findViewById(R.id.testnameee);
        batchname_test=findViewById(R.id.batchname_test);
        sqlb=new SQLB(this);
        upimgggggwt=findViewById(R.id.upimgggggwt);
        downlaodtestpdf=findViewById(R.id.downlaodtestpdf);
        SubmitTest=findViewById(R.id.submittest);
        addTestPdf=findViewById(R.id.uploadTest);
        retext1=findViewById(R.id.retext1);
        retext2=findViewById(R.id.retext2);
        yoyoyoyoyoy32=findViewById(R.id.yoyoyoyoyoy32);
        pending=findViewById(R.id.pending);
        put_mark_tutor=findViewById(R.id.put_mark_tutor);
        Submit_mark=findViewById(R.id.Submit_mark);
        mark_layout=findViewById(R.id.mark_layout);
        filepathA=new ArrayList<>();
        role=sqlb.getrole();
        mark_layout.setVisibility(View.GONE);
        retext11=findViewById(R.id.retext11);
        //              inn.putExtra("batchnameTest",array1.get(position).getBatchname());
//                inn.putExtra("testname",array1.get(position).getAssign_name());
//                inn.putExtra("linktest",array1.get(position).getLink());



        if (role.equals("Tutor")){
            Intent i=getIntent();
            batchname=i.getStringExtra("batchnameTest");
            testlink=i.getStringExtra("linktest");
            testname=i.getStringExtra("testname");
            verify_code=i.getStringExtra("verify_name_get");
            Log.w("jsjsjsjsjs",verify_code);
            submission_date=i.getStringExtra("submission_date");
           yoyoyoyoyoy32.setVisibility(View.GONE);
            retext1.setVisibility(View.GONE);
addTestPdf.setVisibility(View.GONE);
            SubmitTest.setVisibility(View.GONE);
            get_Test_pending();
            get_Test_mark();



        }else if(role.equals("Admin")){
            Intent i=getIntent();
            batchname=i.getStringExtra("batchnameTest");
            testlink=i.getStringExtra("linktest");
            testname=i.getStringExtra("testname");
            verify_code=i.getStringExtra("verify_name_get");
            Log.w("jsjsjsjsjs",verify_code);
            submission_date=i.getStringExtra("submission_date");
            SubmitTest.setVisibility(View.GONE);
            yoyoyoyoyoy32.setVisibility(View.GONE);
            retext1.setVisibility(View.GONE);
            addTestPdf.setVisibility(View.GONE);

            get_Test_pending();



        }else{

            Intent i=getIntent();
            batchname=i.getStringExtra("batchnameTest");
            testlink=i.getStringExtra("linktest");
            testname=i.getStringExtra("testname");
            submission_date=i.getStringExtra("submission_date");
            //Submitteddate=i.getStringExtra("datelink");
            verify_code=sqlb.getLoginstudentDetails().get(0).getVerify_code();
            retext11.setVisibility(View.GONE);
            retext2.setVisibility(View.GONE);

            get_Test_pending();
        }








        batchname_test.setText(batchname);
                testnameee.setText(testname);
        yoyoyoyoyoy32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setPackage("com.android.chrome");
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(testlink));
                startActivity(i);

            }
        });
        SubmitTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_assigmnt();
            }
        });
        addTestPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser(v);
            }
        });
        Submit_mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mark=put_mark_tutor.getText().toString();
                put_Test_mark();
            }
        });
    }
}