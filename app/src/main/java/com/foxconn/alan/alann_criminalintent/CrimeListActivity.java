package com.foxconn.alan.alann_criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by alan on 03/03/2018.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
