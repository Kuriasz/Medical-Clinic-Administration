package com.company;

import java.util.ArrayList;

public class Patient {
    public String name;
    public String surname;
    public String dateOfBirth;

    public ArrayList<String> procedures;
    static ArrayList<Patient> patientsArrayList = new ArrayList<>();

    public Patient(String name, String surname, String dateOfBirth) {
        procedures = new ArrayList<>();
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        patientsArrayList.add(this);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
