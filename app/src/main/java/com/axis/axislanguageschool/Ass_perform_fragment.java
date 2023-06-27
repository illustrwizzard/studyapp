package com.axis.axislanguageschool;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Ass_perform_fragment extends Fragment {
    RecyclerView recyclerView;
      Adapter_for_Assign_in_performance adapter;
      ArrayList<Assign_modal_data_in_performance> arrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_ass_perform_fragment, container, false);


        recyclerView=view.findViewById(R.id.recycle_mark_ass);

        arrayList=new ArrayList<>();

        arrayList.add(new Assign_modal_data_in_performance("Assignment 1","02/08/2022"));
        arrayList.add(new Assign_modal_data_in_performance("Assignment 2","02/08/2022"));
        arrayList.add(new Assign_modal_data_in_performance("Assignment 3","02/08/2022"));
        arrayList.add(new Assign_modal_data_in_performance("Assignment 4","02/08/2022"));
        arrayList.add(new Assign_modal_data_in_performance("Assignment 5","02/08/2022"));



        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        adapter=new Adapter_for_Assign_in_performance(arrayList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }
}