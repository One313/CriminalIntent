package com.example.criminalintent.repository;

import com.example.criminalintent.model.Crime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeRepository implements RepositoryInterface<Crime> {

    private final static int NUMBER_OF_CRIMES = 100;
    private static CrimeRepository sCrimeRepository = null;

    public static CrimeRepository getInstance() {
        if (sCrimeRepository == null)
            sCrimeRepository = new CrimeRepository();

        return sCrimeRepository;
    }


    private List<Crime> mCrimes;

    @Override
    public List<Crime> getAll() {
        return mCrimes;
    }

    @Override
    public Crime get(UUID uuid) {
        for (int i = 0; i < NUMBER_OF_CRIMES; i++) {
            if (mCrimes.get(i).getId().equals(uuid))
                return mCrimes.get(i);
        }
        return null;
    }

    @Override
    public void update(Crime crime) {
        Crime updateCrime = get(crime.getId());
        updateCrime.setTitle(crime.getTitle());
        updateCrime.setDate(crime.getDate());
        updateCrime.setSolved(crime.isSolved());
    }

    @Override
    public void delete(Crime crime) {
        getAll().remove(crime);
    }

    @Override
    public void insert(Crime crime) {
        mCrimes.add(crime);
    }

    @Override
    public void insertAll(List<Crime> crimes) {
        mCrimes.addAll(crimes);
    }

    @Override
    public void set(List<Crime> crimes) {
        mCrimes = crimes;
    }

    private CrimeRepository() {
        mCrimes = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_CRIMES; i++) {
            mCrimes.add(new Crime("Crime #" + (i + 1), i % 2 == 0));
        }
    }
}
