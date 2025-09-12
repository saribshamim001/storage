document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("venueForm");

  const validators = {
    name: value => value.length >= 5 && value.length <= 100,
    capacity: value => value >= 10 && value <= 5000,
    timeslot: value => value !== "",
    decoration: value => value.length >= 5 && value.length <= 100,
    stage: value => value.length >= 5 && value.length <= 100,
    flowers: value => value.length >= 5 && value.length <= 100,
    imageFile: value => value !== ""
  };

  const errorMessages = {
    name: "Venue name must be between 5–100 characters.",
    capacity: "Capacity must be between 10 and 5000.",
    timeslot: "Please select a time slot.",
    decoration: "Decoration details must be 5–100 characters.",
    stage: "Stage details must be 5–100 characters.",
    flowers: "Flower details must be 5–100 characters.",
    imageFile: "Please upload a venue image."
  };

  function validateField(field) {
    const value = field.value.trim();
    const isValid = validators[field.id](value);
    const errorSpan = document.getElementById(field.id + "Error");

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
    let valid = true;
    Object.keys(validators).forEach(id => {
      const field = document.getElementById(id);
      if (field && !validateField(field)) {
        valid = false;
      }
    });
    if (!valid) e.preventDefault();
  });
});
