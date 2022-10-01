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
           UserOption.displayAllOptions();
            System.out.println("please select an option: ");
            int numericOption = scanner.nextInt();
            userOption = UserOption.findByNumericOption(numericOption);
            switch (userOption){
                case ADD_VET:
                    vetController.createVet();
                    break;
                case VIEW_ALL_VETS:
                    System.out.println("Not implemented");
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