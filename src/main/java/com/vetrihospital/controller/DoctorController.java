package com.vetrihospital.controller;

import com.vetrihospital.entity.Doctor;
import com.vetrihospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    // Add Doctor
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorRepository.save(doctor);
        return ResponseEntity.ok(savedDoctor);
    }

    // Get All Doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorRepository.findAll());
    }

    // Get Doctor By ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {

        Optional<Doctor> doctor = doctorRepository.findById(id);

        return doctor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update Doctor
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id,
                                               @RequestBody Doctor updatedDoctor) {

        Optional<Doctor> doctorOptional = doctorRepository.findById(id);

        if (doctorOptional.isPresent()) {

            Doctor doctor = doctorOptional.get();

            doctor.setDoctorName(updatedDoctor.getDoctorName());
            doctor.setDepartment(updatedDoctor.getDepartment());
            doctor.setSpecialization(updatedDoctor.getSpecialization());
            doctor.setQualification(updatedDoctor.getQualification());
            doctor.setExperience(updatedDoctor.getExperience());
            doctor.setPhone(updatedDoctor.getPhone());
            doctor.setEmail(updatedDoctor.getEmail());
            doctor.setAvailableDays(updatedDoctor.getAvailableDays());
            doctor.setAvailableTime(updatedDoctor.getAvailableTime());

            return ResponseEntity.ok(doctorRepository.save(doctor));
        }

        return ResponseEntity.notFound().build();
    }

    // Delete Doctor
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {

        doctorRepository.deleteById(id);

        return ResponseEntity.ok("Doctor Deleted Successfully");
    }

    // Search Doctors By Department
    @GetMapping("/department/{department}")
    public ResponseEntity<List<Doctor>> getDoctorsByDepartment(
            @PathVariable String department) {

        return ResponseEntity.ok(
                doctorRepository.findByDepartment(department)
        );
    }

}