package com.sda.trifrobert.petclinic.repository;

import com.sda.trifrobert.petclinic.model.Pet;

import java.sql.Date;
import java.util.List;


public interface PetRepository extends BaseRepository<Pet> {

    void createPet(
            String race,
            Date birthdate,
            boolean isVaccinated,
            String ownerName
    );

    void updatePet(
            int id,
            String race,
            Date birthdate,
            boolean isVaccinated,
            String ownerName
    );
}
