package com.apps.kabzer.reshelf;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SwipeAdapterReshelf extends FragmentStatePagerAdapter{
    public SwipeAdapterReshelf(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        String[] page = {" ", "Your sale is empty"};
        Bundle bundle = new Bundle();
        bundle.putString("count", page[i]);
        bundle.putInt("position", i);

        switch (i) {
            case 0:
                YourLibrary tab1 = new YourLibrary();
                return tab1;
            case 1:
                YourSale tab2 = new YourSale();
                tab2.setArguments(bundle);
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
