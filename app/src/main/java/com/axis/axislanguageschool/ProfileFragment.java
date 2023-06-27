package com.axis.axislanguageschool;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    SQLB sqlb;
    CircleImageView circle_imageView_in_universitytitle;
    FloatingActionButton fab;
    int PICK_IMAGE=123;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V= inflater.inflate(R.layout.fragment_profile, container, false);
        viewPager = V.findViewById(R.id.view_pager);
        tabLayout = V.findViewById(R.id.tabs);
       // fab=V.findViewById(R.id.fab);
        circle_imageView_in_universitytitle=V.findViewById(R.id.circle_imageView_in_universitytitle);
        sqlb=new SQLB(getContext());
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
//            }
//        });

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
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

        return V;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

     if (requestCode==PICK_IMAGE){

        // sqlb.insertprof_img(data.getData());


         circle_imageView_in_universitytitle.setImageURI(data.getData());
         sqlb.insertprof_img(data.getData());
         Log.w("URI DATA",data.getData().toString());

     }

        super.onActivityResult(requestCode, resultCode, data);
    }
}