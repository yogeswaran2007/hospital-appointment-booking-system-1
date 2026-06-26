package com.vetrihospital.service;

import com.vetrihospital.entity.Appointment;
import com.vetrihospital.entity.Doctor;
import com.vetrihospital.entity.Patient;
import com.vetrihospital.repository.AppointmentRepository;
import com.vetrihospital.repository.DoctorRepository;
import com.vetrihospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    // Book Appointment
    public Appointment bookAppointment(Appointment appointment) {
        appointment.setStatus("PENDING");
        return appointmentRepository.save(appointment);
    }

    // Get All Appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Get Appointment By Id
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    // Delete Appointment
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    // Update Status
    public Appointment updateStatus(Long id, String status) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment Not Found"));

        appointment.setStatus(status);

        return appointmentRepository.save(appointment);
    }

    // Get Patient Appointments
    public List<Appointment> getPatientAppointments(Patient patient) {
        return appointmentRepository.findByPatient(patient);
    }

    // Get Doctor Appointments
    public List<Appointment> getDoctorAppointments(Doctor doctor) {
        return appointmentRepository.findByDoctor(doctor);
    }

}