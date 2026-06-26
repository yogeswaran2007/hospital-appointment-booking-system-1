CREATE DATABASE vetri_hospital;

USE vetri_hospital;

-- ===========================
-- PATIENT TABLE
-- ===========================
CREATE TABLE patients(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(20),
    password VARCHAR(100),
    age INT,
    gender VARCHAR(20),
    address VARCHAR(255)
);

-- ===========================
-- DOCTOR TABLE
-- ===========================
CREATE TABLE doctors(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    doctor_name VARCHAR(100),
    specialization VARCHAR(100),
    department VARCHAR(100),
    qualification VARCHAR(100),
    experience INT,
    phone VARCHAR(20),
    email VARCHAR(100),
    available_days VARCHAR(100),
    available_time VARCHAR(100)
);

-- ===========================
-- APPOINTMENT TABLE
-- ===========================
CREATE TABLE appointments(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    patient_id BIGINT,
    doctor_id BIGINT,
    appointment_date DATE,
    appointment_time TIME,
    symptoms VARCHAR(500),
    status VARCHAR(50),

    FOREIGN KEY(patient_id)
    REFERENCES patients(id),

    FOREIGN KEY(doctor_id)
    REFERENCES doctors(id)
);

-- ===========================
-- SAMPLE DOCTORS
-- ===========================

INSERT INTO doctors
(doctor_name,specialization,department,qualification,experience,phone,email,available_days,available_time)

VALUES

('Dr. Arun Kumar','Cardiologist','Cardiology',
'MBBS MD DM',10,'9876543210',
'arun@vetrihospital.com',
'Monday-Friday',
'09:00 AM - 01:00 PM'),

('Dr. Priya','Neurologist','Neurology',
'MBBS MD DM',8,'9876543211',
'priya@vetrihospital.com',
'Monday-Saturday',
'10:00 AM - 02:00 PM'),

('Dr. Ravi','Orthopaedic','Orthopaedics',
'MBBS MS',12,'9876543212',
'ravi@vetrihospital.com',
'Monday-Friday',
'11:00 AM - 04:00 PM'),

('Dr. Meena','Pediatrician','Pediatrics',
'MBBS DCH',9,'9876543213',
'meena@vetrihospital.com',
'Monday-Saturday',
'09:30 AM - 03:30 PM');