package com.example.shakti.studentplanner;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class SectionsStatePageAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> FragmentList = new ArrayList<>();
    private final List<String> FragmentTitleList = new ArrayList<>();

    public SectionsStatePageAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(CalendarScreen fragment, String title){

        FragmentTitleList.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentList.get(position);
    }

    @Override
    public int getCount() {
        return FragmentList.size();
    }
}
