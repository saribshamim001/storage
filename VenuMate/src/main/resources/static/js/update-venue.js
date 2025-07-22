document.addEventListener("DOMContentLoaded", () => {
    const venueData = JSON.parse(sessionStorage.getItem("selectedVenue"));

    if (venueData) {
        let venueId = getVenueIdFromURL()
//        document.getElementById("name").value = getVenueIdFromURL();
        document.getElementById("name").value = venueData.name;
        document.getElementById("capacity").value = venueData.capacity;

        const timeslotSelect = document.getElementById("timeslot");
        const slotValue = venueData.timeslot?.trim() || '';

        if (slotValue) {
            let exists = false;

            // Check if the value already exists in the options
            for (let option of timeslotSelect.options) {
                if (option.value === slotValue) {
                    exists = true;
                    break;
                }
            }

            // If it doesn't exist, create and append it
            if (!exists) {
                const newOption = document.createElement("option");
                newOption.value = slotValue;
                newOption.textContent = slotValue;
                timeslotSelect.appendChild(newOption);
            }

            // Set the value
            timeslotSelect.value = slotValue;
        }

        document.getElementById("decoration").value = venueData.decoration;
        document.getElementById("stage").value = venueData.stage;
        document.getElementById("flowers").value = venueData.flowers;

    } else {
        alert("⚠️ No venue data found. Please go back and select a venue.");
        window.location.href = "/venues";
    }
});


function getVenueIdFromURL() {
    const params = new URLSearchParams(window.location.search);
    return params.get('id');
}


document.getElementById("updateVenueForm").addEventListener("submit", function (e) {
    const requiredFields = ["decoration", "stage", "flowers"];
    let allValid = true;

    for (let id of requiredFields) {
        const input = document.getElementById(id);
        if (!input.value.trim()) {
            input.classList.add("error"); // optional: add red border
            allValid = false;
        } else {
            input.classList.remove("error");
        }
    }

    if (!allValid) {
        e.preventDefault();
        alert("Please fill in all required fields.");
    }
});
