package com.axis.axislanguageschool;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.react.modules.core.PermissionListener;

import org.jitsi.meet.sdk.BroadcastEvent;
import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetActivityDelegate;
import org.jitsi.meet.sdk.JitsiMeetActivityInterface;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import timber.log.Timber;

public class MeetingActivity extends AppCompatActivity implements JitsiMeetActivityInterface {



String url="http://language.axisjobs.in/api/meeting/";
String Batch="2022";
int flag,time=0;
SQLB sqlb;
JitsiMeetActivity session;
GFG gfg;
long difft;
LocalTime time1,time2;
HashMap<String,Student_session>map;
tm T;
ArrayList<StudentDetailsDataClass>arrayList;
String url_meeting="http://language.axisjobs.in/api/meeting/tutor_meet";







    String meetingcode,role,verify_id;
    String tutor_meeting_role;






////////


    public void sendTutor_details(String meetingcode ,String verify_id ){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String currentdate = formatter.format(date);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time=sdf.format(cal.getTime());



        RequestQueue queue = Volley.newRequestQueue(MeetingActivity.this );
        StringRequest req=new StringRequest(Request.Method.POST, url_meeting, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("responseeefde",response);


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
                map.put("date",currentdate);
                map.put("time",time);
                map.put("tokken",verify_id);
                map.put("meet_code",meetingcode);
                map.put("batch_name",Batch);

                return map;

            }
        };
        queue.add(req);

    }




    //////







    public void sendsesession_details(String meetingcode ,String verify_id ,String total_time,String status){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String currentdate = formatter.format(date);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time=sdf.format(cal.getTime());






        RequestQueue queue = Volley.newRequestQueue(MeetingActivity.this );
        StringRequest req=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("responseeee",response);


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
                map.put("date",currentdate);
                map.put("time",time);
                map.put("tokken",verify_id);
                map.put("status",status);

                map.put("meet_code",meetingcode);
                map.put("batch_name",Batch);
                map.put("total_time",total_time);

                return map;

            }
        };
        queue.add(req);

    }



    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onReceive(Context context, Intent intent) {
            onBroadcastReceived(intent);
            if( onBroadcastReceived(intent)==1){

                new asyn().execute();

            }
        }
    };




    private void registerForBroadcastMessages() {
        IntentFilter intentFilter = new IntentFilter();

        /* This registers for every possible event sent from JitsiMeetSDK
           If only some of the events are needed, the for loop can be replaced
           with individual statements:
           ex:  intentFilter.addAction(BroadcastEvent.Type.AUDIO_MUTED_CHANGED.getAction());
                intentFilter.addAction(BroadcastEvent.Type.CONFERENCE_TERMINATED.getAction());
                ... other events
         */
        for (BroadcastEvent.Type type : BroadcastEvent.Type.values()) {
            intentFilter.addAction(type.getAction());
        }

        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter);
    }



    // Example for handling different JitsiMeetSDK events
    @RequiresApi(api = Build.VERSION_CODES.O)
    private int onBroadcastReceived(Intent intent) {
        if (intent != null) {
            BroadcastEvent event = new BroadcastEvent(intent);

            switch (event.getType()) {
                case CONFERENCE_JOINED:
                    flag = 1;
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    String time = sdf.format(cal.getTime());
                    DateTimeFormatter parser = DateTimeFormatter.ofPattern("HH:mm:ss");
                    time1 = LocalTime.parse(time, parser);

                    Timber.i("Conference Joined with url%s", event.getData().get("url"));
                    if (role.equals("Tutor")) {
                        sendTutor_details(meetingcode, verify_id);
                        //  T.run();

                    }
                    if (role.equals("Student")) {
                        // T.run();
                        flag = 1;
                        //  Student_session student_session=new Student_session(sqlb.getLoginstudentDetails().get(0).getVerify_code(), time);

                        sendsesession_details(meetingcode, sqlb.getLoginstudentDetails().get(0).getVerify_code(), String.valueOf(time), "join");


                    } else {
                        Log.w("yooooooooo", "wassssuppppp");
                    }
//                    else {
//                        T.run();
//                        Student_session student_session=new Student_session("_join", time);
//
//                        map.put(event.getData().get("name").toString()+"_join",student_session);
//
//                    }

                    break;


                // sendsesession_details(meetingcode,verify_id);


//                case PARTICIPANT_LEFT:
//                    Timber.i("Participant left%s", event.getData().get("name"));
//                    if(!(event.getData().get("name") == null)){
//
//                    Student_session student_session1=map.get(event.getData().get("name")+"_join");
//
//                    int totaltime=time-student_session1.getJoin_time();
//                    Log.w("Totaltime", String.valueOf(totaltime));
//
//                    sendsesession_details("ADD","001",String.valueOf(totaltime));}
//
//
//
//
//                    break;

                case CONFERENCE_TERMINATED:
                    if (role.equals("Admin")) {
                        session.leave();
                        Intent i = new Intent(MeetingActivity.this, BottomNavigation.class);
                        startActivity(i);

                    } else {


                    Timber.i("Participant left%s", event.getData().get("name"));
                    cal = Calendar.getInstance();
                    sdf = new SimpleDateFormat("HH:mm:ss");
                    time = sdf.format(cal.getTime());
                    parser = DateTimeFormatter.ofPattern("HH:mm:ss");
                    time2 = LocalTime.parse(time, parser);
                    long seconds
                            = ChronoUnit.SECONDS.between(time1, time2) % 60;
                    Log.w("ENTERED", "YEAHHHHHH");
                    Student_session student_session1 = map.get("_join");
                    sendsesession_details(meetingcode, sqlb.getLoginstudentDetails().get(0).getVerify_code(), String.valueOf(seconds), "left");
                    try {
                        session.leave();
                        Intent i = new Intent(MeetingActivity.this, BottomNavigation.class);
                        startActivity(i);
                    } catch (Exception e) {
                        Log.w("Failed to properly leave ", e);
                    }
            }








                    break;





            }
        }
        return flag;
    }
    class tm extends Thread{
        @Override
        public void run() {
            while (true){

                try {
                    time=time+1;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }



    class asyn extends AsyncTask<Void,Void,Void>{


        @Override
        protected Void doInBackground(Void... voids) {

//            sendsesession_details(meetingcode,verify_id,);
            sendTutor_details(meetingcode,verify_id);
            return null;
        }
    }





    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        sqlb=new SQLB(this);
        role=sqlb.getrole();
        arrayList=new ArrayList<>();
        if (role.equals("Admin")){
            //verify_id="AXISADM01";

        }else{
            arrayList= sqlb.getLoginstudentDetails();
            verify_id=arrayList.get(0).getVerify_code();

            Log.w("kkskskskskksksksksks",role);
        }

        map=new HashMap<>();




        try {
            JitsiMeetConferenceOptions option = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(new URL("https://meet.jit.si"))

                    .setWelcomePageEnabled(false)
                    .setConfigOverride("requireDisplayName", true)
                    .build();
            JitsiMeet.setDefaultConferenceOptions(option);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Intent i=getIntent();
        meetingcode=i.getStringExtra("meetingcode");


        JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                .setRoom(meetingcode).setWelcomePageEnabled(true).build();
        session = new JitsiMeetActivity();
        session.launch(getApplicationContext(), options);


registerForBroadcastMessages();







    }












    @Override
    public void requestPermissions(String[] strings, int i, PermissionListener permissionListener) {

    }
}