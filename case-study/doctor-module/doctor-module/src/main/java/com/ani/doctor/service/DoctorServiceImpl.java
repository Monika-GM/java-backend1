package com.ani.doctor.service;

import com.ani.doctor.domain.Doctor;
import com.ani.doctor.dto.DoctorDto;
import com.ani.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository repository;

    @Override
    public DoctorDto createDoctor(DoctorDto doctor) {

        var doc = new Doctor();
        doc.setId(doctor.getId());
        doc.setName(doctor.getName());
        doc.setSpiel(doc.getSpiel());
        doc.setHsNm(doctor.getHsNm());
        doc.setHsLoc(doctor.getHsLoc());
        doc.setVisit(doctor.isVisit());
        repository.save(doc);
        return doctor;
    }

    @Override
    public DoctorDto updateDocInfo(DoctorDto doctor) {
        Doctor doc = repository.findById(doctor.getId()).orElse(null);
        var doc1 = new Doctor();
        doc1.setId(doctor.getId());
        doc1.setName(doctor.getName());
        doc1.setSpiel(doctor.getSpiel());
        doc1.setHsNm(doctor.getHsNm());
        doc1.setHsLoc(doctor.getHsLoc());
        doc1.setVisit(doctor.isVisit());
        repository.save(doc1);
        return doctor;
    }

    @Override
    public void deleteDoctor(Long id) {
        repository.deleteById(id);


    }

    @Override
    public List<DoctorDto> findAll(String spiel) {
        List<Doctor> doctors = repository.findAll();
        List<DoctorDto> dtos = new ArrayList<>();
        for (int i = 0; i < doctors.size(); i++) {

            Doctor doctor = doctors.get(i); // you are getting ith element

            DoctorDto dto = new DoctorDto(
                    doctor.getId(),
                    doctor.getName(),
                    doctor.getSpiel(),
                    doctor.getHsNm(),
                    doctor.getHsLoc(),
                    doctor.getVisit()
            );
            dtos.add(dto);
        }
        return dtos;


    }

    @Override
    public List<DoctorDto> findVisitingDoctorBySpiel(String spiel) {

        List<Doctor> dto = repository.findAll();
        List<DoctorDto> dto1 = dto.stream()
                .filter(n-> n.getVisit()==false   && n.getSpiel().equals(spiel))
                .map (doc -> new DoctorDto(
                        doc.getId(),
                        doc.getName(),
                        doc.getSpiel(),
                        doc.getHsNm(),
                        doc.getHsLoc(),
                        doc.getVisit()
                ))
                .collect(Collectors.toList());
        return dto1;
    }
    @Override
    public List<DoctorDto> listAll(String name) {
        List<Doctor> doctors = repository.findAll();
        List<DoctorDto> dtos = new ArrayList<>();
        for (int i = 0; i < doctors.size(); i++) {

            Doctor doctor = doctors.get(i); // you are getting ith element

            DoctorDto dto = new DoctorDto(
                    doctor.getId(),
                    doctor.getName(),
                    doctor.getSpiel(),
                    doctor.getHsNm(),
                    doctor.getHsLoc(),
                    doctor.getVisit()
            );
            dtos.add(dto);
        }
        return dtos;


    }






}

