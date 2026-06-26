package com.vetrihospital.service;

import org.springframework.stereotype.Service;

@Service
public class SmsService {

    // Demo SMS Service
    public String sendAppointmentSMS(
            String patientName,
            String phoneNumber,
            String doctorName,
            String appointmentDate,
            String appointmentTime) {

        String message =
                "Dear " + patientName +
                ", your appointment at Vetri Multi Speciality Hospital is confirmed. " +
                "Doctor: " + doctorName +
                ", Date: " + appointmentDate +
                ", Time: " + appointmentTime +
                ". Thank you.";

        // Demo: Print SMS to console
        System.out.println("==================================");
        System.out.println("SMS SENT SUCCESSFULLY");
        System.out.println("To      : " + phoneNumber);
        System.out.println("Message : " + message);
        System.out.println("==================================");

        return "SMS Sent Successfully (Demo)";
    }
}