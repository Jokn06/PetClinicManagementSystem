package com.sda.trifrobert.petclinic.utils;

public enum UserOption {
    ADD_VET(1, "Add a new Vet "),
    VIEW_ALL_VETS(2, "View all vets"),
    VIEW_ALL_BY_ID(3,"Find by id"),
    UPDATE_VET_BY_ID(4, "updated vet by id"),
    DELETE_VET_BY_ID(5,"Delete vet by id!"),
    ADD_PET(6, "Add a new Pet! "),
    IMPORT_VETS(7,"Import Vets"),
    IMPORT_PETS(8, "Import Pets"),
    CREATE_CONSULT(9,"Create Consult"),
    EXIT(99, "Exit! "),
    UNKNOWN (9999,"invalid option selected!");

    private final int numericOption;
    private final String displayValue;

    UserOption(int numericOption, String displayValue) {
        this.numericOption = numericOption;
        this.displayValue = displayValue;
    }

    public static void displayAllOptions(){
        System.out.println("");
        for (UserOption value : values()) {
             if(value !=UNKNOWN){
                 System.out.println(value.numericOption + "->" + value.displayValue);
             }
        }

    }

     public static UserOption findByNumericOption(int numericOption){
         for ( UserOption value : UserOption.values()){
             if(numericOption == value.getNumericOption()){
                 return value;
             }
         }
         return UNKNOWN;
     }
    public int getNumericOption() {
        return numericOption;
    }

    public String getDisplayValue() {
        return displayValue;
    }



}
