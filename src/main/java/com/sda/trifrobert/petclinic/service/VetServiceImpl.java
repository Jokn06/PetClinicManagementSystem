package com.sda.trifrobert.petclinic.service;

import com.sda.trifrobert.petclinic.model.Vet;
import com.sda.trifrobert.petclinic.repository.VetRepository;

import java.util.List;
import java.util.Optional;

public class VetServiceImpl implements VetService {
    private final VetRepository vetRepository;

    public VetServiceImpl(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public void createVet(String firstName, String lastName, String address, String speciality) {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name is invalid !");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name is invalid !");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address is invalid !");
        }
        if (speciality == null || speciality.isBlank()) {
            throw new IllegalArgumentException("Speciality is invalid !");
        }

        vetRepository.createVet(firstName, lastName, address, speciality);


    }

    @Override
    public List<Vet> getAllVets() {
        return vetRepository.getAllVets();
    }

    @Override
    public Optional<Vet> findById(int id) {
        return vetRepository.findById(id);
    }

    @Override
    public void updateVetById(int id, String firstName, String lastName, String address, String speciality) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id is invalid !");
        }
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name is invalid !");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name is invalid !");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address is invalid !");
        }
        if (speciality == null || speciality.isBlank()) {
            throw new IllegalArgumentException("Speciality is invalid !");
        }
        vetRepository.updateVetById(id, firstName, lastName, address, speciality);
    }

}
