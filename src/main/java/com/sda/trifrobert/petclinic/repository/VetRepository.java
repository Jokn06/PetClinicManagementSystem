package com.sda.trifrobert.petclinic.repository;

import com.sda.trifrobert.petclinic.model.Vet;

import java.util.Optional;

public interface VetRepository extends BaseRepository<Vet> {
    void createVet(
            String firstName,
            String lastName,
            String address,
            String speciality
    );

    void updateVetById(
            int id,
            String firstName,
            String lastName,
            String address,
            String speciality
    );

}
