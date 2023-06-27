package com.axis.axislanguageschool;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterPage extends AppCompatActivity {
    EditText RName, RMail, RMob;
    ImageButton registerButton;
    SQLB sqlb;
//    String url_Register;
//    String url_batchget="http://language.axisjobs.in/api/batch/batch_name";

    @Override
    public void onBackPressed() {
        new androidx.appcompat.app.AlertDialog.Builder(getApplicationContext())
                .setTitle("Cancel Register?")
                .setMessage("Are you sure to go back?")
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        closeContextMenu();

                    }
                })
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {


                        Intent ioioi=new Intent(RegisterPage.this,LoginPage.class);
                        startActivity(ioioi);
                    }
                }).create().show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        sqlb=new SQLB(this);
        sqlb.deletetable();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        RName = findViewById(R.id.getRegisterName);
        RMail = findViewById(R.id.getregisterMail);
        RMob = findViewById(R.id.getRegisterMob);
        registerButton = findViewById(R.id.registerbutton);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RName.getText().toString().equals("") | RMail.getText().toString().equals("") | RMob.getText().toString().equals("")) {


                    Toast.makeText(RegisterPage.this, "Field Cannot Be Empty", Toast.LENGTH_SHORT).show();

                } else {
                    sendMail();
                    sqlb.insertrole("Guest");
                    Intent i=new Intent(RegisterPage.this,BottomNavigation.class);
                    startActivity(i);
                }

            }
        });

    }




    private void sendMail() {
        String email = RMail.getText().toString().trim();
        Log.w("mail..........",email);
        Log.w("Rmob........",RMob.getText().toString());
        Log.w("Rnmae......",RName.getText().toString());

        BackgroundTask backgroundTask = new BackgroundTask(this, email, RMob.getText().toString(), RName.getText().toString());
        backgroundTask.execute();
        Log.w("out from here............","now............");

    }
}