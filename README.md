# hospital-appointment-booking-system-1
# 🏥 Vetri Multi Speciality Hospital - Appointment Booking System

A full-stack Hospital Appointment Booking System developed using **Spring Boot**, **HTML**, **CSS**, **JavaScript**, and **MySQL**. This application allows patients to register, log in, view doctors, book appointments, and receive appointment notifications through Email and SMS.

---

## 📌 Features

- 👤 Patient Registration
- 🔐 Patient Login
- 🩺 View Specialist Doctors
- 📅 Online Appointment Booking
- 📧 Email Notification
- 📱 SMS Notification
- 🗄️ MySQL Database Integration
- 🌐 Responsive User Interface
- 🔒 Spring Boot REST API

---

## 🛠️ Technologies Used

### Frontend
- HTML5
- CSS3
- JavaScript

### Backend
- Java
- Spring Boot
- Spring Data JPA
- Spring Mail

### Database
- MySQL

### Notifications
- JavaMailSender (Email)
- Twilio (SMS)

---

## 📂 Project Structure

```
Vetri-Multi-Speciality-Hospital
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.vetrihospital
│   │   │       ├── controller
│   │   │       ├── entity
│   │   │       ├── repository
│   │   │       ├── service
│   │   │       ├── config
│   │   │       └── HospitalAppointmentSystemApplication.java
│   │   │
│   │   └── resources
│   │       ├── static
│   │       └── application.properties
│
├── hospital.sql
├── pom.xml
└── README.md
```

---

## 🚀 Modules

- Home
- About
- Doctors
- Patient Registration
- Patient Login
- Appointment Booking
- Contact

---

## ⚙️ Installation

1. Clone the repository

```bash
git clone https://github.com/your-username/Vetri-Multi-Speciality-Hospital.git
```

2. Open the project in IntelliJ IDEA or Eclipse.

3. Create a MySQL database:

```sql
CREATE DATABASE vetri_hospital;
```

4. Import the `hospital.sql` file.

5. Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/vetri_hospital
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

6. Run the Spring Boot application.

7. Open your browser:

```
http://localhost:8080/
```

---

## 📸 Screenshots

- Home Page
- Login Page
- Registration Page
- Doctors Page
- Appointment Booking Page
- Contact Page

(Add screenshots after running the project.)

---

## 👨‍💻 Developed By

**Yogeswaran S**

Department of Artificial Intelligence and Data Science

VSB Engineering College

Karur, Tamil Nadu

Email: yogesvetri2007@gmail.com

---

## 📄 License

This project is developed for educational and learning purposes.

© 2026 Yogeswaran S. All Rights Reserved.