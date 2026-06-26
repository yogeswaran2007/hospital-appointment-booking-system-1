package com.vetrihospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Send Appointment Confirmation Email
    public void sendAppointmentConfirmation(
            String toEmail,
            String patientName,
            String doctorName,
            String appointmentDate,
            String appointmentTime) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(toEmail);
        message.setSubject("Vetri Multi Speciality Hospital - Appointment Confirmation");

        message.setText(
                "Dear " + patientName + ",\n\n" +
                "Your appointment has been successfully booked.\n\n" +
                "Hospital : Vetri Multi Speciality Hospital\n" +
                "Doctor   : " + doctorName + "\n" +
                "Date     : " + appointmentDate + "\n" +
                "Time     : " + appointmentTime + "\n\n" +
                "Please arrive 15 minutes before your appointment.\n\n" +
                "Thank you,\n" +
                "Vetri Multi Speciality Hospital"
        );

        mailSender.send(message);
    }
}