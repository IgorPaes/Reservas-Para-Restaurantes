const form = document.getElementById('userForm');
const campos = document.querySelectorAll('.form_lr input');
const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
const nomeRegex = /^[a-zA-Z]{3,}$/;
const cpfRegex = /^(\d{3})\.(\d{3})\.(\d{3})\-(\d{2})$/
const telefoneRegex = /^(\d{2})(\d{5})(\d{4})$/
let verificacoes = [false, false, false, false, false, false]

function submitForm(element) {
    if (botaoVerificar()) {
        const form = document.getElementById(element);
        form.submit();
    } else {
        verificar()
    }
}

function verificar() {
    for (let i = 0; i < verificacoes.length; i++) {
        if (!verificacoes[i]) {
            campos[i].style.borderColor = "red"
        }
    }
}

function nameValidate() {

    if (campos[0].value.length < 3 || campos[0].value.length >= 30) {
        campos[0].style.borderColor = "red";
        console.log("O nome deve ter 3 caracteres");

    } else {
        campos[0].style.borderColor = "green";
        console.log("Nome Validado");
        verificacoes[0] = true;
    }
}

function emailValidate() {
    if (emailRegex.test(campos[1].value)) {
        campos[1].style.borderColor = "green";
        console.log("E-mail Validado");
        verificacoes[1] = true;

    } else {
        campos[1].style.borderColor = "red";
        console.log("E-mail Não Validado");
    }
}

function cpfValidate() {
    let cpfValue = campos[2].value.replace(/\D/g, '');

    if (cpfValue.length <= 11) {
        cpfValue = cpfValue.replace(/^(\d{3})(\d{3})(\d{3})(\d{0,2})$/, "$1.$2.$3-$4");
        campos[2].value = cpfValue;
    }
    if (cpfRegex.test(cpfValue) && cpfValue.length === 14) {
        campos[2].style.borderColor = "green";
        verificacoes[2] = true;
    } else {
        campos[2].style.borderColor = "red";
    }
}

function telefoneValidate() {
    let telefoneValue = campos[3].value.replace(/\D/g, '');

    let telefoneFormatado = telefoneValue.replace(telefoneRegex, "($1)$2-$3");
    campos[3].value = telefoneFormatado;

    if (telefoneFormatado === campos[3].value && telefoneValue.length === 11) {
        campos[3].style.borderColor = "green";
        verificacoes[3] = true;
    } else {
        campos[3].style.borderColor = "red";
    }
}

function senhaValidate() {

    const confirmarSenha = campos[4].value === campos[5].value ? true : false
    //&& campos[4].value.length >= 6 && campos[4].value.length <= 20 && campos[5].value.length >= 6 && campos[5].value.length <= 20
    if (campos[4].value.length <= 6 && campos[4].value.length <= 20 && !confirmarSenha) {
        campos[4].style.borderColor = "red";

    }
    if (campos[5].value.length <= 6 && campos[5].value.length <= 20 && !confirmarSenha) {
        campos[5].style.borderColor = "red";

    }
    if (confirmarSenha) {
        campos[4].style.borderColor = "green";
        campos[5].style.borderColor = "green";
        console.log("Senha Correta")
        verificacoes[4] = true;
        verificacoes[5] = true;
    } else {
        console.log("Senha Incorreta")
    }
    return confirmarSenha;
}

function botaoVerificar() {
    return !verificacoes.includes(false);
}

function visualizarSenha(inputId, toggleIcon) {
    var input = document.getElementById(inputId);
    if (input.type === "password") {
        input.type = "text";
        toggleIcon.src = "../../assets/olho.png";
    } else {
        input.type = "password";
        toggleIcon.src = "../../assets/olho.png";
    }
}