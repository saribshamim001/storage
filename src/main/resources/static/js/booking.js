let venueIdObtained = null;

document.addEventListener("DOMContentLoaded", () => {
    const params = new URLSearchParams(window.location.search);
    venueIdObtained = params.get("id");
    if (!venueIdObtained) {
        console.error("No venue ID provided in URL");
        Swal.fire("Error", "Venue not selected", "error");
        window.location.href = "/error";
        return;
    }
    const venueData = JSON.parse(sessionStorage.getItem("selectedVenue"));
    console.log("Working on booking with venue data");
    if (venueData) {
        document.getElementById("venueNameDisplay").textContent = venueData.name;
        document.getElementById("capacity").value = venueData.capacity;
        document.getElementById("timeSlot").value = venueData.timeslot;
        document.getElementById("decoration").value = venueData.decoration;
        document.getElementById("stage").value = venueData.stage;
        document.getElementById("flowers").value = venueData.flowers;
        console.log("Venue data loaded successfully");
    } else {
        Swal.fire("Error", "No venue data found. Please select a venue again.", "error");
        window.location.href = "/error";
    }
});

function confirmBooking(event) {
    event.preventDefault();
    if (!venueIdObtained) {
        Swal.fire("Error", "Venue ID missing. Please retry.", "error");
        return;
    }
    const venue = JSON.parse(sessionStorage.getItem("selectedVenue"));
    console.log("Confirming booking with venue:", venue);
    const formData = {
        name: venue.name,
        capacity: document.getElementById("capacity").value,
        timeSlot: document.getElementById("timeSlot").value,
        decoration: document.getElementById("decoration").value,
        stage: document.getElementById("stage").value,
        flowers: document.getElementById("flowers").value,
        date: document.getElementById("date").value,
        venueId: venueIdObtained
    };
    console.log("Form Data to be sent for booking:", formData);
    Swal.fire({
        title: 'Booking in progress...',
        allowOutsideClick: false,
        didOpen: () => Swal.showLoading()
    });
    fetch("/book-venue", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
    })
    .then(response => {
        Swal.close();
        if (response.status === 204) {
            Swal.fire({
                icon: 'success',
                title: 'Venue booked successfully!',
                text: 'Redirecting to venues...',
                confirmButtonText: 'OK'
            }).then(() => {
                sessionStorage.removeItem("selectedVenue");
                window.location.href = "/venues";
            });
        } else if (response.status === 409) {
                  Swal.fire({
                      icon: 'warning',
                      title: 'Booking Conflict',
                      text: 'This venue is already booked on the selected date.',
                      confirmButtonText: 'Choose another date'
                  });
              }
        else {
            Swal.fire("Booking failed", "Please try again later.", "error");
        }
    })
    .catch(error => {
        Swal.close();
        Swal.fire("Network Error", "Unable to reach server.", "error");
        console.error(error);
    });
}