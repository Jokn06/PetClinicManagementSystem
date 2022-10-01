package com.sda.trifrobert.petclinic.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Vet {
    @Id
    @Column(name = "id")
    private int id;
    @Column (name = "first_name")
    private String firstName;
    @Column( name = "last name")
    private  String lastName;
    @Column( name = "address")
    private String address;
    @Column( name = "speciality")
    private  String speciality;

    @OneToMany (mappedBy = "vet")
    private List<Consult> consults;

    public Vet(){
    }

    public Vet(int id, String firstName, String lastName, String address, String specialityl) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.speciality = specialityl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialityl() {
        return speciality;
    }

    public void setSpecialityl(String specialityl) {
        this.speciality = specialityl;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<Consult> getConsults() {
        return consults;
    }

    public void setConsults(List<Consult> consults) {
        this.consults = consults;
    }

    @Override
    public String toString() {
        return "Vet{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", specialityl='" + speciality + '\'' +
                '}';
    }
}
