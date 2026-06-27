// ==========================================
// Vetri Multi Speciality Hospital
// Common JavaScript
// ==========================================

// Display current year in footer (if element exists)
const year = document.getElementById("year");

if (year) {
    year.innerHTML = new Date().getFullYear();
}

// Welcome message
window.addEventListener("load", () => {
    console.log("Welcome to Vetri Multi Speciality Hospital");
});

// Smooth scroll for navigation links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {

    anchor.addEventListener("click", function (e) {

        e.preventDefault();

        const target = document.querySelector(this.getAttribute("href"));

        if (target) {
            target.scrollIntoView({
                behavior: "smooth"
            });
        }

    });

});

// Button animation
const buttons = document.querySelectorAll(".btn");

buttons.forEach(button => {

    button.addEventListener("mouseover", () => {
        button.style.transform = "scale(1.05)";
    });

    button.addEventListener("mouseout", () => {
        button.style.transform = "scale(1)";
    });

});

// Page Loaded
console.log("Hospital Website Loaded Successfully");