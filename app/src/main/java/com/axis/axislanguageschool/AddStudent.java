package com.axis.axislanguageschool;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class AddStudent extends AppCompatActivity {
    EditText name, phone, email, address, Rollno,Batch;
    TextView date_of_joining,Dob;
    Button submit;
    RadioGroup role;
    DatePickerDialog datePickerDialog12;
    String name1, phone1, email1, address1, state1, date_of_joining1 = "",DateofBirth;
    int Roleid;
    String Role;
    String url_add_student, batch, new_student;
    Boolean flag=false;
    RadioButton radioButton;
    String url_register="http://language.axisjobs.in/api/register/";
    String Verify_code="f";
    ImageView backbuttoninAdminAddAssignment1;
    // radioButton = (RadioButton) findViewById(selectedId);
    //
    //            Toast.makeText(MyAndroidAppActivity.this,
    //                radioButton.getText(), Toast.LENGTH_SHORT).show();

    SQLB sqlb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        name = findViewById(R.id.getname_id);
        email = findViewById(R.id.getmail_id);
        phone = findViewById(R.id.getmob_id);
        address = findViewById(R.id.getaddress_id);
        Batch = findViewById(R.id.getbatch_id);
        submit = findViewById(R.id.getsubmit_id);
        role=findViewById(R.id.getrole_id);
        Dob =findViewById(R.id.getdob_id);
        Rollno =findViewById(R.id.getrollno_id);
        backbuttoninAdminAddAssignment1=findViewById(R.id.backbuttoninAdminAddAssignment1);
        backbuttoninAdminAddAssignment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        sqlb=new SQLB(this);
//        Roleid=role.getCheckedRadioButtonId();
//        radioButton=findViewById(Roleid);
//        Role=radioButton.getText().toString();




        role.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.w("checkid......", String.valueOf(checkedId));
                radioButton=group.findViewById(checkedId);
                Role=radioButton.getText().toString();

            }
        });


        Dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                datePickerDialog12 = new DatePickerDialog(AddStudent.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Dob.setText(i2 + "/"
                                + (i1 + 1) + "/" + i);

                        DateofBirth = Dob.getText().toString();


                    }
                }, mYear, mMonth, mDay);
                datePickerDialog12.show();

            }
        });




        date_of_joining = findViewById(R.id.getdateofjoining_id);
        date_of_joining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                datePickerDialog12 = new DatePickerDialog(AddStudent.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        date_of_joining.setText(i2 + "/"
                                + (i1 + 1) + "/" + i);

                        date_of_joining1 = date_of_joining.getText().toString();


                    }
                }, mYear, mMonth, mDay);
                datePickerDialog12.show();
            }

        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=getIntent();
                batch=i.getStringExtra("Batch_code");
                new_student=i.getStringExtra("new_student");


                add_member();


                Log.w("name111", name.getText().toString());
                Log.w("email11", email.getText().toString());
               Log.w("phone111", phone.getText().toString());
                Log.w("address111", address.getText().toString());
                Log.w("DateofJoiniing", date_of_joining1);

            }
        });

    }

    private Boolean add_member() {
        Log.w("Enterd Here","Here Here");


        RequestQueue que = Volley.newRequestQueue(getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.POST, url_register, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("Response....",response);
                try {
                    JSONObject jsonObject=new JSONObject(response);

                    sqlb.insert_memberdetails(jsonObject.getString("role"),jsonObject.getString("batch"),jsonObject.getString("name")
                            ,jsonObject.getString("email"),jsonObject.getString("address"),jsonObject.getString("mobile"),jsonObject.getString("date_join"),jsonObject.getString("verify_code"),jsonObject.getString("dob"));

                    flag=true;
                } catch (JSONException e) {
                    e.printStackTrace();
                }





            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map map = new HashMap();


                map.put("name", name.getText().toString());
                map.put("email", email.getText().toString());
                map.put("role", Role.toString());
                map.put("dob", DateofBirth.toString());
                map.put("mobile", phone.getText().toString());
                map.put("roll", Rollno.getText().toString());
                map.put("batch", Batch.getText().toString());
                map.put("date_join", date_of_joining1.toString());
                map.put("address", address.getText().toString());

//
//                map.put("name", "name.getText().toString()");
//                map.put("email", "email.getText().toString()");
//                map.put("role"," Role");
//                map.put("dob"," Dob");
//                map.put("mobile", "phone.getText().toString()");
//                map.put("roll"," Rollno.getText().toString()");
//                map.put("batch", "Batch.getText().toString()");
//                map.put("date_join", "date_of_joining1");
//                map.put("address", "address.getText().toString()");






                return map;
            }

        };
        que.add(request);
        return flag;




    }
}
