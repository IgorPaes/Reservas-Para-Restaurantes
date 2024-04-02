function togglePasswordVisibility(inputId, toggleIconId) {
    var input = document.getElementById(inputId);
    var toggleIcon = document.getElementById(toggleIconId);
    if (input.type === "password") {
        input.type = "text";
        toggleIcon.src = "../../assets/olho.png";
    } else {
        input.type = "password";
        toggleIcon.src = "../../assets/olho.png";
    }
}