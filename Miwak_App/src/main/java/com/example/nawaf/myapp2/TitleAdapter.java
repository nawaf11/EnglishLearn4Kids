package com.example.nawaf.myapp2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by nawaf on 12/30/16.
 */

public class TitleAdapter extends FragmentPagerAdapter {
    public final int  FRAG_NUM=3;

    public TitleAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0: return "NUMBERS";
            case 1: return "FAMILY";
            case 2: return "COLORS";
        }
        return null;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new NumbersFragment();
            case 1: return new FamilyFragment();
            case 2: return new ColorsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return FRAG_NUM;
    }
}
