package com.example.moneysaver.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.moneysaver.Fragment.GoalFragment;
import com.example.moneysaver.Fragment.PayCardFragment;
import com.example.moneysaver.Fragment.TotalFragment;


public class CustomFragmentPager extends FragmentPagerAdapter {
    public CustomFragmentPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                // Your current main fragment showing how to send arguments to fragment

                return new PayCardFragment();
            case 1:
                return new TotalFragment();
            case 2:
                return  new GoalFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
