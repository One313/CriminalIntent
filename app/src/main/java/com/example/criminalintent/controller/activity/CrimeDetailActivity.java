package com.example.criminalintent.controller.activity;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.example.criminalintent.controller.fragment.CrimeDetailFragment;

import java.util.UUID;

public class CrimeDetailActivity extends SingleFragmentActivity {

    public static final String CRIME_ID = "com.example.criminalintent.controller.activity.CrimeId";

    /**
     *
     * @param context context of src
     * @param crimeId this activity need Crime id to work
     * @return
     */
    public static Intent newIntent(Context context, UUID crimeId) {
        Intent intent = new Intent(context, CrimeDetailActivity.class);
        intent.putExtra(CRIME_ID, crimeId);
        return intent;
    }

    @Override
    public Fragment createFragment() {
        return new CrimeDetailFragment();
    }
}
