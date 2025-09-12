window.addEventListener("load", () => {
  console.log("Page fully loaded, hiding loader..."); // ✅ debug
  const loader = document.getElementById("pageLoader");
  if (loader) {
    loader.classList.add("hide");
    setTimeout(() => {
      console.log("Removing loader from DOM..."); // ✅ debug
      loader.remove();
    }, 1200);
  }
});
