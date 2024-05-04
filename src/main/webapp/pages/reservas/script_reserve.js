const form = document.getElementById('userForm');
const campos = document.querySelectorAll('.form_reserve input');
const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
const nomeRegex = /^[a-zA-Z]{3,}$/;
const cpfRegex = /^(\d{3})\.(\d{3})\.(\d{3})\-(\d{2})$/
const telefoneRegex = /^(\d{2})(\d{5})(\d{4})$/
let verificacoes = []

function submitForm(element) {

    if (botaoVerificar()) {
        const form = document.getElementById(element);
        form.submit();
    } else {
        verificar();
    }
}

function botaoVerificar() {
    return !verificacoes.includes(false);
}

function verificar() {
    for (let i = 0; i < verificacoes.length; i++) {
        if (!verificacoes[i]) { // Não altera a borda do campo de e-mail se a verificação falhar
            campos[i].style.borderColor = "red";
        }
    }
}

function nameValidate() {
    let nomeValue = campos[0].value;
    nomeValue = nomeValue.replace(/[^a-zA-Z\s]+/g, '');

    campos[0].value = nomeValue;

    if (nomeValue.length < 3 || nomeValue.length >= 30) {
        campos[0].style.borderColor = "red";
    } else {
        campos[0].style.borderColor = "green";
        verificacoes.push(true);
    }
}

function emailValidate() {
    let emailValue = document.getElementById('input_email').value;

    console.log(emailValue);
    if (emailRegex.test(emailValue)) {
        document.getElementById('input_email').style.borderColor = "green";
        console.log("E-mail Validado");
        verificacoes.push(true);
    } else {
        document.getElementById('input_email').style.borderColor = "red";
        console.log("E-mail Não Validado");
    }
}

function telefoneValidate() {
    let telefoneValue = campos[1].value.replace(/\D/g, '');

    let telefoneFormatado = telefoneValue.replace(telefoneRegex, "($1)$2-$3");
    campos[1].value = telefoneFormatado;

    if (telefoneFormatado === campos[1].value && telefoneValue.length === 11) {
        campos[1].style.borderColor = "green";
        verificacoes.push(true);
    } else {
        campos[1].style.borderColor = "red";
    }
}

function cpfValidate() {
    let cpfValue = campos[3].value.replace(/\D/g, '');

    if (cpfValue.length <= 11) {
        cpfValue = cpfValue.replace(/^(\d{3})(\d{3})(\d{3})(\d{0,2})$/, "$1.$2.$3-$4");
        campos[3].value = cpfValue;
    }
    if (cpfRegex.test(cpfValue) && cpfValue.length === 14) {
        campos[3].style.borderColor = "green";
        verificacoes.push(true) = true;
    } else {
        campos[3].style.borderColor = "red";
    }
}


