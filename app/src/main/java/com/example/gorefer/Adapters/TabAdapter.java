package com.example.gorefer.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gorefer.Fragments.OfferingsFragment;
import com.example.gorefer.Fragments.ReccomendsFragment;
import com.example.gorefer.Fragments.RequestFragment;

public class TabAdapter extends FragmentPagerAdapter {
    Context ct;
    int noOfTabs;

    public TabAdapter(FragmentManager fm, Context ct, int noOfTabs) {
        super(fm);
        this.noOfTabs = noOfTabs;
        this.ct = ct;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                RequestFragment requestFragment = new RequestFragment();
                return requestFragment;
            case 1:
                OfferingsFragment offeringsFragment = new OfferingsFragment();
                return offeringsFragment;
            case 2:
                ReccomendsFragment reccomendsFragment = new ReccomendsFragment();
                return reccomendsFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
