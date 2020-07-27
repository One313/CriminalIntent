package com.example.criminalintent.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.criminalintent.controller.fragment.CrimeDetailFragment;

import java.util.UUID;

public class CrimeDetailActivity extends SingleFragmentActivity {

    public static final String EXTRA_CRIME_ID = "com.example.criminalintent.controller.activity.ExtraCrimeId";
    public static final String ARG_CRIME_ID = "com.example.criminalintent.controller.activity.ArgCrimeId";

    /**
     * @param context context of src
     * @param crimeId this activity need Crime id to work
     * @return return intent
     */
    public static Intent newIntent(Context context, UUID crimeId) {
        Intent intent = new Intent(context, CrimeDetailActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    public static CrimeDetailFragment newInstance(UUID crimeId) {

        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);
        CrimeDetailFragment fragment = new CrimeDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public Fragment createFragment() {
        /*CrimeDetailFragment crimeDetailFragment = new CrimeDetailFragment();

        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_CRIME_ID, crimeId);
        crimeDetailFragment.setArguments(bundle);

        return crimeDetailFragment;*/

        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return newInstance(crimeId);
    }
}
