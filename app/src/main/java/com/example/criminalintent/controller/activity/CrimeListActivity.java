package com.example.criminalintent.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.criminalintent.controller.fragment.CrimeListFragment;

public class CrimeListActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, CrimeListActivity.class);
        // Code
        return intent;
    }

    public static CrimeListFragment newInstance(/*Code*/) {

        Bundle args = new Bundle();
        // Code
        CrimeListFragment fragment = new CrimeListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Fragment createFragment() {
        return newInstance();
    }
}