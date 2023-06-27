package com.axis.axislanguageschool;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdaterForAdminStudent extends FragmentPagerAdapter {
    String batchname;
    public ViewPagerAdaterForAdminStudent(@NonNull FragmentManager fm, String batchname) {
        super(fm);
        this.batchname=batchname;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {



        Fragment fragment = null;
        if (position == 0)
            fragment = new StudentDetailsInAdmin(batchname);
        else if (position == 1)
            fragment = new TutorInAdmin(batchname);

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
            title = "Student";
        else if (position == 1)
            title = "Tutor";

        return title;
    }
}
