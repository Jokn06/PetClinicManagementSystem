package com.sda.trifrobert.petclinic;

import com.sda.trifrobert.petclinic.controller.VetController;
import com.sda.trifrobert.petclinic.repository.VetRepositoryImpl;
import com.sda.trifrobert.petclinic.service.VetServiceImpl;
import com.sda.trifrobert.petclinic.utils.SessionManager;
import com.sda.trifrobert.petclinic.utils.UserOption;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SessionManager.getSessionFactory();
        VetController vetController = new VetController(new VetServiceImpl(new VetRepositoryImpl()));

        UserOption userOption;
        Scanner scanner = new Scanner( System.in);
        do {
           try {
               UserOption.displayAllOptions();
               System.out.println("please select an option: ");
               int numericOption = Integer.parseInt(scanner.nextLine().trim());
               userOption = UserOption.findByNumericOption(numericOption);
           } catch (NumberFormatException e){
               userOption = UserOption.UNKNOWN;
           }
           switch (userOption){
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
                case UNKNOWN:
                    System.err.println("Invalid option selected! ");
                    break;
                case  EXIT:
                    System.out.println("bye!");
                    break;
            }
       }while (userOption != UserOption.EXIT);
     SessionManager.shutDown();
    }
}