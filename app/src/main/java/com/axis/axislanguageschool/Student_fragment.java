package com.axis.axislanguageschool;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Student_fragment extends Fragment {
    RecyclerView rcc;
    Adapter_for_Student adapter_for_student;
    ArrayList<Student_data_model> arrayList_stu;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_student_fragment, container, false);
        rcc=view.findViewById(R.id.admin_student_rv);

        arrayList_stu=new ArrayList<>();
        arrayList_stu.add(new Student_data_model("Gladson","ielts","9207149640","70%"));
        arrayList_stu.add(new Student_data_model("anandhakrishnan","ielts","9207149640","60%"));
        arrayList_stu.add(new Student_data_model("akshay","ielts","9217149640","70%"));
        arrayList_stu.add(new Student_data_model("neethu","ielts","9237149640","80%"));
        arrayList_stu.add(new Student_data_model("dona","ielts","9247149640","90%"));
        arrayList_stu.add(new Student_data_model("percy","ielts","9257149640","70%"));

        LinearLayoutManager yo12=new LinearLayoutManager(getContext());
        rcc.setLayoutManager(yo12);
        adapter_for_student=new Adapter_for_Student(getContext(),arrayList_stu);

        rcc.setAdapter(adapter_for_student);


        return view;
    }
}