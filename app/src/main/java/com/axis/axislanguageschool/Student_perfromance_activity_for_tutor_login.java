package com.axis.axislanguageschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Student_perfromance_activity_for_tutor_login extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    String role = "Tutor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_perfromance_for_tutor_login);

              tabLayout=findViewById(R.id.tab_layout_new2);
              viewPager=findViewById(R.id.view_pger_new2);

              ViewpagerForStudentProfile viewPagerAdapter11 = new  ViewpagerForStudentProfile(getSupportFragmentManager(),role);

        viewPager.setAdapter(viewPagerAdapter11);
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
    }
}