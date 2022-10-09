package com.sda.trifrobert.petclinic.repository;

import com.sda.trifrobert.petclinic.model.Consult;
import com.sda.trifrobert.petclinic.model.Pet;
import com.sda.trifrobert.petclinic.model.Vet;

import java.sql.Date;

public interface ConsultRepository extends BaseRepository<Consult> {

    void createConsult(Vet vet,
                       Pet pet,
                       Date date,
                       String description);

}
