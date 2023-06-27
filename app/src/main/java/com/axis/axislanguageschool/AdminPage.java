package com.axis.axislanguageschool;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class AdminPage extends AppCompatActivity {
    RecyclerView recyclerView;

    ArrayList<AdminDataClass>arrayList;
    AdapterForAdmin adapterForAdmin;
    FloatingActionButton floatingActionButton;
    Button button;
    Boolean flag=false;
    ArrayList<String>arrayList1,arrayList2;
    EditText editText;
    String BatchName,NBatchName;
    LinearLayoutManager linearLayoutManager;
    String batch;
    String url_batchget="http://language.axisjobs.in/api/batch/batch_name";
    String url_batch="http://language.axisjobs.in/api/batch";
    SQLB sqlb;
    ImageView backbuttoninAdminAddAssignment4;


    public void getBatch(){
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request= new StringRequest(Request.Method.GET, url_batchget, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("responsesiiiii",response);

                @SuppressLint("SimpleDateFormat") SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
//                Date todayDate = new Date();
//                String thisDate = currentDate.format(todayDate);
                try {
                    JSONObject jsn = new JSONObject(response);

                    JSONArray jsonArray=jsn.getJSONArray("batch");
                    for (int i=0;i<jsonArray.length();i++){

                        arrayList.add(new AdminDataClass(jsonArray.getJSONObject(i).getString("batch_name"),jsonArray.getJSONObject(i).getString("date_create")));

                    }
                    Log.w("enterd getbatch","ypppp");
                  adapterForAdmin.notifyDataSetChanged();
                  recyclerView.scrollToPosition(arrayList.size()-1);





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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


        recyclerView=findViewById(R.id.recycleradmin);
        floatingActionButton=findViewById(R.id.floatingActionButton);
        backbuttoninAdminAddAssignment4=findViewById(R.id.backbuttoninAdminAddAssignment4);

        backbuttoninAdminAddAssignment4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        arrayList=new ArrayList<>();
        getBatch();
        linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        adapterForAdmin=new AdapterForAdmin(AdminPage.this,arrayList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterForAdmin);



//        arrayList1=new ArrayList<>();
//        arrayList2=new ArrayList<>();
////        arrayList.add(new AdminDataClass("IELTS","19-01-20"));
//        arrayList.add(new AdminDataClass("IELTS","19-01-20"));
//        arrayList.add(new AdminDataClass("IELTS","19-01-20"));
//        arrayList.add(new AdminDataClass("IELTS","19-01-20"));
//        arrayList.add(new AdminDataClass("IELTS","19-01-20"));


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                AlertDialog.Builder builder = new AlertDialog.Builder(AdminPage.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.dialogue_box, viewGroup, false);
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                editText=dialogView.findViewById(R.id.batchget_id);

                button=dialogView.findViewById(R.id.enetrbutton_in_dialoguebox);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(editText.getText().toString().equals("")){
                            Toast.makeText(AdminPage.this, "Enter the BatchCode", Toast.LENGTH_SHORT).show();


                        }else{


                            BatchName=editText.getText().toString();
                           addBatch(BatchName);





                            Log.w("BatchNAme",BatchName);
                            alertDialog.cancel();

                        }


                    }
                });

            }

        });


    }

    private Boolean addBatch(String BatchName) {
        NBatchName=BatchName;
        Log.w("NNNNNBATCH",NBatchName);





            //sqlb=new SQLB(getApplicationContext());

            RequestQueue queue = Volley.newRequestQueue(this);
            StringRequest request = new StringRequest(Request.Method.POST, url_batch, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    flag=true;
                    Log.w("Respaonseeeee",response);
                    arrayList.clear();

                    getBatch();

//                        try {
//
//
//                            /// insert into db
////                            jsn.getString("role");
////                            sqlb.insertrole(jsn.getString("role"));
//                            //sqlb.insert_studentDetails(jsn.getString("role"),jsn.getString("batch"), jsn.getString("name"),jsn.getString("email"),jsn.getString("address"),jsn.getString("mobile"),jsn.getString("date_join"),jsn.getString("verify_code"),jsn.getString("dob"));
////                            Intent i=new Intent(AdminPage.this,BottomNavigation.class);
////                            i.putExtra("batch",jsn.getString("batch"));
////                            startActivity(i);
//
//
//                            ///// insert into db
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }


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
                    map.put("batch_name",NBatchName);

                    return map;
                }
            };
            queue.add(request);

        return flag;

    }
}