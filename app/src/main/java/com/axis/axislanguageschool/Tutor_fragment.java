package com.axis.axislanguageschool;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Tutor_fragment extends Fragment {
    RecyclerView tutor_rv;
    Adapter_for_tutor adapt_turor;
    ArrayList<tutor_data_model> arrayList_tutor;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        arrayList_tutor=new ArrayList<>();
        arrayList_tutor.add(new tutor_data_model("Gladson","70%","7907813158"));
        arrayList_tutor.add(new tutor_data_model("Gladson john","80%","7907813158"));
        arrayList_tutor.add(new tutor_data_model("Gladson john sunny","90%","7907813158"));

        View v6= inflater.inflate(R.layout.fragment_tutor_fragment, container, false);
        tutor_rv=v6.findViewById(R.id.admin_tutor_rv);
        LinearLayoutManager yo1=new LinearLayoutManager(getContext());
        tutor_rv.setLayoutManager(yo1);
        adapt_turor=new Adapter_for_tutor(getContext(),arrayList_tutor);

        tutor_rv.setAdapter(adapt_turor);
        return v6;
    }
}