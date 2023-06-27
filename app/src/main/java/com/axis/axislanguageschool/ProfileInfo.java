package com.axis.axislanguageschool;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class ProfileInfo extends Fragment {

 TextView t1,t2,t3,t4;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1= inflater.inflate(R.layout.fragment_profile_info, container, false);
        t1=v1.findViewById(R.id.t1text1);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),profilePersonInformation.class);
                    startActivity(i);
            }
        });

        t2=v1.findViewById(R.id.t1text111);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii=new Intent(getContext(),profilePersonalDetails.class);
                startActivity(ii);
            }
        });

         t3=v1.findViewById(R.id.t1text1111);
         t3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i1=new Intent(getContext(),Address.class);
                 startActivity(i1);
             }
         });
         t4=v1.findViewById(R.id.t1text11111);
         t4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent y=new Intent(getContext(),Education_Details.class);
                 startActivity(y);
             }
         });


        return v1;
    }
}