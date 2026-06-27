// =======================================
// Vetri Multi Speciality Hospital
// Register JavaScript
// =======================================

const registerForm = document.getElementById("registerForm");

if (registerForm) {

    registerForm.addEventListener("submit", async function (event) {

        event.preventDefault();

        const password = document.getElementById("password").value;
        const confirmPassword = document.getElementById("confirmPassword").value;

        if (password !== confirmPassword) {
            alert("Passwords do not match.");
            return;
        }

        const patient = {

            fullName: document.getElementById("fullName").value,
            email: document.getElementById("email").value,
            phone: document.getElementById("phone").value,
            dob: document.getElementById("dob").value,
            gender: document.getElementById("gender").value,
            address: document.getElementById("address").value,
            password: password

        };

        try {

            const response = await fetch("http://localhost:8080/api/auth/register", {

                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(patient)

            });

            if (response.ok) {

                alert("Registration Successful");

                window.location.href = "login.html";

            } else {

                const message = await response.text();

                alert("Registration Failed: " + message);

            }

        } catch (error) {

            console.error(error);

            alert("Unable to connect to the server.");

        }

    });

}