package com.axis.axislanguageschool;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
            fragment = new ProfileInfo();
        else if (position == 1)
            fragment = new ProfileBatches();
        else if (position == 2)
            fragment = new ProfilePerformance();
        else if(position ==3)
            fragment=new ProfileAssignments();

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
            title = "INFO";
        else if (position == 1)
            title = "BATCHES";
        else if (position == 2)
            title = "PERFORMANCE";
        else if (position == 3)
            title = "ASSIGNMENTS";
        return title;
    }
}
