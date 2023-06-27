package com.axis.axislanguageschool;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class ProfilePageForStudent extends Fragment {
    View view;
    TabLayout tabLayout;
    ViewPager viewPager;
    SQLB sqlb;
    String Role;
    ArrayList<StudentDetailsDataClass>arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_profile_page_for_student, container, false);




        viewPager = view.findViewById(R.id.view_pagerProfStudent);
        tabLayout = view.findViewById(R.id.tabsstudent);
       // fab=view.findViewById(R.id.fab);
       // circle_imageView_in_universitytitle=.findViewById(R.id.circle_imageView_in_universitytitle);
        sqlb=new SQLB(getContext());
        arrayList=new ArrayList<>();
        arrayList=sqlb.getLoginstudentDetails();
        Role=arrayList.get(0).getRole();
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
//            }
//        });

        ViewpagerForStudentProfile viewPagerAdapter = new ViewpagerForStudentProfile(getChildFragmentManager(),Role);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tabLayout.setupWithViewPager(viewPager);








        return view;
    }
}