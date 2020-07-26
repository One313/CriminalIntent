package com.example.criminalintent.repository;

import com.example.criminalintent.model.Crime;

import java.util.List;
import java.util.UUID;

public interface RepositoryInterface<E> {
    List<E> getAll();  //R

    Crime get(UUID uuid);

    void update(E e);  //U

    void delete(E e); //D

    void insert(E e);  //C

    void insertAll(List<E> elements);
}
