package com.axis.axislanguageschool;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter_perform extends FragmentPagerAdapter {
    public ViewPagerAdapter_perform(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
            fragment = new Ass_perform_fragment();
        else if (position == 1)
            fragment = new Class_perform_fragment();

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
            title = "ASSIGNMENT";
        else if (position == 1)
            title = "CLASS TEST";
        return title;
    }
}
