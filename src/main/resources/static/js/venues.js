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
                    console.log("On venues JS file, Loading first venue with ID:", venueIds[0]);
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
        console.log(`On venues JS file, Fetching venues for page ${page} with size ${pageSize}...`);
        const response = await fetch(`/listOfVenues?page=${page}&size=${pageSize}`);
        const data = await response.json();

        const venues = data.content;
        totalPages = data.totalPages;
        currentPage = data.number;

        const container = document.getElementById('venueContainer');
        container.innerHTML = '';

        console.log(`On venues JS file, Rendering page ${currentPage + 1} of ${totalPages}, venues:`, venues);

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
        console.log("On venues JS file, Finished rendering venues.");
        // Update pagination info
        const info = document.getElementById('paginationInfo');
        info.textContent = `Page ${currentPage + 1} of ${totalPages} — Showing ${venues.length} venues (out of ${data.totalElements})`;

        // Update buttons
        document.getElementById('prevBtn').disabled = currentPage === 0;
        document.getElementById('nextBtn').disabled = currentPage === totalPages - 1;
        console.log("On venues JS file, Pagination buttons updated.");
    } catch (error) {
        console.log("On venues JS file, Error fetching venues:", error);
        console.error('Error fetching venues:', error);
    }
}
function showLoader() {
    const loader = document.getElementById("pageLoader");
    console.log("In venue js file, Showing loader..."+loader); // ✅ debug
    if (loader) {
        console.log("In venue js file, Loader element found, not showing this: ", loader); // Log the loader value
        loader.classList.remove("hide");
        loader.style.display = "flex"; // Use "flex" to match CSS
    }
}
function hideLoader() {
    const loader = document.getElementById("pageLoader");
    if (loader) {
        loader.classList.add("hide");
        setTimeout(() => {
          console.log("hiding loader in venues.js method..."); // ✅ debug
        loader.style.display = "none";
        }, 1200);
    }
}
async function prevPage() {
    if (currentPage > 0) {
        showLoader();
        try {
            await fetchVenues(currentPage - 1);
        } finally {
            hideLoader();
        }
    }
    console.log("On venues JS file, Previous page button clicked");
}

async function nextPage() {
    if (currentPage < totalPages - 1) {
        showLoader();
        try {
            await fetchVenues(currentPage + 1);
        } finally {
            hideLoader();
        }
    }
    console.log("On venues JS file, Next page button clicked");
}

// Pagination button handlers
//function prevPage() {
//    if (currentPage > 0) {
//        fetchVenues(currentPage - 1);
//    }
//    console.log("On venues JS file, Previous page button clicked");
//}
//function nextPage() {
//    if (currentPage < totalPages - 1) {
//        fetchVenues(currentPage + 1);
//    }
//    console.log("On venues JS file, Next page button clicked");
//}

// Load first page on start
window.onload = () => fetchVenues(0);

    function loadVenue(id) {
        fetch(`/Venue/${id}`)
            .then(res => res.json())
            .then(data => {
                console.log("On venues JS file, Loaded venue data:", data);
                document.getElementById("venueName").textContent = data.name;
                document.getElementById("venueLocation").textContent = "Location: " + data.location;
                document.getElementById("venueCapacity").textContent = "Capacity: " + data.capacity;
            })
            .catch(err => console.error('Error loading venue:', err));
    }


async function searchVenue() {
    console.log("On venues JS file, Search button clicked");
    const searchInput = document.getElementById("searchInput");
    const searchValue = searchInput.value.trim().toLowerCase();
    const btnText = document.getElementById("searchBtnText");
    const btnLoader = document.getElementById("searchBtnLoader");
    const searchBtn = document.getElementById("searchBtn");

    if (!searchValue) {
        console.log("On venues JS file, No search input provided");
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
    console.log("On venues JS file, Venue found:", foundVenue);

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
            console.log("On venues JS file, No venue found with that name");
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

        console.error("On venues JS file, Error during search:", error);
        Swal.fire("Something went wrong while searching!");
    }
}
    // Call it when page loads
//    window.onload = fetchVenues;