package com.sda.trifrobert.petclinic.controller;

import com.sda.trifrobert.petclinic.model.Vet;
import com.sda.trifrobert.petclinic.service.VetService;


import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class VetController {

    private final VetService vetService;
    private final Scanner scanner = new Scanner(System.in);

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public void createVet() {
        System.out.println("Please insert vet first name: ");
        String firstName = scanner.nextLine();
        System.out.println("PLease insert vet last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Please insert vet address: ");
        String address = scanner.nextLine();
        System.out.println("Please insert vet speciality: ");
        String speciality = scanner.nextLine();


        try {
            vetService.createVet(firstName, lastName, address, speciality);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid data: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Internal server error ! " + e.getMessage());
        }

    }

    public void showAllVets() {
        System.out.println("Vet List: ");
        for (Vet vet : vetService.getAllVets()) {
            System.out.println(vet.getId() + " " + vet.getFirstName() + " " + vet.getLastName());
        }
    }

    public void showVetById() {
        try {
            System.out.println("Please insert an id: ");
            int chooseId = Integer.parseInt(scanner.nextLine().trim());
            Optional<Vet> optionalVet = vetService.findById(chooseId);
            if (optionalVet.isPresent()) {
                System.out.println(optionalVet.get());
            } else {
                System.out.println("Vet not found! ");
            }

        } catch (NumberFormatException e) {
            System.err.println("Invalid Id Format! ");
        } catch (Exception e) {
            System.out.println("Internal server error ! ");
        }
    }

    public void updateVetById() {
        try {
            System.out.println("Please insert the id: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Please insert vet first name: ");
            String firstName = scanner.nextLine();
            System.out.println("PLease insert vet last name: ");
            String lastName = scanner.nextLine();
            System.out.println("Please insert vet address: ");
            String address = scanner.nextLine();
            System.out.println("Please insert vet speciality: ");
            String speciality = scanner.nextLine();

            vetService.updateVetById(id, firstName, lastName, address, speciality);
        } catch (NumberFormatException e) {
            System.err.println("Invalid Id format !");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Internal server error !");
        }
    }

    public void deleteVetById() {
        try {
            System.out.println("Please insert the id: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            vetService.deleteVetById(id);
        } catch (NumberFormatException e) {
            System.err.println("Invalid Id format !");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Internal server error !");
        }
    }

    public void importVets() {
        try {
            System.out.println("Import vets started! ");
            vetService.importVets();
            System.out.println("Import vets finished! ");
        } catch (IOException e) {
            System.out.println("Import vets failed!");
        }
    }

}