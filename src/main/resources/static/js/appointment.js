// =======================================
// Vetri Multi Speciality Hospital
// Appointment JavaScript
// =======================================

const appointmentForm = document.getElementById("appointmentForm");

if (appointmentForm) {

    appointmentForm.addEventListener("submit", async function (event) {

        event.preventDefault();

        const appointment = {

            patientName: document.getElementById("patientName").value,
            email: document.getElementById("email").value,
            phone: document.getElementById("phone").value,
            department: document.getElementById("department").value,
            doctor: document.getElementById("doctor").value,
            appointmentDate: document.getElementById("appointmentDate").value,
            appointmentTime: document.getElementById("appointmentTime").value,
            symptoms: document.getElementById("symptoms").value

        };

        try {

            const response = await fetch("http://localhost:8080/api/appointments", {

                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(appointment)

            });

            if (response.ok) {

                const result = await response.json();

                alert(
                    "Appointment Booked Successfully!\n\n" +
                    "Appointment ID: " + result.id
                );

                appointmentForm.reset();

            } else {

                const error = await response.text();

                alert("Booking Failed: " + error);

            }

        } catch (err) {

            console.error(err);

            alert("Server connection failed.");

        }

    });

}