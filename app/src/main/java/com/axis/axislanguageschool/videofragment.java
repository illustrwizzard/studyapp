package com.axis.axislanguageschool;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class videofragment extends Fragment {
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    EditText editText;
    Button button;
    Spinner spinner;
    String url_batchget="http://language.axisjobs.in/api/batch/batch_name";
    String video_post="http://language.axisjobs.in/api/video/index";
    String video_get="http://language.axisjobs.in/api/video/get_allvideo";

    ArrayList<String> arrayList;

    ArrayList<data_for_video>arrayList2;
    String Type="video";
    String batch,Link, thisDate;
    String Batch;
    ArrayAdapter adapter;
    AdapterForYoutube adapterForYoutube;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_videofragment, container, false);
        recyclerView=view.findViewById(R.id.recycler_video);
        floatingActionButton=view.findViewById(R.id.floatingActionButtontutor1);
        arrayList=new ArrayList<>();
        arrayList2=new ArrayList<>();
        getBatch();


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        Log.w("yyyyyyyyyyyy", String.valueOf(arrayList2));
        adapterForYoutube=new AdapterForYoutube(getContext(),batch,arrayList2,thisDate);

        recyclerView.setAdapter(adapterForYoutube);


        getvideo();




        //getvideo(Batch);



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("hhhhhhhhhhhhhhhhhh","enter click");









                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                ViewGroup viewGroup = view.findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.add_videos_dialogue_box, viewGroup, false);
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();


                editText=dialogView.findViewById(R.id.video_url);
                spinner=dialogView.findViewById(R.id.Spinner_batch);



                adapter = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,arrayList);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        batch= String.valueOf(adapterView.getItemAtPosition(i));
                        Log.w("selected month",batch);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });



                button=dialogView.findViewById(R.id.Upload_url);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                         Link=editText.getText().toString();

                         Log.w("LINKKKKK",Link);

                          postvideo(batch);
                          arrayList2.clear();


                           alertDialog.cancel();
                       }



                });

            }

        });




        return view;
    }

    ////////////////////////////post()

    public void postvideo(String batch) {
        Log.w("batch",batch);
        Log.w("type",Type);
        Log.w("link",Link);

        Log.w("enter" ,"oojoijkojkoijko");
        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest request = new StringRequest(Request.Method.POST, video_post, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                Log.w("responsesiiiiiPOST", response);
//
//               try {
//                   JSONObject jsn = new JSONObject(response);
//                   JSONArray jsonArray = jsn.getJSONArray("batch");
//                   for (int i = 0; i < jsonArray.length(); i++) {
//
//                       arrayList2.add((jsonArray.getJSONObject(i).getString("link")));
//
//                   }
//                   Log.w("enterd getbatch", "ypppp");
//                   //adapterForAdmin.notifyDataSetChanged();
//                   // recyclerView.scrollToPosition(arrayList.size()-1);
//
//               } catch (JSONException e) {
//                   e.printStackTrace();
//               }

                getvideo();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> Map=new HashMap<>();

                Log.w("batch",batch);
                Log.w("type",Type);
                Log.w("link",Link);


                Map.put("batch",batch);
                Map.put("type",Type);
                Map.put("link",Link);



                return Map;

            }
        };

        queue.add(request);

    }
///////////////////////////////////////////get()


    public void getvideo() {




        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest request = new StringRequest(Request.Method.POST, video_get, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                Log.w("responsesiiiiiGET", response);

                try {

                    JSONArray jsonArray = new JSONArray(response);



                    for (int i = 0; i < jsonArray.length(); i++) {

                        if(jsonArray.getJSONObject(i).getString("type").equals("video")) {

                            arrayList2.add(new data_for_video(jsonArray.getJSONObject(i).getString("type"),
                                    jsonArray.getJSONObject(i).getString("batch"),
                                    jsonArray.getJSONObject(i).getString("link")));
                        }


                    }
                    Log.w("enterd getbatch", "ypppp");
                    //adapterForAdmin.notifyDataSetChanged();
                    // recyclerView.scrollToPosition(arrayList.size()-1);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adapterForYoutube.notifyDataSetChanged();





            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);

    }








    ////////////////////////// batchget()
    public void getBatch() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest request = new StringRequest(Request.Method.GET, url_batchget, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                Log.w("responsesiiiii", response);


                try {
                    JSONObject jsn = new JSONObject(response);
                    JSONArray jsonArray = jsn.getJSONArray("batch");
                    for (int i = 0; i < jsonArray.length(); i++) {

                        arrayList.add((jsonArray.getJSONObject(i).getString("batch_name")));

                    }
                    Log.w("enterd getbatch", "ypppp");

                    //Batch=arrayList.get(0);

                    //adapterForAdmin.notifyDataSetChanged();
                    // recyclerView.scrollToPosition(arrayList.size()-1);


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
}