package com.axis.axislanguageschool;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class StudentPersonalInfo extends Fragment {
    View view;
    SQLB sqlb;
    TextView stu_name,stu_email,stu_batch,stu_address,stu_mobile;
    ArrayList<StudentDetailsDataClass>arrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_student_personal_info, container, false);
        sqlb=new SQLB(getContext());
        arrayList=new ArrayList<>();
        arrayList=sqlb.getLoginstudentDetails();
        stu_name=view.findViewById(R.id.studentname_in_stprofile);
        stu_email=view.findViewById(R.id.studentemail_in_stprofile);
        stu_batch=view.findViewById(R.id.studentbatch_in_stprofile);
        stu_address=view.findViewById(R.id.studentAddress_in_stprofile);
        stu_mobile=view.findViewById(R.id.studentmob_in_stprofile);
        //arrayList=sqlb.getLoginstudentDetails();
        stu_name.setText("arrayList.get(0).getName().toUpperCase()");
//        stu_email.setText(arrayList.get(0).getEmail());
//        stu_batch.setText(arrayList.get(0).getBatchname().toUpperCase());
//        stu_address.setText(arrayList.get(0).getAddress().toUpperCase());
//        stu_mobile.setText(arrayList.get(0).getMobile());

        return view;
    }
}