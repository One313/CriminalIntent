package com.example.criminalintent.controller.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.criminalintent.R;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    public abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        /*FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, new CrimeDetailFragment());
            fragmentTransaction.commit();
        }*/

        if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, createFragment())
                    .commit();
    }
}
