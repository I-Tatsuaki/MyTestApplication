package com.example.it.mytestapplication;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by IT on 2017/07/05.
 */

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    public ArrayList<String> tabTitles;
    private Context context;

    public MainFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabTitles = new ArrayList<String>();
    }

    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                return new HomePageFragment();
            case 1:
                return new ToolsPageFragment();
            case 2:
                return MainPageFragment.newInstance(position);
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }

    @Override
    public int getCount() {
        return tabTitles.size();
    }
}
