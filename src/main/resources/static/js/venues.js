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
        console.log(`Fetching venues for page ${page} with size ${pageSize}...`);

        // 1️⃣ Fetch paginated venues
        const response = await fetch(`/listOfVenues?page=${page}&size=${pageSize}`);
        const apiResponse = await response.json();

        const venues = apiResponse.data || [];
        if (venues.length === 0) {
            document.getElementById('venueContainer').innerHTML = '';
            document.querySelector('.pagination-container').style.display = 'none';
            Swal.fire({
                icon: 'info',
                title: 'No Venues Listed Yet',
                text: 'There are currently no venues available. Please check back later.',
                confirmButtonText: 'Okay',
                backdrop: true,
            });
            return; // ⛔ stop further rendering
        }
        totalPages = apiResponse.totalPages;
        currentPage = apiResponse.currentPage;
        const totalElements = apiResponse.totalElements;

        // 2️⃣ Fetch booked venues
        const bookedResponse = await fetch('/booked-venues');
        const bookedVenues = await bookedResponse.json();

        // 3️⃣ Map booked venue ID → array of bookings
        const bookedMap = {};
        bookedVenues.forEach(bv => {
            if (!bookedMap[bv.bookingVenueId]) {
                bookedMap[bv.bookingVenueId] = [];
            }
            bookedMap[bv.bookingVenueId].push(bv);
        });

        const container = document.getElementById('venueContainer');
        container.innerHTML = '';

        console.log(`Rendering page ${currentPage + 1} of ${totalPages}`, venues);

        let visibleVenuesCount = 0;

        // 4️⃣ Render each venue
        venues.forEach(venue => {
            visibleVenuesCount++;

            const bookingsForVenue = bookedMap[venue.id] || [];
            const isBooked = bookingsForVenue.length > 0;

            // Generate booked dates HTML
            const bookedText = bookingsForVenue.map(bv => {
                return `<p class="booked-info"><strong>Booked on:</strong> ${bv.bookingDate}</p>`;
            }).join('');

            const statusText = isBooked
                ? `<p class="booked-status">Status: <span style="color:red;font-weight:bold;">Booked</span></p>`
                : `<p class="booked-status">Status: <span style="color:green;font-weight:bold;">Available</span></p>`;

            const card = document.createElement('div');
            card.className = `venue-card ${isBooked ? 'booked-card' : ''}`;

            card.innerHTML = `
                <div class="venue-card-content">
                    <div class="venue-image-wrapper">
                        <a href="/parameterizedVenue?id=${venue.id}">
                            <img src="${venue.imageUrl}" alt="${venue.name}" class="venue-image">
                        </a>
                    </div>
                    <div class="venue-content">
                        <a href="/parameterizedVenue?id=${venue.id}">
                            <h2>${venue.name}</h2>
                        </a>
                        <p><strong>Capacity:</strong> ${venue.capacity}</p>
                        <p><strong>Decoration:</strong> ${venue.decoration}</p>
                        <p><strong>Flowers:</strong> ${venue.flowers}</p>
                        <p><strong>Stage:</strong> ${venue.stage}</p>
                        <p><strong>Time Slot:</strong> ${venue.timeslot}</p>
                        ${statusText}
                        ${bookedText}
                    </div>
                </div>
            `;
            container.appendChild(card);
        });

        // 5️⃣ Update pagination info
        const info = document.getElementById('paginationInfo');
        info.textContent = `Page ${currentPage + 1} of ${totalPages} — Showing ${visibleVenuesCount} venues (out of ${totalElements})`;

        document.getElementById('prevBtn').disabled = currentPage === 0;
        document.getElementById('nextBtn').disabled = currentPage === totalPages - 1;

        window.scrollTo({ top: 0, behavior: 'smooth' });
    } catch (error) {
        console.error('Error fetching venues:', error);
    } finally {
        const btnText = document.getElementById("searchBtnText");
        const btnLoader = document.getElementById("searchBtnLoader");
        const searchBtn = document.getElementById("searchBtn");
        if (btnText) btnText.textContent = "Search";
        if (btnLoader) btnLoader.style.display = "none";
        if (searchBtn) searchBtn.disabled = false;
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

        const response = await fetch('/searchAllVenues');
        const venuesResponse = await response.json();
        const venues = venuesResponse.data || [];
        console.log("📋 Fetched venues:", venues);
        // ⏳ Ensure loader shows for at least 800ms
        const elapsed = Date.now() - startTime;
        if (elapsed < 800) {
            await new Promise(resolve => setTimeout(resolve, 1200 - elapsed));
        }

        // Reset button
        btnText.textContent = "Search";
        btnLoader.style.display = "none";
        searchBtn.disabled = false;
        console.log("🔍 Searching for venue with name:", searchValue);
        const foundVenue = venues.find(v => v.name.toLowerCase() === searchValue);
        if (foundVenue) {
          console.log("✅ Venue found:", foundVenue);
        } else {
          console.warn("⚠️ No venue found matching:", searchValue);
        }
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