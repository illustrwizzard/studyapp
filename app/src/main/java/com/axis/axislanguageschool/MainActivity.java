package com.axis.axislanguageschool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Intent i;
    String perm_get_url="https://language.axisjobs.in/api/permission/get";
    SQLB sqlb;











    public void get_permissions( ){


        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest req=new StringRequest(Request.Method.GET, perm_get_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("responsee",response);
                sqlb.deletetable_permission();

                JSONObject jsn ;
                try {
                    jsn = new JSONObject(response);
                    JSONArray jsonArray=jsn.getJSONArray("permission");

                    for (int i=0;i<jsonArray.length();i++){
                        sqlb.insert_Permissiondetails(jsonArray.getJSONObject(i).getString("attendence"),jsonArray.getJSONObject(i).getString("students"),jsonArray.getJSONObject(i).getString("assignments"),jsonArray.getJSONObject(i).getString("tests"),jsonArray.getJSONObject(i).getString("videos"),jsonArray.getJSONObject(i).getString("study_material"),jsonArray.getJSONObject(i).getString("liveclasses"));

Log.w("insert","insert");

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
        setContentView(R.layout.activity_menu_profile);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        sqlb=new SQLB(this);

        get_permissions();



        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {


                        if (sqlb.role_count()>0){
            Intent i=new Intent(MainActivity.this,BottomNavigation.class);
            startActivity(i);
                            finish();

        }else {


                            i = new Intent(MainActivity.this, LoginPage.class);
                            startActivity(i);
                            finish();

                        }
            }
        }, 5000);
    }

}