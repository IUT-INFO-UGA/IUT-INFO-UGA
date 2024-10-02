const button = document.querySelector(".newPassord");
button.addEventListener("click", () => {
  const password = document.querySelector("#password").value;
  const password2 = document.querySelector("#passwordRetype").value;
  if (password !== password2) {
    errorPassword("passwords do not match");
    return;
  }
  if (password.length < 6) {
    errorPassword("password must be at least 6 characters long");
    return;
  }
  if (!/\d/.test(password)) {
    errorPassword("password must contain a number");
    return;
  }

  fetch("set_passwd.php", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ password }),
  })
    .then((response) => response.json())
    .then((data) => {
      if (data.success) {
        // Password successfully set
        console.log("Password set successfully");
      } else {
        // Error setting password
        errorPassword("Error setting password");
      }
    })
    .catch((error) => {
      console.error("Error:", error);
      errorPassword("An error occurred");
    });
});

function errorPassword(text) {
  document.querySelector(".error").textContent = text;
}
