package com.axis.axislanguageschool;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Class_perform_fragment extends Fragment {
    RecyclerView test_rv;
    ArrayList<test_model_class> arrayList_test;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_class_perform_fragment, container, false);
        test_rv=view.findViewById(R.id.recycle_test);


        arrayList_test=new ArrayList<>();
        arrayList_test.add(new test_model_class("24/07/2022","90/100","24/100","90/100"));
        arrayList_test.add(new test_model_class("05/07/2022","90/100","24/100","90/100"));
        arrayList_test.add(new test_model_class("10/07/2022","90/100","24/100","90/100"));
        arrayList_test.add(new test_model_class("20/07/2022","90/100","24/100","90/100"));
        arrayList_test.add(new test_model_class("24/07/2022","90/100","24/100","90/100"));
        arrayList_test.add(new test_model_class("30/07/2022","90/100","24/100","90/100"));
        arrayList_test.add(new test_model_class("01/08/2022","90/100","24/100","90/100"));

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        AdapteerFor_test_reView adapteerFor_test_reView= new  AdapteerFor_test_reView(getContext(),arrayList_test);
        test_rv.setLayoutManager(layoutManager);
        test_rv.setAdapter(adapteerFor_test_reView);
        return view;
    }
}