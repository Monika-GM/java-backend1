package com.ani.doctor.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class DoctorTests {


    @DisplayName("Domain : Checking Object Creation")
    @Test
//    void testObjectCreation() {
//        var doctor = new Doctor();
//        Assertions.assertNotNull(doctor);
//    }

//    @DisplayName("Domain : Checking getters and setters")
//    @Test
    void testObjectGettersSetters() {
        var doc = new Doctor();
        doc.setId(123L);
        doc.setName("shree");
        doc.setSpiel("neurologist");
        doc.setHsNm("Megan");
        doc.setHsLoc("durga");
        doc.setVisit(true);


        Assertions.assertEquals(123L, doc.getId());
        Assertions.assertEquals("shree", doc.getName());
        Assertions.assertEquals("neurologist", doc.getSpiel());
        Assertions.assertEquals("Megan", doc.getHsNm());
        Assertions.assertEquals("durga", doc.getHsLoc());
        Assertions.assertEquals(true, doc.getVisit());

    }

}

