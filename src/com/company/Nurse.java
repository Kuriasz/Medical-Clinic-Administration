package com.company;

public class Nurse extends HealthcareStaff{
    public Nurse(String employeeCode, String firstName, String lastName, String birthDate, String employmentDate, float salary) {
        super(employeeCode, firstName, lastName, birthDate, employmentDate, salary);
        this.levelOfPrivileges = 0;
        healthcareStaffs.add(this);
    }
}
