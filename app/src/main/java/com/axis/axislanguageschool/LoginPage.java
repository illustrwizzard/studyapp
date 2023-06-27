package com.axis.axislanguageschool;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginPage extends AppCompatActivity {
    String url_token="http://language.axisjobs.in/api/register/token";
    ImageButton otpbutton;
    EditText getcode;
    SQLB sqlb;
    TextView newuser;

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    public  void Loginapp(String student_code){
        //sqlb=new SQLB(getApplicationContext());

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, url_token, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("responyyyyyyyyyyyyyyy",response);
                if(response.equals("false")){
                    Toast.makeText(LoginPage.this, "Enter a Valid Code", Toast.LENGTH_SHORT).show();

                }else {
                    try {
                        JSONObject jsn = new JSONObject(response);
                        Log.w("jjdjdjdjdjdjdjd",response);

                        /// insert into db
                        jsn.getString("role");
                       sqlb.insertrole(jsn.getString("role"));
                       sqlb.insert_studentDetails(jsn.getString("role"),jsn.getString("batch"), jsn.getString("name"),jsn.getString("email"),jsn.getString("address"),jsn.getString("mobile"),jsn.getString("date_join"),jsn.getString("verify_code"),jsn.getString("dob"));
                        Intent i=new Intent(LoginPage.this,OTP.class);
                        i.putExtra("RoleLogin",jsn.getString("role"));
                        startActivity(i);


                        ///// insert into db


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
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
                Map<String,String> map= new HashMap<>();
                map.put("token",student_code);

                return map;
            }
        };
        queue.add(request);

    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        otpbutton=findViewById(R.id.otpbutton);
        getcode=findViewById(R.id.getcode);
        sqlb=new SQLB(this);
        newuser=findViewById(R.id.newuser);

//        if (sqlb.role_count()>0){
//            Intent i=new Intent(LoginPage.this,BottomNavigation.class);
//            startActivity(i);
//
//        }
//
        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ioo=new Intent(LoginPage.this,RegisterPage.class);
                ioo.putExtra("newuser","newuser");
                startActivity(ioo);
            }
        });



        sqlb.deletetable();
        sqlb.insertrole_admin("Admin","AXISADM01");

        otpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // AXISADM01,AXISADM02,AXISADM03,AXISADM04,AXISADM05

                if (getcode.getText().toString().equals("AXISADM01")) {

                    sqlb.insertrole_admin("Admin", "AXISADM01");
                    sqlb.insertrole("Admin");


                    Intent i = new Intent(LoginPage.this, OTP.class);
                    i.putExtra("RoleLogin", "Admin");
                    startActivity(i);
                }
                else {
                    Loginapp(getcode.getText().toString());
                }

            }
        });
    }
}