package com.sda.trifrobert.petclinic.service;

import com.sda.trifrobert.petclinic.model.Pet;
import com.sda.trifrobert.petclinic.model.Vet;
import com.sda.trifrobert.petclinic.repository.ConsultRepository;
import com.sda.trifrobert.petclinic.repository.PetRepository;
import com.sda.trifrobert.petclinic.repository.VetRepository;

import java.sql.Date;
import java.util.Optional;

public class ConsultServiceImpl implements ConsultService {

    private final VetRepository vetRepository;
    private final PetRepository petRepository;
    private final ConsultRepository consultRepository;

    public ConsultServiceImpl(VetRepository vetRepository, PetRepository petRepository, ConsultRepository consultRepository) {
        this.vetRepository = vetRepository;
        this.petRepository = petRepository;
        this.consultRepository = consultRepository;
    }

    @Override
    public void createConsult(int vetId, int petId, Date date, String description) {
        Optional<Vet> vetOptional = vetRepository.findbyId(vetId);
        if (vetOptional.isPresent()) {
            Optional<Pet> petOptional = petRepository.findbyId(petId);
            if (petOptional.isPresent()) {
                consultRepository.createConsult(vetOptional.get(), petOptional.get(), date, description);
            } else {
                throw new IllegalArgumentException("Invalid pet ID!");
            }
        } else {
            throw new IllegalArgumentException("Invalid vet ID! ");
        }
    }
}
