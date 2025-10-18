document.addEventListener("DOMContentLoaded", () => {
    const params = new URLSearchParams(window.location.search);
    const id = params.get("id");

    if (id) {
        console.log(`In parameterizedVenue js file, Fetching venue with id: ${id}`);

        fetch(`/Venue/${id}`)
            .then(response => {
                console.log(`Received response with status: ${response.status}`);
                console.assert(response.ok, `Failed response: ${response.status}`);
                return response.json();
            })
            .then(wrapper => {
                console.assert(wrapper, "Wrapper is null or undefined");
                console.log("Full API response:", wrapper);
                const data = wrapper.data;
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
                console.error("Error fetching venue:", error);
                Swal.fire({
                    icon: 'error',
                    title: 'Error',
                    text: 'Could not load venue details.',
                    timer: 2000,
                    showConfirmButton: false
                });
            });
    } else {
        alert("No venue ID specified in the URL.");
    }
});

function bookNow() {
    console.log("bookNow() called");
    const venueData = {
        name: document.getElementById('venueName').textContent,
        capacity: document.getElementById('venueCapacity').textContent,
        timeslot: document.getElementById('venueTimeslot').textContent,
        decoration: document.getElementById('venueDecoration').textContent,
        stage: document.getElementById('venueStage').textContent,
        flowers: document.getElementById('venueFlowers').textContent,
    };
    console.log("Venue data to be booked:", venueData);
    sessionStorage.setItem("selectedVenue", JSON.stringify(venueData));
    console.log("Venue data saved to sessionStorage. Redirecting to /booking");
    window.location.href = "/booking";
}


function updateVenue() {
    console.log("updateVenue() called");
    const venueData = {
         name: document.getElementById('venueName').textContent,
         capacity: document.getElementById('venueCapacity').textContent,
         timeslot: document.getElementById('venueTimeslot').textContent,
         decoration: document.getElementById('venueDecoration').textContent,
         stage: document.getElementById('venueStage').textContent,
         flowers: document.getElementById('venueFlowers').textContent,
        };
    console.log("Venue data to update:", venueData);
    sessionStorage.setItem("selectedVenue", JSON.stringify(venueData));
    console.log("Venue data saved to sessionStorage");

    let venueId = getVenueIdFromURL();
    console.log("Redirecting to /updateVenue with id:", venueId);
    window.location.href = `/updateVenue?id=${venueId}`;
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
