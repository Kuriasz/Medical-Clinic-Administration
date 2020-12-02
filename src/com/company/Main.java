package com.company;

public class Main {

    public static void main(String[] args) {
        OfficeStaff of1 = new OfficeStaff("OF1","Adam","Bezi","11/01/1989","13/1/2017",2000f);
        Nurse n1 = new Nurse("N1","Ada","Beza","30/01/1967","23/5/2015",2400.5f);
        Internist i1 = new Internist("I1","Krzysztof","Miś","20/11/1980","28/9/2014",14000.29f);
        Pediatrician p1 = new Pediatrician("P1","Nina","Bukaś","1/1/1950","13/1/1998",3200.2f);

        of1.showMenu();
    }
}
