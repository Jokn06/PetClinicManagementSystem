package com.sda.trifrobert.petclinic;

import com.sda.trifrobert.petclinic.utils.SessionManager;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {

        SessionManager.getSessionFactory();
        SessionManager.shutDown();


    }
}