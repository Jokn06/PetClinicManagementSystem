package com.sda.trifrobert.petclinic;

import com.sda.trifrobert.petclinic.controller.ConsultController;
import com.sda.trifrobert.petclinic.controller.PetController;
import com.sda.trifrobert.petclinic.controller.VetController;
import com.sda.trifrobert.petclinic.repository.ConsultRepositoryImpl;
import com.sda.trifrobert.petclinic.repository.PetRepositoryImpl;
import com.sda.trifrobert.petclinic.repository.VetRepositoryImpl;
import com.sda.trifrobert.petclinic.service.ConsultServiceImpl;
import com.sda.trifrobert.petclinic.service.PetServiceImpl;
import com.sda.trifrobert.petclinic.service.VetServiceImpl;
import com.sda.trifrobert.petclinic.utils.SessionManager;
import com.sda.trifrobert.petclinic.utils.UserOption;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SessionManager.getSessionFactory();
        VetController vetController = new VetController(new VetServiceImpl(new VetRepositoryImpl()));
        PetController petController = new PetController(new PetServiceImpl(new PetRepositoryImpl()));
        ConsultController consultController = new ConsultController(new ConsultServiceImpl(
                new VetRepositoryImpl(),
                new PetRepositoryImpl(),
                new ConsultRepositoryImpl()
        ));

        UserOption userOption;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                UserOption.displayAllOptions();
                System.out.println("please select an option: ");
                int numericOption = Integer.parseInt(scanner.nextLine().trim());
                userOption = UserOption.findByNumericOption(numericOption);
            } catch (NumberFormatException e) {
                userOption = UserOption.UNKNOWN;
            }
            switch (userOption) {
                case ADD_VET:
                    vetController.createVet();
                    break;
                case VIEW_ALL_VETS:
                    vetController.showAllVets();
                    break;
                case VIEW_ALL_BY_ID:
                    vetController.showVetById();
                    break;
                case UPDATE_VET_BY_ID:
                    vetController.updateVetById();
                    break;
                case DELETE_VET_BY_ID:
                    vetController.deleteVetById();
                    break;
                case ADD_PET:
                    petController.createPet();
                    break;
                case IMPORT_VETS:
                    vetController.importVets();
                    break;
                case IMPORT_PETS:
                    petController.importPets();
                    break;
                case CREATE_CONSULT:
                    consultController.createConsult();
                    break;
                case UNKNOWN:
                    System.err.println("Invalid option selected! ");
                    break;
                case EXIT:
                    System.out.println("bye!");
                    break;
            }
        } while (userOption != UserOption.EXIT);

        SessionManager.shutDown();
    }
}