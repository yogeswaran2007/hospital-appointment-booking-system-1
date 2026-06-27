// =======================================
// Vetri Multi Speciality Hospital
// Login JavaScript
// =======================================

const loginForm = document.getElementById("loginForm");

if (loginForm) {

    loginForm.addEventListener("submit", async function (event) {

        event.preventDefault();

        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;

        const loginData = {
            email: email,
            password: password
        };

        try {

            const response = await fetch("http://localhost:8080/api/auth/login", {

                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(loginData)

            });

            if (response.ok) {

                const result = await response.json();

                alert("Login Successful");

                localStorage.setItem("patient", JSON.stringify(result));

                window.location.href = "appointment.html";

            } else {

                alert("Invalid Email or Password");

            }

        } catch (error) {

            console.error(error);

            alert("Server Connection Failed");

        }

    });

}