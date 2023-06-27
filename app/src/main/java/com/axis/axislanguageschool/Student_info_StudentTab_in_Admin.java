package com.axis.axislanguageschool;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Student_info_StudentTab_in_Admin extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager1;
    String verify_code,student_name,batchname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batches_in_o);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        Intent i=getIntent();
       student_name=i.getStringExtra("studentName");
        verify_code=i.getStringExtra("verify_code");
        batchname=i.getStringExtra("batchname_get");


        tabLayout=findViewById(R.id.tabs34);
        viewPager1=findViewById(R.id.view_pager34);
        ViewPagerAdapterForStudentInfotab viewPagerAdapter1 = new ViewPagerAdapterForStudentInfotab(getSupportFragmentManager(),verify_code,student_name,batchname);
        viewPager1.setAdapter(viewPagerAdapter1);
        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tabLayout.setupWithViewPager(viewPager1);
    }
}