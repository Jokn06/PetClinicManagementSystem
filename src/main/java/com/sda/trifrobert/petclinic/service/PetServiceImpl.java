package com.sda.trifrobert.petclinic.service;

import com.sda.trifrobert.petclinic.repository.PetRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PetServiceImpl implements PetService {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    @Override
    public void createPet(String race, Date birthdate, boolean isVaccinated, String ownerName) {
        if (race == null || race.isBlank()) {
            throw new IllegalArgumentException("Race is INVALID! ");
        }
        if (birthdate == null) {
            throw new IllegalArgumentException("Date is INVALID! ");
        }
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("owner name is INVALID! ");
        }
        petRepository.createPet(race, birthdate, isVaccinated, ownerName);
    }

    @Override
    public void importPets() throws IOException {
        Path filePath = Paths.get("C:\\Users\\Jo\\Documents\\Git\\PetClinicManagementSystem\\src\\main\\resources\\Data\\Pets.txt");
        Files.lines(filePath)
                .skip(1)
                .map(line -> line.split("//|"))
                .forEach(lineElements -> {
                    if (lineElements.length == 4) {
                        String race = lineElements[0];
                        Date date = Date.valueOf(LocalDate.parse(lineElements[1], FORMATTER));
                        boolean isVaccinated = Boolean.parseBoolean(lineElements[2]);
                        String ownerName = lineElements[3];
                        createPet(race, date, isVaccinated, ownerName);
                    }
                });
    }
}

