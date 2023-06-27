package com.axis.axislanguageschool;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AddTestAdmin extends AppCompatActivity {
    Spinner getbatchspinner;
    EditText AddBatch_test,getTitle_Aid1;
    String testTitle,batch;
    TextView AddSubmissionDate;
    Button Submit;
    CardView uploadPdf,addQuestion;
    DatePickerDialog datePickerDialog;
    String SubmissionDate;
    String url="http://language.axisjobs.in/api/studymaterial/upload_test";
    private int PICK_PDF_REQUEST = 1;
    ArrayList<Uri> filepathA;
    String formatted;
    ArrayAdapter adapter;
    String url_batchget="http://language.axisjobs.in/api/batch/batch_name";
    ArrayList<String>arrayList1;



    ImageView changeimg,backbuttoninAdminAddAssignment2;
    Boolean flag=false;














    public void getBatch(){
        RequestQueue queue = Volley.newRequestQueue(this);
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

                        arrayList1.add((jsonArray.getJSONObject(i).getString("batch_name")));

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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_PDF_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            filepathA.add( data.getData());

            changeimg.setImageResource(R.drawable.upsuccess);


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




    public boolean addtest(){
            RequestQueue que= Volley.newRequestQueue(getApplicationContext());
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.w("jjdjd/.....kkk",response);
                    if(response.equals("success")){
                        flag=true;
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
                  Log.w("kdkkdkd",batch);
                  Log.w("..s.s..s.",testTitle);
                  Log.w(".;.;.;",SubmissionDate);
                    map.put("batch",batch);
                    map.put("name",testTitle);
                   map.put("date",SubmissionDate);

                    for(int i = 0 ;i<filepathA.size();i++){
                        map.put("application",getStringPdf(filepathA.get(i)));
                    }



                  return map;
                }
            };

que.add(request);
        request.setRetryPolicy(new DefaultRetryPolicy(25000,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));



          return flag;
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_test_admin);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


        filepathA=new ArrayList<>();
        changeimg=findViewById(R.id.changeimg);
        getbatchspinner=findViewById(R.id.getbatchspinner);
arrayList1=new ArrayList<>();
        AddSubmissionDate=findViewById(R.id.getsubmissionDate1);
        Submit=findViewById(R.id.submitUploadTest);
        uploadPdf=findViewById(R.id.uploadfile1);
        getTitle_Aid1=findViewById(R.id.getTitle_Aid1);

        getBatch();
        backbuttoninAdminAddAssignment2=findViewById(R.id.backbuttoninAdminAddAssignment2);
        backbuttoninAdminAddAssignment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,arrayList1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        getbatchspinner.setAdapter(adapter);
        getbatchspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                batch= String.valueOf(adapterView.getItemAtPosition(i));
                Log.w("selected month",batch);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });






        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        formatted = df.format(new Date());

        uploadPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser(v);
            }
        });

        AddSubmissionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(AddTestAdmin.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        AddSubmissionDate.setText(i2 + "-" + (i1 + 1) + "-" + i);
                        SubmissionDate=AddSubmissionDate.getText().toString();
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testTitle=getTitle_Aid1.getText().toString();
               addtest();
            }
        });

    }
}