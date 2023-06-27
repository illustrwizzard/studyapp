package com.axis.axislanguageschool;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AddAdminAssign extends AppCompatActivity {
    EditText AdmBatch,AdmTitle;
    TextView AdmSubmission;
    Button AdmButton;
    DatePickerDialog datePickerDialog;
    CardView cardView;
    String SubmissionDate;
    ImageView upimggggg,backbuttoninAdminAddAssignment;







    String url="http://language.axisjobs.in/api/studymaterial/upload_assignment";
    private int PICK_PDF_REQUEST = 1;
    ArrayList<Uri> filepathA;
    String formatted;

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode == PICK_PDF_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
                filepathA.add( data.getData());



                upimggggg.setImageResource(R.drawable.upsuccess);


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

        public boolean add_assigmnt(String batch,String title,String date,String submission_date){
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
                    Log.w("....aaaaa.....",AdmTitle.getText().toString());
                    map.put("batch",AdmBatch.getText().toString());
                    map.put("name",AdmTitle.getText().toString());
                    map.put("date",submission_date);


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
        setContentView(R.layout.activity_add_admin_assign);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        filepathA=new ArrayList<>();

        AdmBatch=findViewById(R.id.getbatch_Aid);
        AdmTitle=findViewById(R.id.getTitle_Aid);
        AdmSubmission=findViewById(R.id.getsubmissionDate);
        AdmButton=findViewById(R.id.submitUploadAssignment);
        cardView=findViewById(R.id.uploadfile);
        upimggggg=findViewById(R.id.upimggggg);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        formatted = df.format(new Date());

        backbuttoninAdminAddAssignment=findViewById(R.id.backbuttoninAdminAddAssignment);
        backbuttoninAdminAddAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });






        AdmSubmission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(AddAdminAssign.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        AdmSubmission.setText(i2 + "/" + (i1 + 1) + "/" + i);
                        SubmissionDate=AdmSubmission.getText().toString();
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                showFileChooser(v);



            }
        });


        AdmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                add_assigmnt(AdmBatch.getText().toString(),AdmTitle.getText().toString(),formatted,SubmissionDate);


            }
        });


    }
}