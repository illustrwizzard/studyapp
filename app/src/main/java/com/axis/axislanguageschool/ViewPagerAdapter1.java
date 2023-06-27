package com.axis.axislanguageschool;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter1 extends FragmentPagerAdapter {

    public ViewPagerAdapter1(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
            fragment = new BatchOverview();
//        else if (position == 1)
//            //fragment = new BatchAttendance();
       // else if (position == 2)
          //  fragment = new BatchAssignment();
        else if(position ==3)
            fragment=new BatchAnnouncement();
        else if(position ==4)
            fragment=new BatchTest("","","");
        else if(position ==5)
            fragment=new BatchVideos();
        else if(position ==6)
            fragment=new BatchLineClass();
        else if(position ==7)
            fragment=new BatchStudyMaterial();


        return fragment;
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
            title = "OVERVIEW";
        else if (position == 1)
            title = "ATTENDANCE";
        else if (position == 2)
            title = "ASSIGNMENT";
        else if (position == 3)
            title = "ANNOUNCEMENT";
        else if (position == 4)
            title = "TEST";
        else if (position == 5)
            title = "VIDEOS";
        else if (position == 6)
            title = "LIVE CLASSES";
        else if (position == 7)
            title = "STUDY MATERIALS";
        return title;
    }
}
