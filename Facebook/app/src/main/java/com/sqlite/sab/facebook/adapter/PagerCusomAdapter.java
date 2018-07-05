package com.sqlite.sab.facebook.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sqlite.sab.facebook.fragments.FirstFragment;
import com.sqlite.sab.facebook.fragments.SecondFragment;

/**
 * Created by Sab on 26/03/2018.
 */

public class PagerCusomAdapter extends FragmentStatePagerAdapter {

    public PagerCusomAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FirstFragment first = new FirstFragment();
                return first;
            case 1:
                SecondFragment second = new SecondFragment();
                return second;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
