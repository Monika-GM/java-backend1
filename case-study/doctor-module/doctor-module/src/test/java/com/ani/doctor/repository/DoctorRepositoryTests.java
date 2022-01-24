package com.ani.doctor.repository;

import com.ani.doctor.domain.Doctor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DoctorRepositoryTests {
    @Autowired
    private DoctorRepository repository;

    @DisplayName("Doctor Repo : Creating Doctor")
    @Test
    public void testCreateDoctor() {

        var doctor = new Doctor();
        doctor.setId(10L);
        doctor.setName("Teju");
        doctor.setSpiel("neurologist");
        doctor.setHsNm("Megan");
        doctor.setHsLoc("shimoga");
        doctor.setVisit(true);


        repository.save(doctor);
    }
}

