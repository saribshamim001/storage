Swal.fire({
    icon: 'error',
    title: 'Access Denied',
    text: "Admin can't book an event.",
    confirmButtonText: 'OK'
}).then(() => {
    window.location.href = "/venues"; // Adjust redirect if needed
});
