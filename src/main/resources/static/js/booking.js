document.addEventListener("DOMContentLoaded", () => {
    const venueData = JSON.parse(sessionStorage.getItem("selectedVenue"));
    console.log("Working on booking with venue data")
    if (venueData) {
        document.getElementById("venueNameDisplay").textContent = venueData.name;
        document.getElementById("capacity").value = venueData.capacity;
        document.getElementById("timeSlot").value = venueData.timeslot;
        document.getElementById("decoration").value = venueData.decoration;
        document.getElementById("stage").value = venueData.stage;
        document.getElementById("flowers").value = venueData.flowers;
        console.log("Venue data found successfully")
    } else {
        alert("⚠️ No venue data found. Please go back and select a venue.");
         window.location.href = "/venues";
    }
});

function confirmBooking(event) {
    event.preventDefault();
    const venue = JSON.parse(sessionStorage.getItem("selectedVenue"));
    console.log("Confirming booking with the venue"+venue)
    const formData = {
        name: venue.name,
        capacity: venue.capacity,
        timeslot: venue.timeslot,
        decoration: venue.decoration,
        stage: venue.stage,
        flowers: venue.flowers,
        date: document.getElementById("date").value,
        timeSlot: document.getElementById("timeSlot").value,
        decorationGuidelines: document.getElementById("decoration").value,
        stageGuidelines: document.getElementById("stage").value,
        flowersGuidelines: document.getElementById("flowers").value,
        comments: document.getElementById("comments").value
    };

    // 🔹 Show loader spinner before fetch
    Swal.fire({
        title: 'Booking in progress...',
        allowOutsideClick: false,
        didOpen: () => {
            Swal.showLoading();
        }
    });

    fetch("/book-venue", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
    }).then(response => {
        Swal.close(); // 🔹 Stop loader when response arrives

        if (response.status === 204) {
            console.log("Booking is confirmed successfully")
            Swal.fire({
                icon: 'success',
                title: 'Venue booked successfully!',
                text: 'Redirecting to the main page...',
                confirmButtonText: 'OK'
            }).then(() => {
                window.location.href = "/venues";
            });
        } else if (response.status === 500) {
            console.log("Booking is confirmed but SMS could not sent due to some issue")
            Swal.fire({
                icon: 'error',
                title: 'Booking saved, but SMS could not be sent.',
                text: 'Please check SMS service settings.',
                confirmButtonText: 'OK'
            });
        } else {
        console.log("Booking failed !")
            Swal.fire({
                icon: 'error',
                title: 'Booking failed!',
                text: 'Please try again.',
                confirmButtonText: 'OK'
            });
        }
    }).catch(error => {
        Swal.close(); // close loader if error happens
        Swal.fire({
            icon: 'error',
            title: 'Network Error!',
            text: 'Unable to reach server. Please try again.',
            confirmButtonText: 'OK'
        });
    });
}
