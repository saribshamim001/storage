window.addEventListener("load", () => {
  console.log("Page fully loaded, hiding loader..."); // ✅ debug
  const loader = document.getElementById("pageLoader");
  console.log("In page-loader file, Loader element:", loader); // Log the loader value
  if (loader) {
    loader.classList.add("hide");
    setTimeout(() => {
    console.log("Setting loader display to none..."); // ✅ debug
    loader.style.display = "none";
    }, 1200);
  }
});
