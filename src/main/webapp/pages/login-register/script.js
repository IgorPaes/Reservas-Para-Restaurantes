const form = document.getElementById('userForm');
const campos = document.querySelectorAll('.form_lr input');
const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
const nomeRegex = /^[a-zA-Z]{3,}$/;
const cpfRegex = /^(\d{3})\.(\d{3})\.(\d{3})\-(\d{2})$/
const telefoneRegex = /^(\d{2})(\d{5})(\d{4})$/
let verificacoes = []

function submitForm(element) {
    /*console.log("Element recebido:", element); // Imprime o valor de element no console



     Cria um objeto para armazenar os valores do formulário
    const formData = {};

    Itera sobre os elementos do formulário e armazena os valores no objeto formData
    for (const input of form.elements) {
        if (input.name) {
            formData[input.name] = input.value;
        }
    }

    Imprime os valores do formulário no console
    console.log("Valores do formulário:", formData);*/

    if (botaoVerificar()) {
     //Obtém o formulário pelo ID
        const form = document.getElementById(element);
        form.submit();
    } else {
        verificar();
    }
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

function emailValidateLogin() {

        //let emailValue = document.querySelector('#input_email');
        let emailValue = document.getElementById('input_email').value;

        if (emailRegex.test(emailValue)) {
            document.getElementById('input_email').style.borderColor = "green";
            console.log("E-mail Validado");
            verificacoes.push(true);
        } else {
            document.getElementById('input_email').style.borderColor = "red";
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
        verificacoes.push(true);
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
        verificacoes.push(true);
    } else {
        campos[3].style.borderColor = "red";
    }
}

function senhaValidate() {
    const senhaInput = document.getElementById('input_senha').value;
    const confirmarSenhaInput = document.getElementById('input_confirmarSenha').value;

    const confirmarSenha = senhaInput === confirmarSenhaInput;

    if (senhaInput.length < 6 || senhaInput.length > 20 || !confirmarSenha) {
        document.getElementById('input_senha').style.borderColor = "red";
        document.getElementById('input_confirmarSenha').style.borderColor = "red";
    } else {
        document.getElementById('input_senha').style.borderColor = "green";
        document.getElementById('input_confirmarSenha').style.borderColor = "green";
        verificacoes.push(true)
    }

    return confirmarSenha;
}

function senhaValidateLogin() {
    const senhaInput = document.getElementById('input_senha').value;

    if (senhaInput.length < 6 || senhaInput.length > 20) {
        document.getElementById('input_senha').style.borderColor = "red";
    } else {
        document.getElementById('input_senha').style.borderColor = "green";
        verificacoes.push(true)
    }
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
