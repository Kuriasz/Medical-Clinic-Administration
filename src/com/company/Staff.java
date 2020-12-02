package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

abstract class Staff {
    protected final String employeeCode;
    protected final String firstName;
    protected String lastName;
    protected String birthDate;
    protected String employmentDate;
    protected float salary;

    static ArrayList<Staff> staffArrayList = new ArrayList<>();

    public Staff(String employeeCode, String firstName, String lastName, String birthDate, String employmentDate, float salary) {
        this.employeeCode = employeeCode;
        this.firstName = firstName;
        this.lastName = lastName;
        if (validateDate(birthDate))
            this.birthDate = birthDate;
        if (validateDate(employmentDate))
            this.employmentDate = employmentDate;
        this.salary = salary;
    }

    public boolean validateDate(String strDate) {
        if (!strDate.trim().equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            try {
                Date javaDate = sdf.parse(strDate);
            } catch (ParseException e) {
                System.out.print("Bad date format. Should be dd/mm/yyyy\n");
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "employeeCode='" + employeeCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", employmentDate='" + employmentDate + '\'' +
                ", salary=" + salary +
                '}';
    }
}
