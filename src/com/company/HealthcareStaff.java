package com.company;

import java.util.ArrayList;

abstract class HealthcareStaff extends  Staff{
    public int levelOfPrivileges;
    static ArrayList<Patient> allignedPatients;
    static ArrayList<HealthcareStaff> healthcareStaffs = new ArrayList<>();

    public HealthcareStaff(String employeeCode, String firstName, String lastName, String birthDate, String employmentDate, float salary) {
        super(employeeCode, firstName, lastName, birthDate, employmentDate, salary);
        staffArrayList.add(this);
        allignedPatients = new ArrayList<>();
    }

    public void allignPatient (Patient patient) {allignedPatients.add(patient);}

    @Override
    public String toString() {
        return "HealthcareStaff{" +
                "levelOfPrivileges=" + levelOfPrivileges +
                ", employeeCode='" + employeeCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", employmentDate='" + employmentDate + '\'' +
                ", salary=" + salary +
                '}';
    }
}
