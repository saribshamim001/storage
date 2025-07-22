document.addEventListener("DOMContentLoaded", () => {
    const venueData = JSON.parse(sessionStorage.getItem("selectedVenue"));

    if (venueData) {
        document.getElementById("venueNameDisplay").textContent = venueData.name;
        document.getElementById("capacity").value = venueData.capacity;
        document.getElementById("timeSlot").value = venueData.timeslot;
        document.getElementById("decoration").value = venueData.decoration;
        document.getElementById("stage").value = venueData.stage;
        document.getElementById("flowers").value = venueData.flowers;
    } else {
        alert("⚠️ No venue data found. Please go back and select a venue.");
         window.location.href = "/venues";
    }

});

function confirmBooking() {
    event.preventDefault();
    const venue = JSON.parse(sessionStorage.getItem("selectedVenue"));

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

    fetch("/book-venue", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
    }).then(response => {
    if (response.status === 204) {
        alert("Booking confirmed!");
        window.location.href = "/venues";
    }
     else {
            alert("Booking failed.");
        }
    });
}
