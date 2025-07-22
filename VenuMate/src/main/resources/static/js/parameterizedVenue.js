document.addEventListener("DOMContentLoaded", () => {
    const params = new URLSearchParams(window.location.search);
    const id = params.get("id");

    if (id) {
        fetch(`/Venue/${id}`)
            .then(response => {
                console.assert(response.ok, `Failed response: ${response.status}`);
                return response.json();
            })
            .then(data => {
                console.assert(data, "Data is null or undefined");

                console.assert(data.imageUrl, "Missing imageUrl");
                document.getElementById("venueImage").src = data.imageUrl;

                console.assert(data.name, "Missing name");
                document.getElementById("venueImage").alt = data.name;
                document.getElementById("venueName").textContent = data.name;

                console.assert(data.capacity, "Missing capacity");
                document.getElementById("venueCapacity").textContent = data.capacity;

                console.assert(data.decoration, "Missing decoration");
                document.getElementById("venueDecoration").textContent = data.decoration;

                console.assert(data.flowers, "Missing flowers");
                document.getElementById("venueFlowers").textContent = data.flowers;

                console.assert(data.stage, "Missing stage");
                document.getElementById("venueStage").textContent = data.stage;

                console.assert(data.timeslot, "Missing timeslot");
                document.getElementById("venueTimeslot").textContent = data.timeslot;
            })
            .catch(error => {
                console.error("Error loading venue:", error);
                alert("Failed to load venue data.");
            });
    } else {
        alert("No venue ID specified in the URL.");
    }
});

function bookNow() {
    const venueData = {
        name: document.getElementById('venueName').textContent,
        capacity: document.getElementById('venueCapacity').textContent,
        timeslot: document.getElementById('venueTimeslot').textContent,
        decoration: document.getElementById('venueDecoration').textContent,
        stage: document.getElementById('venueStage').textContent,
        flowers: document.getElementById('venueFlowers').textContent,
    };
    sessionStorage.setItem("selectedVenue", JSON.stringify(venueData));
    window.location.href = "/booking";
}


function updateVenue() {
    const venueData = {
            name: document.getElementById('venueName').textContent,
            capacity: document.getElementById('venueCapacity').textContent,
            timeslot: document.getElementById('venueTimeslot').textContent,
            decoration: document.getElementById('venueDecoration').textContent,
            stage: document.getElementById('venueStage').textContent,
            flowers: document.getElementById('venueFlowers').textContent,
        };


    // Save to session storage
    sessionStorage.setItem("selectedVenue", JSON.stringify(venueData));
//    sessionStorage.setItem("mode", "update");
//    window.location.href = "/updateVenue";
        let venueId  =  getVenueIdFromURL()
        window.location.href = `/updateVenue?id=${venueId}`; // pass id via URL

}

function deleteVenue(){
        window.location.href = `/updateVenue?id=${venueId}`;
}

function getVenueIdFromURL() {
    const params = new URLSearchParams(window.location.search);
    return params.get('id');
}


function showNextVenue() {
    console.log("Fetching venue IDs...");

    const currentId = parseInt(new URLSearchParams(window.location.search).get("id"));

    fetch('/AllVenuesIds')
        .then(response => {
            if (!response.ok) {
                throw new Error("Failed to fetch IDs");
            }
            return response.json();
        })
        .then(venueIds => {
            console.log("Fetched venue IDs:", venueIds);

            const currentIndex = venueIds.indexOf(currentId);
            if (currentIndex === -1) {
                console.error("Current ID not found in list");
                return;
            }

            const nextIndex = (currentIndex + 1) % venueIds.length;
            const nextId = venueIds[nextIndex];
            console.log("Next venue ID:", nextId);

            // Redirect to load next venue
            window.location.href = `/parameterizedVenue?id=${nextId}`;
        })
        .catch(error => {
            console.error("Error:", error);
        });
}


function confirmDeleteForm() {
  return confirm("Are you sure you want to delete this venue?");
}
