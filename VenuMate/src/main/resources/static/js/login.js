document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.getElementById("loginForm");

    loginForm.addEventListener("submit", function(event) {
        const username = document.getElementById("username").value.trim();
        const password = document.getElementById("password").value.trim();

        if (!username || !password) {
            event.preventDefault(); // Stop form submission
            alert("Please fill in both username and password.");
        }
    });
});

document.addEventListener("DOMContentLoaded", function () {
    const registerLink = document.getElementById("registerLink");

    if (registerLink) {
        registerLink.addEventListener("click", function (event) {
            event.preventDefault();
            alert("🚧 The sign-up operation is not yet implemented.\n🙏 Please bear with us. Thank you! 😉");
        });
    }
});

document.addEventListener("DOMContentLoaded", function () {
    const loginErrorMeta = document.querySelector('meta[name="login-error"]');
    const loginError = loginErrorMeta ? loginErrorMeta.content === 'true' : false;

    if (loginError) {
        alert("Incorrect username or password ❌");
    }
});
