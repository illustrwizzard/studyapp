package com.axis.axislanguageschool;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewpagerForStudentProfile extends FragmentPagerAdapter {
         String role;

    public ViewpagerForStudentProfile(FragmentManager childFragmentManager, String role) {
        super(childFragmentManager);
         this.role=role;
        Log.w("LLLLLLLLLLLLLLLLLL",role);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        if (role.equals("Tutor")) {

            if (position == 0)
                fragment =new ProfilePerformance();
//            else if (position == 1)
//                fragment = new BatchAttendance();
            else if (position == 2)
                fragment = new StudentPersonalInfo();

            return fragment;

        }else if (role.equals("Student")){

            if (position == 0)
                fragment = new ProfilePerformance();
//            else if (position == 1)
//                fragment = new BatchAttendance();
            else if (position == 2)
                fragment = new StudentPersonalInfo();

            return fragment;

        }else {

            if (position == 0)
                fragment = new ProfilePerformance();
//            else if (position == 1)
//                fragment = new BatchAttendance();
            else if (position == 2)
                fragment = new StudentPersonalInfo();

            return fragment;
        }
    }

    @Override
    public int getCount() {
        if (role.equals("Tutor")) {
            return 3;

        }else if (role.equals("Student")){
            return 3;

        }else {
            return 3;
        }
    }



    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;

        if (role.equals("Tutor")) {
            if (position == 0)
                title = "Performance";
            else if (position == 1)
                title = "Attendance";
            else if (position == 2)
                title = "Personal info";
            return title;

        }else if (role.equals("student")){
            if (position == 0)
                title = "Performance";
            else if (position == 1)
                title = "Attendance";
            else if (position == 2)
                title = "Personal info";
            return title;

        }else {
            if (position == 0)
                title = "Performance";
            else if (position == 1)
                title = "Attendance";
            else if (position == 2)
                title = "Personal info";
            return title;
        }
    }
}

