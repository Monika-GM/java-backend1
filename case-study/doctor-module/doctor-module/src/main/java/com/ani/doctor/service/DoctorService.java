package com.ani.doctor.service;


import com.ani.doctor.domain.Doctor;
import com.ani.doctor.dto.DoctorDto;

import java.util.List;

public interface DoctorService {

    public DoctorDto createDoctor(DoctorDto dto);

    public DoctorDto updateDocInfo(DoctorDto doctor) ;

    public void deleteDoctor( Long id);

    public List<DoctorDto> findAll(String spiel);

    public List<DoctorDto> findVisitingDoctorBySpiel(String spiel);

    public List<DoctorDto> listAll(String name);



}
