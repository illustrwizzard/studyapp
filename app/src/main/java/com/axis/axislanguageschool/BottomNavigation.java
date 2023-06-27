package com.axis.axislanguageschool;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BottomNavigation extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    private DrawerLayout mDrawer;
    Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    String Role;
    SQLB sqlb;
    String time_in_hours;
    ImageView logout;

    ArrayList<MeetingDetailsDataClass>arrayList;
    ArrayList<MeetingDetailsDataClass>arrayList1;
    //String Role="Tutor";
    //String Role="Admin";
    float total_hours;
//String url="http://language.axisjobs.in/api/meeting/filter_date";
    String perm_get_url="https://language.axisjobs.in/api/permission/get";

ArrayList<MeetingDetailsDataClass>meetarray;


    @Override
    public void onBackPressed() {
        new androidx.appcompat.app.AlertDialog.Builder(getApplicationContext())
                .setTitle("Do you want to Exit?")
                .setMessage("")
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        closeContextMenu();

                    }
                })
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {

                       finishAffinity();
                    }
                }).create().show();

    }

    public void get_permission( ){


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


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        sqlb=new SQLB(this);
        Role=sqlb.getrole();
        meetarray=new ArrayList<>();
        arrayList=new ArrayList<>();
        arrayList1=new ArrayList<>();
        logout=findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new androidx.appcompat.app.AlertDialog.Builder(getApplicationContext())
                        .setTitle("Logout?")
                        .setMessage("Are you sure?")
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                closeContextMenu();

                            }
                        })
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface arg0, int arg1) {

                                sqlb.deletetable();
                                Intent ioioi=new Intent(BottomNavigation.this,LoginPage.class);
                                startActivity(ioioi);
                            }
                        }).create().show();



            }
        });






        bottomNavigationView = findViewById(R.id.bottom_navigation);

        if (Role.equals("Tutor")) {


            Log.w("Enterd", "Tutor");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_displayhere_id, new HomeFragment()).commit();
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    switch (item.getItemId()) {
                        case R.id.page_1:


                            //getSupportActionBar().show();


                            fragment = new HomeFragment();
                            break;

                        case R.id.page_2:


                            //getSupportActionBar().show();

                            fragment = new BatchFragment();
                            break;

                        case R.id.page_3:

                            // getSupportActionBar().show();

                            fragment = new ShowBtachInChatt();
                            break;
//                        case R.id.page_4:
//
//
//                            fragment = new ProfilePageForStudent();
//                            break;


                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_displayhere_id, fragment).commit();
                    return true;
                }
            });


        } else if (Role.equals("Student")) {

            Log.w("Enterd", "Student");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_displayhere_id, new HomeFragment()).commit();
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    switch (item.getItemId()) {
                        case R.id.page_1:


                            //getSupportActionBar().show();


                            fragment = new HomeFragment();
                            break;

                        case R.id.page_2:


                            //getSupportActionBar().show();

                            fragment = new BatchFragment();
                            break;

                        case R.id.page_3:

                            // getSupportActionBar().show();

                            fragment = new AdminAddAssignment();
                            break;
//                        case R.id.page_4:
//
//
//                            fragment = new ProfilePageForStudent();
//                            break;
//

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_displayhere_id, fragment).commit();
                    return true;
                }
            });


        } else if (Role.equals("Guest")){





            Log.w("Enterd", "Guest");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_displayhere_id, new HomeFragment()).commit();
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    switch (item.getItemId()) {
                        case R.id.page_1:


                            //getSupportActionBar().show();


                            fragment = new HomeFragment();
                            break;

                        case R.id.page_2:


                            //getSupportActionBar().show();

                            fragment = new GuestBatch();
                            break;

                        case R.id.page_3:

                            // getSupportActionBar().show();

                            fragment = new GuestChat();
                            break;
//                        case R.id.page_4:
//
//
//                            fragment = new ProfilePageForStudent();
//                            break;
//

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_displayhere_id, fragment).commit();
                    return true;
                }
            });





        }



        else {


            Log.w("Enterd", "Admin");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_displayhere_id, new HomeFragment()).commit();
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = null;
                    switch (item.getItemId()) {
                        case R.id.page_1:


                            //getSupportActionBar().show();


                            fragment = new HomeFragment();
                            break;

                        case R.id.page_2:


                            //getSupportActionBar().show();

                            fragment = new BatchFragment();
                            break;

                        case R.id.page_3:

                            // getSupportActionBar().show();

                            fragment = new ShowBtachInChatt();
                            break;
//                        case R.id.page_4:
//
//
//                            fragment = new ProfilePageForStudent();
//                            break;


                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_displayhere_id, fragment).commit();
                    return true;
                }
            });
        }


    }
}










