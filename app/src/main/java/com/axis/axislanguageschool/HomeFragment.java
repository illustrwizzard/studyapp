package com.axis.axislanguageschool;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
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
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomeFragment extends Fragment {


    CircleImageView img1,img2,img3,img4,img5;
    AdapterForVideos adapterForVideos;
    RecyclerView recyclerView;
    ArrayList<DataClassForVideos>arrayList;
    LinearLayoutManager linearLayoutManager;
    String verify_id;
    ArrayList<StudentDetailsDataClass> arrayList11;
    ArrayAdapter adapter;
    //String Role="Admin";
    String Role;
    //String Role="Admin";
    //String Role;
    VideoView videoView;
    String video_url="https://www.youtube.com/watch?v=PGzeBL-tMOI";
    String batch;
    CardView LiveClass, studymaterial_id,AssignLay,addBatchLay,performanceLay,addtestlay,PermissionLay,SAssignLay,STestLay,AddStudyVideos;
    Button joinorcreate;
    EditText meeting_code;
    SQLB sqlb;
    Spinner meeting_batch_spinner;
    ArrayList<String> batcharray;
    String[] batchArrayy;
    Boolean flag1=false;
    String video_get="http://language.axisjobs.in/api/video/get_allvideo";

    String getbatch_url="http://language.axisjobs.in/api/batch/fetch_batch";

////////////////////////////////////////////////////////////////////

    public void getvideo() {




        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest request = new StringRequest(Request.Method.POST, video_get, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                Log.w("responsesiiiiiGET", response);

                try {

                    JSONArray jsonArray = new JSONArray(response);



                    for (int i = 0; i < jsonArray.length(); i++) {

                        if(jsonArray.getJSONObject(i).getString("type").equals("Youtube")) {

                            arrayList.add(new DataClassForVideos(
                                    jsonArray.getJSONObject(i).getString("link"),
                                    jsonArray.getJSONObject(i).getString("batch")));
                        }


                    }
                    Log.w("enterd getbatch", "ypppp");
                    adapterForVideos.notifyDataSetChanged();
                    // recyclerView.scrollToPosition(arrayList.size()-1);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
             ///   adapterForYoutube.notifyDataSetChanged();





            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);

    }


































    ////////////////////////////////////////////////////////






    public void sendBtach_details(String verify_id ){

        Log.w("hhhhhhhhhhhhhhhh",verify_id);




        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest req=new StringRequest(Request.Method.POST, getbatch_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("responseeehjjhje",response);


                JSONObject jsn ;
                try {
                    jsn = new JSONObject(response);
                    JSONArray jsonArray=jsn.getJSONArray("batch");
                    for (int i=0;i<jsonArray.length();i++){
                        Log.w("roleoeloeleoe",jsonArray.getJSONObject(i).getString("batch"));

                        batcharray.add(jsonArray.getJSONObject(i).getString("batch"));
                        //arrayList.add(new AdminDataClass(jsonArray.getJSONObject(i).getString("batch_name"),jsonArray.getJSONObject(i).getString("date_create")));

                    }
                   //adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
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
                Map<String,String> map=new HashMap<>();
                map.put("token",verify_id);
                return map;

            }
        };
        queue.add(req);

    }
















    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        sqlb=new SQLB(getContext());
        Role= sqlb.getrole();
      //  get_permission();
//        Log.w("getroledata",Role);
        arrayList11=new ArrayList<>();
        if (Role.equals("Admin")){

        }else if(Role.equals("Guest")){

        }
        else{
            arrayList11= sqlb.getLoginstudentDetails();
            verify_id=arrayList11.get(0).getVerify_code();
        }

        batcharray=new ArrayList<>();
        //Log.w("gigigigigh",verify_id);
        if(Role.equals("Tutor")){
            arrayList11= sqlb.getLoginstudentDetails();
            verify_id=arrayList11.get(0).getVerify_code();
            sendBtach_details(verify_id);
        }

        getvideo();



        img1=view.findViewById(R.id.img1);
        img2=view.findViewById(R.id.img2);
        img3=view.findViewById(R.id.img3);
        img4=view.findViewById(R.id.img4);
        img5=view.findViewById(R.id.img5);
        LiveClass=view.findViewById(R.id.LiveClass);
        studymaterial_id=view.findViewById(R.id.studymaterial_id);
        performanceLay=view.findViewById(R.id.performanceLay);
        addBatchLay=view.findViewById(R.id.addBatchLay);
        AssignLay=view.findViewById(R.id.AssignLay);
        addtestlay=view.findViewById(R.id.addtestLay);
        PermissionLay=view.findViewById(R.id.PermissionLay);
        SAssignLay=view.findViewById(R.id.SAssignLay);
        STestLay=view.findViewById(R.id.STestLay);
        AddStudyVideos=view.findViewById(R.id.AddStudyVideos);




        Glide.with(view).load("data:image/png;base64,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").into(img1);
        Glide.with(view).load(R.drawable.offlinedownload).into(img4);
        Glide.with(view).load(R.drawable.practice).into(img3);
        Glide.with(view).load(R.drawable.studymaterial).into(img2);
        Glide.with(view).load(R.drawable.performance).into(img5);


        if (Role.equals("Student")){
            addBatchLay.setVisibility(View.GONE);
            addtestlay.setVisibility(View.GONE);
            AssignLay.setVisibility(View.GONE);
            performanceLay.setVisibility(View.GONE);
            PermissionLay.setVisibility(View.GONE);
            SAssignLay.setVisibility(View.VISIBLE);
            AddStudyVideos.setVisibility(View.GONE);



        }else if (Role.equals("Tutor")){
            addBatchLay.setVisibility(View.GONE);
            PermissionLay.setVisibility(View.GONE);
            performanceLay.setVisibility(View.GONE);
            AddStudyVideos.setVisibility(View.GONE);

           // SAssignLay.setVisibility(View.GONE);
            Log.w(".sssssss...sss.s","enterdlsssss");
            Log.w(".s.s.s.s.s.s..s.s.s",sqlb.getPermissionDetails().get(0).getAttendace());
            if (sqlb.getPermissionDetails().get(0).getAttendace().equals("1")){
                AssignLay.setVisibility(View.VISIBLE);
            }else{
                AssignLay.setVisibility(View.GONE);
            }

            if (sqlb.getPermissionDetails().get(0).getTest().equals("1")){
               addtestlay.setVisibility(View.VISIBLE);
            }else{
                addtestlay.setVisibility(View.GONE);
            }

            if (sqlb.getPermissionDetails().get(0).getStudy_material().equals("1")){
                studymaterial_id.setVisibility(View.VISIBLE);
            }else{
                studymaterial_id.setVisibility(View.GONE);
            }
            if (sqlb.getPermissionDetails().get(0).getLive_class().equals("1")){
                LiveClass.setVisibility(View.VISIBLE);
            }else{
                LiveClass.setVisibility(View.GONE);
            }




//
//            addBatchLay.setVisibility(View.GONE);
//            if (sqlb.getPermissionDetails().get(0).getAssignment().equals("1")){
//                Log.w(".sssssss...sss.s","enterdvvvvvvvvvvvv");
//                AssignLay.setVisibility(View.VISIBLE);
//            }else {
//                Log.w(".sssssss...sss.s","enterd");
//                AssignLay.setVisibility(View.GONE);
//            }
//



        }else if(Role.equals("Guest")){
            addBatchLay.setVisibility(View.GONE);
            addtestlay.setVisibility(View.GONE);
            //AssignLay.setVisibility(View.GONE);
            performanceLay.setVisibility(View.GONE);
            PermissionLay.setVisibility(View.GONE);
            SAssignLay.setVisibility(View.VISIBLE);
            //LiveClass.setVisibility(View.GONE);
            //SAssignLay.setVisibility(View.GONE);
            //STestLay.setVisibility(View.GONE);
            AddStudyVideos.setVisibility(View.GONE);

        }




        else{
            STestLay.setVisibility(View.GONE);
            SAssignLay.setVisibility(View.GONE);
            studymaterial_id.setVisibility(View.GONE);
            performanceLay.setVisibility(View.GONE);

        }


        performanceLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Role.equals("Guest")){
                    Toast.makeText(getContext(), "Not Assigned to any batch", Toast.LENGTH_SHORT).show();

                }
                else {


                    Intent i = new Intent(getContext(), BatchInAdminPerformance.class);
                    startActivity(i);
                }



            }
        });


        studymaterial_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(),Inside_studyMaterials_activity.class);
                startActivity(i);

            }
        });


        addBatchLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent i=new Intent(getContext(),AdminPage.class);
                    startActivity(i);

            }
        });


         LiveClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Role.equals("Guest")) {
                    Toast.makeText(getContext(), "Not Assigned to any batch", Toast.LENGTH_SHORT).show();

                } else {

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    ViewGroup viewGroup = v.findViewById(android.R.id.content);
                    View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.liveclass_layout, viewGroup, false);
                    builder.setView(dialogView);


                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    meeting_code = dialogView.findViewById(R.id.meeting_code);
                    meeting_batch_spinner = dialogView.findViewById(R.id.meeting_batch_spinner);
                    if (Role.equals("Student")) {

                        meeting_batch_spinner.setVisibility(View.GONE);

                    }
                    if (Role.equals("Admin")) {
                        meeting_code = dialogView.findViewById(R.id.meeting_code);
                        meeting_batch_spinner.setVisibility(View.GONE);

                    } else {

                        sendBtach_details(verify_id);

                    }


                    Log.w("arraylistsizeee", String.valueOf(batcharray.size()));


                    adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, batcharray);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    meeting_batch_spinner.setAdapter(adapter);
                    meeting_batch_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            batch = String.valueOf(adapterView.getItemAtPosition(i));
                            Log.w("selected month", batch);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });


                    joinorcreate = dialogView.findViewById(R.id.joinorcreate);
                    joinorcreate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getContext(), MeetingActivity.class);
                            intent.putExtra("meetingcode", meeting_code.getText().toString());
                            intent.putExtra("role", Role);
                            startActivity(intent);


                            Toast.makeText(getContext(), "Hoooo", Toast.LENGTH_SHORT).show();
                        }
                    });


                }
            }
        });

        addtestlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(),AddTestAdmin.class);
                startActivity(i);
            }
        });

        AssignLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Role.equals("Guest")){
                    Toast.makeText(getContext(), "Not Assigned to any batch", Toast.LENGTH_SHORT).show();

                }
                else {
                    Intent i = new Intent(getContext(), AddAdminAssign.class);
                    startActivity(i);
                }

            }
        });

        PermissionLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getContext(),Admin_permisions.class);
                startActivity(i);
            }
        });

        SAssignLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Role.equals("Guest")){
                    Toast.makeText(getContext(), "Not Assigned to any batch", Toast.LENGTH_SHORT).show();

                }
                else {

                    Intent i = new Intent(getContext(), Assignment_for_student.class);
                    startActivity(i);
                }
            }
        });

        STestLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Role.equals("Guest")){
                    Toast.makeText(getContext(), "Not Assigned to any batch", Toast.LENGTH_SHORT).show();

                }
                else {
                    Intent i = new Intent(getContext(), Test_For_Student.class);
                    startActivity(i);
                }
            }
        });
        AddStudyVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(),Admin_add_video_Section.class);
                startActivity(i);

            }
        });



        recyclerView=view.findViewById(R.id.recyclervideo);
        arrayList=new ArrayList<>();
        linearLayoutManager=new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false);
        adapterForVideos=new AdapterForVideos(getContext(),arrayList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterForVideos);
//
//
       // Glide.with(view).load("data:image/png;base64,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").into(img2);
        return view;
    }
}