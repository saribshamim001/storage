document.addEventListener("DOMContentLoaded", function () {
    const countEl = document.getElementById("bookingCount");
    const bookingCount = countEl ? parseInt(countEl.value, 10) : 0;

    if (bookingCount === 0) {
        Swal.fire({
            icon: 'info',
            title: 'No Bookings Found',
            html: `
                <p style="margin-top:10px;">
                    There are no venue bookings available yet.<br>
                    Once a booking is made, it will appear here ✨
                </p>
            `,
            confirmButtonText: 'Okay',
            backdrop: true
        });

        const tableWrapper = document.querySelector('.table-wrapper');
        if (tableWrapper) {
            tableWrapper.style.display = 'none';
        }
    }
});
