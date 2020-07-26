package com.example.criminalintent.repository;

import com.example.criminalintent.model.Crime;

import java.util.List;
import java.util.UUID;

public interface RepositoryInterface {
    List<Crime> getCrimes();  //R
    Crime getCrime(UUID uuid);
    void updateCrime(Crime crime);  //U
    void deleteCrime(Crime crime); //D
    void insertCrime(Crime crime);  //C
    void insertCrimes(List<Crime> crimes);
}
