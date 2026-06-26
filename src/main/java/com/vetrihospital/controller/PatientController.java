package com.vetrihospital.controller;

import com.vetrihospital.entity.Patient;
import com.vetrihospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    // Register Patient
    @PostMapping("/register")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {

        Patient savedPatient = patientRepository.save(patient);
        return ResponseEntity.ok(savedPatient);
    }

    // Get All Patients
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientRepository.findAll());
    }

    // Get Patient By ID
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {

        Optional<Patient> patient = patientRepository.findById(id);

        return patient.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update Patient
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id,
                                                 @RequestBody Patient updatedPatient) {

        Optional<Patient> patientOptional = patientRepository.findById(id);

        if (patientOptional.isPresent()) {

            Patient patient = patientOptional.get();

            patient.setFullName(updatedPatient.getFullName());
            patient.setEmail(updatedPatient.getEmail());
            patient.setPhone(updatedPatient.getPhone());
            patient.setAge(updatedPatient.getAge());
            patient.setGender(updatedPatient.getGender());
            patient.setAddress(updatedPatient.getAddress());

            return ResponseEntity.ok(patientRepository.save(patient));
        }

        return ResponseEntity.notFound().build();
    }

    // Delete Patient
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {

        patientRepository.deleteById(id);

        return ResponseEntity.ok("Patient Deleted Successfully");
    }
}