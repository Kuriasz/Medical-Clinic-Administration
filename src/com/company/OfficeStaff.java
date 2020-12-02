package com.company;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class OfficeStaff extends Staff {
    Scanner scanner = new Scanner(System.in);
    String[] procedures = {"Injection", "Weight measurement", "Pressure measurement", "Blood collection", "General examination", "USG examination", "Prescription"};

    public OfficeStaff(String employeeCode, String firstName, String lastName, String birthDate, String employmentDate, float salary) {
        super(employeeCode, firstName, lastName, birthDate, employmentDate, salary);
        staffArrayList.add(this);
    }

    @Override
    public String toString() {
        return "OfficeStaff{" +
                "employeeCode='" + employeeCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", employmentDate='" + employmentDate + '\'' +
                ", salary=" + salary +
                '}';
    }

    public void showMenu() {
        printMenu();
        int choice;
        try {
            do {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice < 1 || choice > 5) {
                    System.out.println("Bad choice, exiting program");
                    choice = 5;
                }
                switch (choice) {
                    case 1 -> {
                        registerPatient();
                        printMenu();
                    }
                    case 2 -> {
                        printWholeEmployeeSalary();
                        printMenu();
                    }
                    case 3 -> {
                        printWholeEmployeeTimeOfEmployment();
                        printMenu();
                    }
                    case 4 -> {
                        printEmployeeData();
                        printMenu();
                    }
                }
            } while (choice != 5);
        } catch (InputMismatchException e) {
            System.out.print("Use number 1-5");
        }
    }

    private void printEmployeeData() {
        System.out.print("Employee code: ");
        String employeeCode = scanner.nextLine();
        boolean employeExist = false;
        try {
            for (Staff staff : Staff.staffArrayList) {
                if (employeeCode.equals(staff.employeeCode)) {
                    employeExist = true;
                    System.out.println(staff);
                }
            }
            if (!employeExist)
                throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.print("Employee doesn't exist!\n");
        }
    }

    private void printWholeEmployeeTimeOfEmployment() {
        System.out.print("Employee code: ");
        String employeeCode = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        boolean employeExist = false;
        try {
            for (int i = 0; i < Staff.staffArrayList.size(); i++) {
                if (employeeCode.equals(Staff.staffArrayList.get(i).employeeCode)) {
                    employeExist = true;
                    Date d = null;
                    try {
                        d = sdf.parse(Staff.staffArrayList.get(i).employmentDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    LocalDate employmentDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    float years = Period.between(employmentDate, LocalDate.now()).getYears();
                    float days = Period.between(employmentDate, LocalDate.now()).getDays();
                    days = years * 365 + days;
                    System.out.printf("Full time of employment: %.2f years\n", days / 365);
                    break;
                }
            }
            if (!employeExist)
                throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.print("Employee doesn't exist!\n");
        }
    }

    private void printWholeEmployeeSalary() {
        System.out.print("Employee code: ");
        String employeeCode = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        boolean employeExist = false;
        try {
            for (int i = 0; i < Staff.staffArrayList.size(); i++) {
                if (employeeCode.equals(Staff.staffArrayList.get(i).employeeCode)) {
                    employeExist = true;
                    Date d = null;
                    try {
                        d = sdf.parse(Staff.staffArrayList.get(i).employmentDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    LocalDate employmentDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    int months = Period.between(employmentDate, LocalDate.now()).getMonths();
                    int years = Period.between(employmentDate, LocalDate.now()).getYears();
                    months = years * 12 + months;
                    float fullSalary = Staff.staffArrayList.get(i).salary * months;
                    System.out.printf("Full salary: %.2f pln\n", fullSalary);
                    break;
                }
            }
            if (!employeExist)
                throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.print("Employee doesn't exist!\n");
        }
    }

    public static boolean firstNameAndSurname(String firstName) {
        return firstName.matches("[A-Z][a-z]*");
    }

    private void registerPatient() {
        System.out.print("\nName: ");
        String name = scanner.nextLine();
        System.out.print("\nSurname: ");
        String surname = scanner.nextLine();
        System.out.print("\nDate of birth: ");
        String dateOfBirth = scanner.nextLine();
        try {
            if (!validateDate(dateOfBirth) || !firstNameAndSurname(name) || !firstNameAndSurname(surname)) {
                throw new InputMismatchException();
            }
            Patient patient = new Patient(name, surname, dateOfBirth);
            boolean doctorFlag = false;
            int choice;
            System.out.print("\nNumber of procedures: ");
            int numberOfProcedures = scanner.nextInt();
            try {
                do {
                    printMenuProcedures();
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > 7)
                        throw new InputMismatchException();
                    switch (choice) {
                        case 1 -> patient.procedures.add(procedures[0]);
                        case 2 -> patient.procedures.add(procedures[1]);
                        case 3 -> patient.procedures.add(procedures[2]);
                        case 4 -> patient.procedures.add(procedures[3]);
                        case 5 -> {
                            doctorFlag = true;
                            patient.procedures.add(procedures[4]);
                        }
                        case 6 -> {
                            doctorFlag = true;
                            patient.procedures.add(procedures[5]);
                        }
                        case 7 -> {
                            doctorFlag = true;
                            patient.procedures.add(procedures[6]);
                        }
                    }
                    numberOfProcedures--;
                } while (numberOfProcedures > 0);

                Logger logger = Logger.getLogger(OfficeStaff.class.getName());
                try {
                    FileHandler fh = new FileHandler("D:/MyLogFile.log");
                    logger.addHandler(fh);
                    SimpleFormatter formatter = new SimpleFormatter();
                    fh.setFormatter(formatter);

                    logger.info("Name: " + name + "\nSurname: " + surname + "\nDate of birth: " + dateOfBirth + "\n" + patient.procedures);

                    if (!doctorFlag && getPatientAge(dateOfBirth) > 18f) {
                        logger.info("Nurse: " + getGoodDoctor(0, patient) + "\nPatient: " + name + " " + surname + "\nProcedures:" + patient.procedures);
                    } else if (getPatientAge(dateOfBirth) < 18f) {
                        logger.info("Internist: " + getGoodDoctor(1, patient) + "\nPatient: " + name + " " + surname + "\nProcedures:" + patient.procedures);
                    } else {
                        logger.info("Pediatrician: " + getGoodDoctor(2, patient) + "\nPatient: " + name + " " + surname + "\nProcedures:" + patient.procedures);
                    }

                } catch (SecurityException | IOException e) {
                    e.printStackTrace();
                }
            } catch (InputMismatchException e) {
                System.out.print("Bad menu choice.\n");
            }
        } catch (InputMismatchException e) {
            System.out.print("Name, surname of date bad format.\n");
        }
    }

    public static String getGoodDoctor(int levelOfPrivileges, Patient patient) {
        String doctorName = null;
        for (HealthcareStaff staff : HealthcareStaff.healthcareStaffs) {
            if (staff.levelOfPrivileges == levelOfPrivileges) {
                staff.allignPatient(patient);
                doctorName = staff.firstName + " " + staff.lastName;
                break;
            }
        }
        return doctorName;
    }

    public static float getPatientAge(String dateOfBirth) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = null;
        try {
            d = sdf.parse(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LocalDate employmentDate = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        float years = Period.between(employmentDate, LocalDate.now()).getYears();
        float days = Period.between(employmentDate, LocalDate.now()).getDays();
        days = years * 365 + days;
        return (days / 365);
    }

    private void printMenu() {
        System.out.print("1. Register new patient\n2. Print employee whole salary\n3. Print employee time of employment\n" +
                "4. Print employee data\n5. Exit\n");
    }

    private void printMenuProcedures() {
        System.out.print("1. Injection\n2. Weight measurement\n3. Pressure measurement\n4. Blood collection\n5. General examination\n" +
                "6. USG examination\n7. Prescription\n");
    }
}