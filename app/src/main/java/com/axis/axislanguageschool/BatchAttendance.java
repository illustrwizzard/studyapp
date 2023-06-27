package com.axis.axislanguageschool;

import android.graphics.Color;
import android.icu.text.CaseMap;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BatchAttendance extends Fragment {
    View view;
    PieChart pieChart;
    PieModel pieModel;
    String url="http://language.axisjobs.in/api/meeting/filter_date";
    SQLB sqlb;
    Boolean flag=false;
    TextView NameBatch1,Absent,percentage,hour_attend;
    ArrayList<MeetingDetailsDataClass>meetarray,arrayList1;
    RecyclerView recyclerView;
    AdapterforClassPresent classPresent;
    ArrayList<classPresent_data_modal> arrayList;
    //ArrayList<MeetingDetailsDataClass>arrayList1;
   int total=13;
   int class_attend;
    LinearLayoutManager layoutManager;
    String time_in_hours;
    float total_hours;
    String studentname;
    String verify_name;
    String url_meet="http://language.axisjobs.in/api/meeting/filter_date";

    public BatchAttendance(String studentname, String verify_name) {
        this.verify_name=verify_name;
        this.studentname=studentname;
    }
    //////////////////////////////////////////////////////






    public void get_meet(){




        RequestQueue queue = Volley.newRequestQueue(getContext());
        StringRequest req=new StringRequest(Request.Method.POST, url_meet, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("responseeeehhshshshs ",response);





                JSONObject jsn ;
                try {
                    jsn = new JSONObject(response);
                    JSONArray jsonArray=jsn.getJSONArray("code");
                    for (int i=0;i<jsonArray.length();i++){
                        Log.w("roleoeloeleoe",jsonArray.getJSONObject(i).getString("batch"));
                        sqlb.insert_meetingdetails(jsonArray.getJSONObject(i).getString("batch"),jsonArray.getJSONObject(i).getString("meet_code") ,jsonArray.getJSONObject(i).getString("verify_code") ,jsonArray.getJSONObject(i).getString("date"),jsonArray.getJSONObject(i).getString("status"),jsonArray.getJSONObject(i).getString("time"),jsonArray.getJSONObject(i).getString("total_time"));

                        meetarray.add(new MeetingDetailsDataClass(jsonArray.getJSONObject(i).getString("batch"),jsonArray.getJSONObject(i).getString("meet_code") ,jsonArray.getJSONObject(i).getString("verify_code") ,jsonArray.getJSONObject(i).getString("date"),jsonArray.getJSONObject(i).getString("status"),jsonArray.getJSONObject(i).getString("time"),jsonArray.getJSONObject(i).getString("total_time")));
                        //jsonArray.getJSONObject(i).getString("date")
                        //arrayList.add(new AdminDataClass(jsonArray.getJSONObject(i).getString("batch_name"),jsonArray.getJSONObject(i).getString("date_create")));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                arrayList1= sqlb.getMeetingDetails();
                Log.w("kkdkdljshjks", String.valueOf(arrayList.size()));
                addset();



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
                map.put("verify_code",verify_name);

                return map;

            }
        };
        queue.add(req);

    }































    ///////////////////////////////////////////////




    public Boolean send(String verify_name){
        Log.w("veriffuuuyname........",verify_name);




        RequestQueue queue = Volley.newRequestQueue(getContext() );
        StringRequest req=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("respeeeehhvvvvvvvvvvvcccccccshshshs ",response);





                JSONObject jsn ;
                try {
                    jsn = new JSONObject(response);
                    JSONArray jsonArray=jsn.getJSONArray("code");
                    for (int i=0;i<jsonArray.length();i++){


                        arrayList.add(new classPresent_data_modal(jsonArray.getJSONObject(i).getString("date"),jsonArray.getJSONObject(i).getString("status"),jsonArray.getJSONObject(i).getString("total_time")));
                        sqlb.insert_attendance_Role(jsonArray.getJSONObject(i).getString("status"),jsonArray.getJSONObject(i).getString("total_time"),jsonArray.getJSONObject(i).getString("date"),jsonArray.getJSONObject(i).getString("meet_code"));



                       // classPresent.notifyDataSetChanged();


                        layoutManager=new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(layoutManager);
                        classPresent=new AdapterforClassPresent(arrayList);
                        recyclerView.setAdapter(classPresent);


                    }

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
                map.put("verify_code",verify_name);

                return map;

            }
        };
        queue.add(req);

        return flag=true;
    }
public void addset(){
    arrayList1= sqlb.getMeetingDetails();
//            Log.w("kkdkdljshjks", String.valueOf(arrayList.size()));
    class_attend=arrayList1.size();



    // pieChart.clearChart();
    pieChart.addPieSlice(new PieModel("Rfdddffdff",
            (float) (class_attend),
            Color.parseColor("#f51616")));

    pieChart.addPieSlice(new PieModel("Sfddffdfdf",
            (float) (total-class_attend),
            Color.parseColor("#3ED657")));

    pieChart.startAnimation();



    Absent.setText(String.valueOf(class_attend));

    // Log.w("ABSENT",String.valueOf(total-class_attend));
    NameBatch1.setText(String.valueOf(total-class_attend));
    percentage.setText(String.valueOf((float)(class_attend*100)/total));


}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_batch_attendance, container, false);
        sqlb=new SQLB(getContext());
        meetarray=new ArrayList<>();
        recyclerView=view.findViewById(R.id.recycle_Attendance);
        NameBatch1=view.findViewById(R.id.NameBatch2);
        Absent=view.findViewById(R.id.Absent);
        pieChart=view.findViewById(R.id.piechart);
        arrayList1=new ArrayList<>();
        percentage=view.findViewById(R.id.present);
        arrayList=new ArrayList<>();
        hour_attend=view.findViewById(R.id.hour_attend);
        get_meet();

        if (send(verify_name)){
            percentage=view.findViewById(R.id.present);
            NameBatch1=view.findViewById(R.id.NameBatch2);
//            arrayList1= sqlb.getMeetingDetails();
////            Log.w("kkdkdljshjks", String.valueOf(arrayList.size()));
//            class_attend=arrayList1.size();
//
//
//
//            // pieChart.clearChart();
//            pieChart.addPieSlice(new PieModel("Rfdddffdff",
//                    (float) (class_attend),
//                    Color.parseColor("#f51616")));
//
//            pieChart.addPieSlice(new PieModel("Sfddffdfdf",
//                    (float) (total-class_attend),
//                    Color.parseColor("#3ED657")));
//
//            pieChart.startAnimation();
//
//
//
//            Absent.setText(String.valueOf(class_attend));
//
//           // Log.w("ABSENT",String.valueOf(total-class_attend));
//             NameBatch1.setText(String.valueOf(total-class_attend));
//             percentage.setText(String.valueOf((float)(class_attend*100)/total));

//            //time_in_hours=sqlb.getTime_in_hours(sqlb.getLoginstudentDetails().get(0).getVerify_code());
//            int th= Integer.parseInt(time_in_hours);
//            total_hours=((float) 8000/(float) 3600);
//          //  Log.w("gggggggggggg", String.valueOf(total_hours));
//            hour_attend.setText(String.valueOf(total_hours));

        }
















        return view;
    }
}