package com.axis.axislanguageschool;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ShowBatchAdmin extends Fragment {


    SQLB sqlb;
    View view;
    ArrayList<StudentDetailsDataClass>arrayList;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_show_batch_admin, container, false);

        sqlb=new SQLB(getContext());
        arrayList=new ArrayList<>();
        arrayList=sqlb.getLoginstudentDetails();
        recyclerView=view.findViewById(R.id.Recycler_for_showBatch);
        linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        AdapterForShowBatchAdmin adapterForShowBatchAdmin=new AdapterForShowBatchAdmin(getContext(),arrayList);
        recyclerView.setAdapter(adapterForShowBatchAdmin);






        return view;
    }
}