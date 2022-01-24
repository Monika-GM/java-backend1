package com.ani.doctor.controller;

import com.ani.doctor.domain.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DoctorControllerTests {
    @Autowired
    private TestRestTemplate template;
    @LocalServerPort
    private int port;
    @DisplayName("Get - Doctor - Checking Object Is non null")
    @Test
    public void testGetMethod(){

        String url = "http://"+"localhost"+":"+port+"/doctor";
        Doctor doctor = template.getForObject(url,Doctor.class);
        Assertions.assertNotNull(doctor);
    }

    @DisplayName("Put - Doctor - deleting a  doctor")
    @Test
    public void testDeleteMethod(){
        String url = "http://" + "localhost"+":"+port+"/doctor";
        template.delete(url);
    }


}