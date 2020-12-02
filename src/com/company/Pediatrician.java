package com.company;

public class Pediatrician extends HealthcareStaff{
    public Pediatrician(String employeeCode, String firstName, String lastName, String birthDate, String employmentDate, float salary) {
        super(employeeCode, firstName, lastName, birthDate, employmentDate, salary);
        this.levelOfPrivileges = 2;
        healthcareStaffs.add(this);
    }
}
