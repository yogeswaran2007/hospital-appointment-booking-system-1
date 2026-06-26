package com.vetrihospital.controller;

import com.vetrihospital.entity.Patient;
import com.vetrihospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private PatientRepository patientRepository;

    // Patient Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Patient loginRequest) {

        Optional<Patient> patient =
                patientRepository.findByEmail(loginRequest.getEmail());

        if (patient.isPresent()) {

            if (patient.get().getPassword()
                    .equals(loginRequest.getPassword())) {

                return ResponseEntity.ok(patient.get());

            } else {

                return ResponseEntity.badRequest()
                        .body("Invalid Password");
            }

        }

        return ResponseEntity.badRequest()
                .body("Patient Not Found");
    }

    // Patient Registration
    @PostMapping("/register")
    public ResponseEntity<Patient> register(
            @RequestBody Patient patient) {

        return ResponseEntity.ok(
                patientRepository.save(patient)
        );
    }

}