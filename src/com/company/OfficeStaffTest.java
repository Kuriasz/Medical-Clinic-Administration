package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OfficeStaffTest {
    Internist i1 = new Internist("I1","Ada3","Beza","11/03/1990","13/1/2015",1.2f);
    Patient p1 = new Patient("Danny", "Wave", "20/05/1998");
    @Test
    public void firstNameAndSurnameTest() {
        Assertions.assertTrue(OfficeStaff.firstNameAndSurname("Adam"));
        Assertions.assertFalse(OfficeStaff.firstNameAndSurname("Adam2"));
    }

    @Test
    public void getGoodDoctorTest(){
        Assertions.assertEquals("Ada3 Beza", OfficeStaff.getGoodDoctor(1, p1));
    }

    @Test
    public void getPatientAgeTest(){
        Assertions.assertEquals(22.03, OfficeStaff.getPatientAge(p1.dateOfBirth));
    }
}
