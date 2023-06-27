package com.axis.axislanguageschool;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapterForStudentInfotab extends FragmentPagerAdapter {
    String verify_name;
    String studentname;
    String batchname;

    public ViewPagerAdapterForStudentInfotab(@NonNull FragmentManager fm,String verify_name,String studentname,String batchname) {
        super(fm);
        this.studentname=studentname;
        this.verify_name=verify_name;
        this.batchname=batchname;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
            fragment = new BatchOverview(verify_name,studentname);
        else if (position == 1)
            fragment = new BatchAttendance(studentname,verify_name);
        else if (position == 2)
            fragment = new BatchAssignment(studentname,verify_name,batchname);
        else if(position ==3)
            fragment=new BatchTest(studentname,verify_name,batchname);




        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
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
            title = "Test";
        else if (position == 4)
            title = "Personal info";
        return title;
    }
}
