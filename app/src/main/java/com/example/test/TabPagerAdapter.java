package com.example.test;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.TabHost;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentMenu1 Fragment1 = new FragmentMenu1();
                return Fragment1;
            case 1:
                FragmentMenu2 Fragment2 = new FragmentMenu2();
                return Fragment2;
            case 2:
                FragmentMenu3 Fragment3 = new FragmentMenu3();
                return Fragment3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

}
