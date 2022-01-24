package com.ani.doctor.service;


import com.ani.doctor.domain.Doctor;
import com.ani.doctor.repository.DoctorRepository;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@SpringBootTest
public class DoctorServiceTests {

//    @Mock
//    private DoctorRepository repository;
    @Autowired
    private DoctorServiceImpl service;

    //    @MockBean -> they will create dependency tree
//    @Mock ->  they will create dependency tree
//    @InjectMocks
//    private DoctorService service;
    // service class is calling method inside repository ?
    // how to check this method has happened or not ?
    // for that you have verify methods from Mockito.s

    @Test
    public void testDeleteDoctor(){


        var doctor1 = new Doctor();
        doctor1.setId(1000L);
        doctor1.setName("shree");
        doctor1.setSpiel("neurologist");
        doctor1.setHsNm("Megan");
        doctor1.setHsLoc("durga");
        doctor1.setVisit(true);


        var doctor2 = new Doctor();
        doctor2.setId(1000L);
        doctor2.setName("teju");
        doctor2.setSpiel("neurologist");
        doctor2.setHsNm("Megan");
        doctor2.setHsLoc("durga");
        doctor2.setVisit(true);


    }
}
