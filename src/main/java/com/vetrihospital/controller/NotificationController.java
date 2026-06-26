package com.vetrihospital.controller;

import com.vetrihospital.service.EmailService;
import com.vetrihospital.service.SmsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification")
@CrossOrigin(origins = "*")
public class NotificationController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private SmsService smsService;

    @PostMapping("/demo")
    public ResponseEntity<String> sendDemoNotification() {

        emailService.sendAppointmentConfirmation(
                "demo@gmail.com",
                "Yogeswaran",
                "Dr. Arun Kumar",
                "15-07-2026",
                "10:30 AM"
        );

        smsService.sendAppointmentSMS(
                "Yogeswaran",
                "9361851244",
                "Dr. Arun Kumar",
                "15-07-2026",
                "10:30 AM"
        );

        return ResponseEntity.ok("Email & SMS Demo Notification Sent Successfully");
    }
}