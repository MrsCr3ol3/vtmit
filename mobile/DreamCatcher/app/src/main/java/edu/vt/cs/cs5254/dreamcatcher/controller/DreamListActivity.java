package edu.vt.cs.cs5254.dreamcatcher.controller;

import android.support.v4.app.Fragment;



public class DreamListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new DreamListFragment();
    }
}
