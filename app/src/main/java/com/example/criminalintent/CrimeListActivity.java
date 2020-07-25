package com.example.criminalintent;

import androidx.fragment.app.Fragment;

import com.example.criminalintent.controller.activity.SingleFragmentActivity;
import com.example.criminalintent.controller.fragment.CrimeListFragment;

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new CrimeListFragment();
    }
}