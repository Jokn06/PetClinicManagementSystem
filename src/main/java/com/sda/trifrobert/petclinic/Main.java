package com.sda.trifrobert.petclinic;

import com.sda.trifrobert.petclinic.controller.VetController;
import com.sda.trifrobert.petclinic.repository.VetRepositoryImpl;
import com.sda.trifrobert.petclinic.service.VetServiceImpl;
import com.sda.trifrobert.petclinic.utils.SessionManager;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {

        VetController vetController = new VetController(new VetServiceImpl(new VetRepositoryImpl()));
        vetController.createVet();
    }
}