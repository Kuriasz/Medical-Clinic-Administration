package com.company;

public class Internist extends HealthcareStaff{
    public Internist(String employeeCode, String firstName, String lastName, String birthDate, String employmentDate, float salary) {
        super(employeeCode, firstName, lastName, birthDate, employmentDate, salary);
        this.levelOfPrivileges = 1;
        healthcareStaffs.add(this);
    }
}
