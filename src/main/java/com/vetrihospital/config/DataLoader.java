package com.vetrihospital.config;

import com.vetrihospital.entity.Doctor;
import com.vetrihospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void run(String... args) throws Exception {

        if (doctorRepository.count() == 0) {

            Doctor doctor1 = new Doctor();
            doctor1.setDoctorName("Dr. Arun Kumar");
            doctor1.setDepartment("Cardiology");
            doctor1.setSpecialization("Cardiologist");
            doctor1.setQualification("MBBS, MD");
            doctor1.setExperience(10);
            doctor1.setPhone("9876543210");
            doctor1.setEmail("arun@vetrihospital.com");
            doctor1.setAvailableDays("Monday - Friday");
            doctor1.setAvailableTime("09:00 AM - 01:00 PM");

            Doctor doctor2 = new Doctor();
            doctor2.setDoctorName("Dr. Priya");
            doctor2.setDepartment("Neurology");
            doctor2.setSpecialization("Neurologist");
            doctor2.setQualification("MBBS, DM");
            doctor2.setExperience(8);
            doctor2.setPhone("9876543211");
            doctor2.setEmail("priya@vetrihospital.com");
            doctor2.setAvailableDays("Monday - Saturday");
            doctor2.setAvailableTime("10:00 AM - 02:00 PM");

            doctorRepository.save(doctor1);
            doctorRepository.save(doctor2);

            System.out.println("Demo doctors inserted successfully.");
        }
    }
}