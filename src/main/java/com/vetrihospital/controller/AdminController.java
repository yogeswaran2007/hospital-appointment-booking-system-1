package com.vetrihospital.controller;

import com.vetrihospital.entity.Doctor;
import com.vetrihospital.entity.Patient;
import com.vetrihospital.entity.Appointment;
import com.vetrihospital.repository.DoctorRepository;
import com.vetrihospital.repository.PatientRepository;
import com.vetrihospital.repository.AppointmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Dashboard Statistics
    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, Object>> dashboard() {

        Map<String, Object> dashboard = new HashMap<>();

        dashboard.put("totalPatients", patientRepository.count());
        dashboard.put("totalDoctors", doctorRepository.count());
        dashboard.put("totalAppointments", appointmentRepository.count());

        return ResponseEntity.ok(dashboard);
    }

    // View All Patients
    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getPatients() {
        return ResponseEntity.ok(patientRepository.findAll());
    }

    // View All Doctors
    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getDoctors() {
        return ResponseEntity.ok(doctorRepository.findAll());
    }

    // View All Appointments
    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAppointments() {
        return ResponseEntity.ok(appointmentRepository.findAll());
    }

}