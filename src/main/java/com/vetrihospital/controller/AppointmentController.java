package com.vetrihospital.controller;

import com.vetrihospital.entity.Appointment;
import com.vetrihospital.service.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Book Appointment
    @PostMapping
    public ResponseEntity<Appointment> bookAppointment(
            @RequestBody Appointment appointment) {

        Appointment savedAppointment =
                appointmentService.bookAppointment(appointment);

        return ResponseEntity.ok(savedAppointment);
    }

    // View All Appointments
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {

        return ResponseEntity.ok(
                appointmentService.getAllAppointments()
        );
    }

    // View Appointment By Id
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(
            @PathVariable Long id) {

        return appointmentService.getAppointmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete Appointment
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(
            @PathVariable Long id) {

        appointmentService.deleteAppointment(id);

        return ResponseEntity.ok("Appointment Deleted Successfully");
    }

    // Update Appointment Status
    @PutMapping("/{id}/status")
    public ResponseEntity<Appointment> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        Appointment appointment =
                appointmentService.updateStatus(id, status);

        return ResponseEntity.ok(appointment);
    }

}