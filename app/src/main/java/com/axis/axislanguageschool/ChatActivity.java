package com.axis.axislanguageschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

ImageView back1;

    FirebaseAuth firebaseAuth;
    DatabaseReference myRef1;
    ArrayList<User> arrayList;
    RecyclerView recyclerView;
    EditText edt;
    String Role,Batchname,verify_code;
    chatadapter chatadapter;
    String  sender;//006
    String tutor;
    String recievr;
    Boolean clear=true;
    DatabaseReference myRef;
    SQLB sqlb;
    String Admin_verify_code;
    FloatingActionButton btn;
    ArrayList<StudentDetailsDataClass>senderdetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        back1=findViewById(R.id.back1);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        senderdetails=new ArrayList<>();

        sqlb=new SQLB(this);
        senderdetails=sqlb.getLoginstudentDetails();
       Role=sqlb.getrole();
        //Role="Tutor    ";
        Log.w("Role rolr rolr",Role+" jjjj");

//        sender=senderdetails.get(0).getVerify_code();

        firebaseAuth=FirebaseAuth.getInstance();


        if (Role.equals("Tutor")){
            sender=sqlb.getrole_admin();
            tutor=senderdetails.get(0).getVerify_code();
            Intent intent=getIntent();
            recievr=intent.getStringExtra("reciever_code");

            Log.w("I ENTERD HERE",recievr);

        }else if(Role.equals("Admin")) {
            Intent intent=getIntent();
            recievr=intent.getStringExtra("reciever_code");

            sender=sqlb.getrole_admin();
        }else{
            senderdetails=sqlb.getLoginstudentDetails();
            //senderdetails=sqlb.getLoginstudentDetails();
           // Log.w("SEnderarraySize", String.valueOf(senderdetails.size()));
            sender=senderdetails.get(0).getVerify_code();
            recievr=sqlb.getrole_admin();
           // sender=senderdetails.get(0).getVerify_code();
        }
//       Log.w("arralistsize", String.valueOf(sqlb.getLoginstudentDetails()));
//       // Log.w("SEnderSDATA",sqlb.getrole());
//      //  Log.w("")
//
//
//        Log.w("senderVerifyCode",sender);



//        Role=intent.getStringExtra("reciever_role");


        firebaseAuth= FirebaseAuth.getInstance();
        edt=findViewById(R.id.editTextTextPersonName);

        arrayList
                =new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        recyclerView=findViewById(R.id.rechat);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


            chatadapter=new chatadapter(arrayList,getApplicationContext(),sender,Role,tutor);


        recyclerView.setAdapter(chatadapter);

        myRef = database.getReference("chat").child(recievr+sender);

        myRef.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                arrayList.clear();

                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    User value = dataSnapshot1.getValue(User.class);
                    arrayList.add(new User(value.getUsername(), value.getMsg(), value.getId()));

                }

                Log.w("arraylistsizeee", String.valueOf(arrayList.size()));
                chatadapter.notifyDataSetChanged();
                recyclerView.scrollToPosition(arrayList.size()-1 );

            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("", "Failed to read value.", error.toException());
            }
        });
         btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Role.equals("Tutor")){
                    writeNewUser(tutor,"",edt.getText().toString());
                }else {
                    writeNewUser(sender,"",edt.getText().toString());

                }

                edt.setText("");
            }
        });


    }
    public void writeNewUser(String id, String name, String msg) {

        User user = new User(name, msg,id);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef1 = database.getReference("chat");
        myRef1.child(sender+recievr).push().setValue(user);
        myRef1.child(recievr+sender).push().setValue(user);
    }






}