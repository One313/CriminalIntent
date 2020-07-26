package com.example.criminalintent.repository;

import com.example.criminalintent.model.Crime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeRepository implements RepositoryInterface {

    private final static int NUMBER_OF_CRIMES = 100;
    private static CrimeRepository sCrimeRepository = null;

    public static CrimeRepository getInstance() {
        if (sCrimeRepository == null)
            sCrimeRepository = new CrimeRepository();

        return sCrimeRepository;
    }


    private List<Crime> mCrimes;

    @Override
    public List<Crime> getCrimes() {
        return mCrimes;
    }

    @Override
    public Crime getCrime(UUID uuid) {
        for (int i = 0; i < NUMBER_OF_CRIMES; i++) {
            if (mCrimes.get(i).getId().equals(uuid))
                return mCrimes.get(i);
        }
        return null;
    }

    @Override
    public void updateCrime(Crime crime) {
        Crime updateCrime = getCrime(crime.getId());
        updateCrime.setTitle(crime.getTitle());
        updateCrime.setDate(crime.getDate());
        updateCrime.setSolved(crime.isSolved());
    }

    @Override
    public void deleteCrime(Crime crime) {
        getCrimes().remove(crime);
    }

    @Override
    public void insertCrime(Crime crime) {
        mCrimes.add(crime);
    }

    @Override
    public void insertCrimes(List<Crime> crimes) {
        mCrimes.addAll(crimes);
    }

    public void setCrimes(List<Crime> crimes) {
        mCrimes = crimes;
    }

    private CrimeRepository() {
        mCrimes = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_CRIMES; i++) {
            mCrimes.add(new Crime("Crime #" + (i + 1), i % 2 == 0));
        }
    }
}
