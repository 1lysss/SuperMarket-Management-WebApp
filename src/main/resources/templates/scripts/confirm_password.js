const password = document.getElementById("password");
const confirmPassword = document.getElementById("confirmPassword");
const message = document.getElementById("message");

function checkPasswords() {
    if (confirmPassword.value === "") {
        message.textContent = "";
        return;
    }

    if (password.value === confirmPassword.value) {
        message.textContent = "Passwords match";
        message.style.color = "green";
    } else {
        message.textContent = "Passwords do not match";
        message.style.color = "red";
    }
}

password.addEventListener("input", checkPasswords);
confirmPassword.addEventListener("input", checkPasswords);
