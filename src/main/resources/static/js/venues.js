    let venueIds = [];
    let currentIndex = 0;

    // Step 1: Fetch all venue IDs on page load
    window.onload = function () {
        console.log("Fetching venue IDs...")
        fetch('/VenueIds')
            .then(res => res.json())
            .then(data => {
                venueIds = data;
                if (venueIds.length > 0) {
                    // Load first venue
                    console.log("Loading first venue with ID:", venueIds[0]);
                    loadVenue(venueIds[currentIndex]);
                }
            })
            .catch(err => console.error('Error loading venue IDs:', err));
    };

let currentPage = 0;
let pageSize = 8;
let totalPages = 0;

async function fetchVenues(page = 0) {
    try {
        const response = await fetch(`/listOfVenues?page=${page}&size=${pageSize}`);
        const data = await response.json();

        const venues = data.content;
        totalPages = data.totalPages;
        currentPage = data.number;

        const container = document.getElementById('venueContainer');
        container.innerHTML = '';

        console.log(`Rendering page ${currentPage + 1} of ${totalPages}, venues:`, venues);

        venues.forEach(venue => {
            const card = document.createElement('div');
            card.className = 'venue-card';
            card.innerHTML = `
                <div class="venue-card-content">
                    <a href="/parameterizedVenue?id=${venue.id}">
                        <img src="${venue.imageUrl}" alt="${venue.name}" class="venue-image">
                    </a>
                    <div class="venue-content">
                        <a href="/parameterizedVenue?id=${venue.id}">
                            <h2>${venue.name}</h2>
                        </a>
                        <p><strong>Capacity:</strong> ${venue.capacity}</p>
                        <p><strong>Decoration:</strong> ${venue.decoration}</p>
                        <p><strong>Flowers:</strong> ${venue.flowers}</p>
                        <p><strong>Stage:</strong> ${venue.stage}</p>
                        <p><strong>Time Slot:</strong> ${venue.timeslot}</p>
                    </div>
                </div>
            `;
            container.appendChild(card);
        });

        // Update pagination info
        const info = document.getElementById('paginationInfo');
        info.textContent = `Page ${currentPage + 1} of ${totalPages} — Showing ${venues.length} venues (out of ${data.totalElements})`;

        // Update buttons
        document.getElementById('prevBtn').disabled = currentPage === 0;
        document.getElementById('nextBtn').disabled = currentPage === totalPages - 1;

    } catch (error) {
        console.error('Error fetching venues:', error);
    }
}

// Pagination button handlers
function prevPage() {
    if (currentPage > 0) {
        fetchVenues(currentPage - 1);
    }
}
function nextPage() {
    if (currentPage < totalPages - 1) {
        fetchVenues(currentPage + 1);
    }
}

// Load first page on start
window.onload = () => fetchVenues(0);

    function loadVenue(id) {
        fetch(`/Venue/${id}`)
            .then(res => res.json())
            .then(data => {
                document.getElementById("venueName").textContent = data.name;
                document.getElementById("venueLocation").textContent = "Location: " + data.location;
                document.getElementById("venueCapacity").textContent = "Capacity: " + data.capacity;
            })
            .catch(err => console.error('Error loading venue:', err));
    }


async function searchVenue() {
    console.log("Search button clicked");
    const searchInput = document.getElementById("searchInput");
    const searchValue = searchInput.value.trim().toLowerCase();
    const btnText = document.getElementById("searchBtnText");
    const btnLoader = document.getElementById("searchBtnLoader");
    const searchBtn = document.getElementById("searchBtn");

    if (!searchValue) {
        console.log("No search input provided");
        Swal.fire("Enter a venue name to search!");
        return;
    }

    searchInput.value = "";

    try {
        // Show loader & disable button
        btnText.textContent = "Searching...";
        btnLoader.style.display = "inline-block";
        searchBtn.disabled = true;

        const startTime = Date.now();

        const response = await fetch('/listOfVenues');
        const venues = await response.json();

        // ⏳ Ensure loader shows for at least 800ms
        const elapsed = Date.now() - startTime;
        if (elapsed < 800) {
            await new Promise(resolve => setTimeout(resolve, 1200 - elapsed));
        }

        // Reset button
        btnText.textContent = "Search";
        btnLoader.style.display = "none";
        searchBtn.disabled = false;

        const foundVenue = venues.find(v => v.name.toLowerCase() === searchValue);

        if (foundVenue) {
    console.log("Venue found:", foundVenue);

    const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 2000,
        timerProgressBar: true
    });

    Toast.fire({
        icon: 'success',
        title: 'Venue found! Redirecting...'
    });

    setTimeout(() => {
        window.location.href = `/parameterizedVenue?id=${foundVenue.id}`;
    }, 2000);
}
         else {
            console.log("No venue found with that name");
            Swal.fire({
                icon: 'error',
                title: 'Not Found',
                text: 'No venue found with that name.',
                timer: 2000,
                showConfirmButton: false
            });
        }
    } catch (error) {
        // Reset button on error
        btnText.textContent = "Search";
        btnLoader.style.display = "none";
        searchBtn.disabled = false;

        console.error("Error during search:", error);
        Swal.fire("Something went wrong while searching!");
    }
}
    // Call it when page loads
//    window.onload = fetchVenues;