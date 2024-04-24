function submitForm() {
    if(validaInputs()) {
        const form = document.getElementById("userForm");
        form.submit();
    }
}

function validaInputs() {

    const form = document.getElementByID('userForm');
    const campos = document.querySelectorAll('.form_lr');
    cont spans =

}



function togglePasswordVisibility(inputId, toggleIcon) {
    var input = document.getElementById(inputId);
    if (input.type === "password") {
        input.type = "text";
        toggleIcon.src = "../../assets/olho.png";
    } else {
        input.type = "password";
        toggleIcon.src = "../../assets/olho.png";
    }
}