package com.axis.axislanguageschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

public class batches_in_o extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager1;
    ImageView backbuttoninAdminAddAssignment8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batches_in_o);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        backbuttoninAdminAddAssignment8=findViewById(R.id.backbuttoninAdminAddAssignment8);
        backbuttoninAdminAddAssignment8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tabLayout=findViewById(R.id.tabs34);
        viewPager1=findViewById(R.id.view_pager34);
        ViewPagerAdapter1 viewPagerAdapter1 = new ViewPagerAdapter1(getSupportFragmentManager());
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