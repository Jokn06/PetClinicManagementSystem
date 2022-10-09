package com.sda.trifrobert.petclinic.repository;

import com.sda.trifrobert.petclinic.model.Vet;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {

    List<T> getAll();

    Optional<T> findbyId(int id);

    void create(T entity);

    void updateById(int id, T entity);

    void deleteById(int id);

}
