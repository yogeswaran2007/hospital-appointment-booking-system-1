// =======================================
// Vetri Multi Speciality Hospital
// Doctors JavaScript
// =======================================

document.addEventListener("DOMContentLoaded", loadDoctors);

async function loadDoctors() {

    try {

        const response = await fetch("http://localhost:8080/api/doctors");

        if (!response.ok) {
            throw new Error("Unable to fetch doctors.");
        }

        const doctors = await response.json();

        const doctorContainer = document.querySelector(".doctor-container");

        if (!doctorContainer) return;

        doctorContainer.innerHTML = "";

        doctors.forEach(doctor => {

            doctorContainer.innerHTML += `

            <div class="doctor-card">

                <img src="images/doctor.png" alt="Doctor">

                <h3>${doctor.doctorName}</h3>

                <p><strong>Department:</strong> ${doctor.department}</p>

                <p><strong>Specialization:</strong> ${doctor.specialization}</p>

                <p><strong>Experience:</strong> ${doctor.experience} Years</p>

                <a href="appointment.html" class="btn">
                    Book Appointment
                </a>

            </div>

            `;

        });

    } catch (error) {

        console.error(error);

    }

}