document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("bookingForm");
  let venueData = null;

try {
    venueData = JSON.parse(sessionStorage.getItem("selectedVenue"));
} catch (error) {
    console.error("Error parsing selectedVenue from sessionStorage:", error);
    Swal.fire({
    icon: 'error',
      title: 'Error obtaining the selectedVenue from sessionStorage.',
      text: 'Plz try again later.',
      confirmButtonText: 'OK'
    });
}
console.log("Venue capacity:", venueData.capacity)
  const validators = {
    name: value => value.length >= 5 && value.length <= 100,
    capacity: value => value >= 10 && value <= venueData.capacity,
    timeslot: value => value !== "",
    decoration: value => value.length >= 5 && value.length <= 100,
    stage: value => value.length >= 5 && value.length <= 100,
    flowers: value => value.length >= 5 && value.length <= 100,
    imageFile: value => value !== "",
    email: value => /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(value),
    mobile: value => /^03\d{9}$/.test(value)
  };

  const errorMessages = {
    name: "Venue name must be between 5–100 characters.",
    capacity: "Capacity must be between 10 and allocated venue capacity.",
    timeslot: "Please select a time slot.",
    decoration: "Decoration details must be 5–100 characters.",
    stage: "Stage details must be 5–100 characters.",
    flowers: "Flower details must be 5–100 characters.",
    imageFile: "Please upload a venue image.",
    email: "Enter valid email (e.g., test123@gmail.com).",
    mobile: "Mobile must be 11 digits starting with 03."
  };

  function validateField(field) {
    const value = field.value.trim();
    const isValid = validators[field.id](value);
    const errorSpan = document.getElementById(field.id + "Error");

    console.log("Validating field:", field.id, "Value:", field.value);

if (!isValid) {
  field.classList.add("error");
  field.classList.remove("success");
  errorSpan.textContent = errorMessages[field.id];
  errorSpan.style.display = "block"; // show
} else {
  field.classList.remove("error");
  field.classList.add("success");
  errorSpan.textContent = "";
  errorSpan.style.display = "none"; // hide
}

    console.log("Is valid?", isValid);
    return isValid;
  }

  // Live validation
  Object.keys(validators).forEach(id => {
    const field = document.getElementById(id);
    if (field) {
      field.addEventListener("input", () => validateField(field));
      field.addEventListener("blur", () => validateField(field));
    }
  });

  // Final form check
  form.addEventListener("submit", (e) => {
  console.log("FORM SUBMIT TRIGGERED");
    let valid = true;
    Object.keys(validators).forEach(id => {
    console.log("Checking field:", id);
      const field = document.getElementById(id);
      if (field && !validateField(field)) {
        valid = false;
      }
    });
    console.log("Final valid status in form submit:", valid);
    document.querySelector("button[type='submit']").disabled = !valid;

      if (!valid) {
        e.preventDefault();
        console.log("🚫 Form blocked due to validation errors");
        Swal.fire({
            icon: 'error',
              title: 'Error obtaining the selectedVenue from sessionStorage.',
              text: 'Plz try again later.',
              confirmButtonText: 'OK'
            }).then(() => {
                  window.location.reload();
              });
        return;
      }
      e.preventDefault(); // prevent default submit anyway
      confirmBooking();   // ✅ call only when valid
  });
});
