package com.sda.trifrobert.petclinic.controller;

import com.sda.trifrobert.petclinic.service.PetService;

import java.io.IOException;
import java.sql.Date;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PetController {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    private final PetService petService;

    private final Scanner scanner = new Scanner(System.in);


    public PetController(PetService petService) {
        this.petService = petService;
    }

    public void createPet() {
        try {
            System.out.println("Please insert vet race: ");
            String race = scanner.nextLine();
            System.out.println("PLease insert the birth date of this pet in this format: MM_dd-yyyy");
            String dateString = scanner.nextLine();
            Date date = Date.valueOf(LocalDate.parse(dateString, FORMATTER));
            System.out.println("Please insert TRUE if the pet is vaccinated or FALSE if the pet is not vaccinated : ");
            boolean isVaccinated = Boolean.parseBoolean(scanner.nextLine());
            System.out.println("Please insert the owner name for this pet: ");
            String ownerName = scanner.nextLine();

            petService.createPet(race, date, isVaccinated, ownerName);
        } catch (IllegalArgumentException | DateTimeException e) {
            System.err.println("Invalid data: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Internal server error ! " + e.getMessage());
        }
    }

    public void importPets() {
        try {
            System.out.println("Import pets started");
            petService.importPets();
            System.out.println("Import pets!");
        } catch (IOException e) {
            System.out.println("Invalid pets failed!");
        }
    }
}

