package com.ani.doctor.controller;


import com.ani.doctor.domain.Doctor;
import com.ani.doctor.dto.DoctorResponse;
import com.ani.doctor.dto.DoctorDto;

import com.ani.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/doctor")
@RestController
public class DoctorController {
    @Autowired
    private DoctorService service;


    @PostMapping    // Post -> http://localhost:8080/doctor/
    public ResponseEntity<DoctorResponse<DoctorDto>> createDoctor(@RequestBody DoctorDto dto){

        var svObj = service.createDoctor(dto);
        var response = new DoctorResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Doctor saved successfully");
        response.setBody(svObj);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")    // Put -> http://localhost:8080/doctor/update/
    public ResponseEntity<DoctorResponse<DoctorDto>> updateDocInfo(@RequestBody DoctorDto dto){

        var svObj = service.updateDocInfo(dto);
        var response = new DoctorResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Doctor updated successfully");
        response.setBody(svObj);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")  // Delete -> http://localhost:8080/doctor/4
    public ResponseEntity<DoctorResponse<DoctorDto>> deleteDocInfo(@PathVariable ("id") Long id){

        service.deleteDoctor(id);
        var response = new DoctorResponse<DoctorDto>();
        response.setStatus("success");
        response.setMessage("Doctor deleted successfully");
        return ResponseEntity.ok(response);
    }
    @GetMapping("/search/{spiel}")    // Get -> http://localhost:8080/doctor/search/spiel/
    public ResponseEntity<DoctorResponse<List<Doctor>>> searchOfDoctorRegistration(@PathVariable("spiel") String spiel) {
        service.findAll(spiel);
        var response = new DoctorResponse<List<Doctor>>();
        response.setMessage("Doctor Specialization");
        response.setStatus("success");


        return ResponseEntity.ok(response);
    }
    @GetMapping("/{spiel}")   // Get -> http://localhost:8080/doctor/spiel/
    public ResponseEntity<DoctorResponse<List<DoctorDto>>> findVisitingDoctorBySpiel(@PathVariable String spiel){

        var svObj = service.findVisitingDoctorBySpiel(spiel );
        var response = new DoctorResponse<List<DoctorDto>>();
        response.setStatus("success");
        response.setMessage("Doctors fetched successfully");
        response.setBody(svObj);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/list/{name}")  // Get -> http://localhost:8080/doctor/name/
    public ResponseEntity<DoctorResponse<List<Doctor>>> listOfDoctorRegistration(@PathVariable("name") String name) {
        service.findAll(name);
        var response = new DoctorResponse<List<Doctor>>();
        response.setMessage("list registration doctor");
        response.setStatus("success");

        return ResponseEntity.ok(response);
    }
}



