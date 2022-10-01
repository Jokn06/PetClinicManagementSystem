package com.sda.trifrobert.petclinic.repository;

import com.sda.trifrobert.petclinic.model.Vet;

import java.util.List;

public interface VetRepository {
    void createVet(
            String firstName,
            String lastName,
            String address,
            String speciality
    );

   List<Vet> getAllVets();


}
