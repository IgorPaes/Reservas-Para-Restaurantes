const form = document.getElementById('userForm');
const campos = document.querySelectorAll('.form_lr input');
const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
const nomeRegex = /^[a-zA-Z]{3,}$/;
const cpfRegex = /^(\d{3})\.(\d{3})\.(\d{3})\-(\d{2})$/;
const telefoneRegex = /^\(\d{2}\) \d{5}-\d{4}$/;
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
    let nomeInput = document.getElementById('input_nome');
    let nomeValue = nomeInput.value;

    // Remove caracteres que não sejam letras ou espaços
    nomeValue = nomeValue.replace(/[^a-zA-Z\s]+/g, '');

    if (nomeValue.length === 0){
        nomeInput.style.borderColor = "";
        return;
        }

    if (nomeValue.length < 3 || nomeValue.length >= 30) {
        nomeInput.style.borderColor = "red";
    } else {
        nomeInput.style.borderColor = "green";
        verificacoes.push(true);
    }
}


function emailValidate() {
    let emailValue = document.getElementById('input_email').value;

    if (emailValue.length === 0){
    document.getElementById('input_email').style.borderColor = "";
    return;
    }

    if (emailRegex.test(emailValue)) {
        document.getElementById('input_email').style.borderColor = "green";
        verificacoes.push(true);
    } else {
        document.getElementById('input_email').style.borderColor = "red";
    }
}

function emailValidateLogin() {

        //let emailValue = document.querySelector('#input_email');
        let emailValue = document.getElementById('input_email').value;

        if (emailValue.length === 0){
            document.getElementById('input_email').style.borderColor = "";
            return;
            }

        if (emailRegex.test(emailValue)) {
            document.getElementById('input_email').style.borderColor = "green";
            verificacoes.push(true);
        } else {
            document.getElementById('input_email').style.borderColor = "red";
        }
    }


function cpfValidate() {
    let cpfInput = document.getElementById('input_cpf');
    let cpfValue = cpfInput.value;

    // Remove todos os caracteres não numéricos
    cpfValue = cpfValue.replace(/\D/g, '');

    // Se o campo estiver vazio, remove a borda colorida
    if (cpfValue.length === 0 || !/\d/.test(cpfInput.value.slice(-1))) {
    cpfInput.value = cpfInput.value.slice(0, -1)
        cpfInput.style.borderColor = "";
        return;
    }

    // Se o CPF tiver menos de 11 dígitos, define a borda como vermelha e retorna
    if (cpfValue.length < 11) {
        cpfInput.style.borderColor = "red";
        return;
    }

    // Se o CPF tiver exatamente 11 dígitos, formata e valida
    cpfValue = cpfValue.replace(/^(\d{3})(\d{3})(\d{3})(\d{2})$/, "$1.$2.$3-$4");

    cpfInput.value = cpfValue;

    if (cpfRegex.test(cpfValue)) {
        cpfInput.style.borderColor = "green";
        verificacoes.push(true);
    } else {
        cpfInput.style.borderColor = "red";
    }
}



function telefoneValidate() {
    let telefoneInput = document.getElementById('input_telefone');
    let telefoneValue = telefoneInput.value;
    let telefoneFormatado = telefoneValue.replace(/^(\d{2})(\d{5})(\d{4})$/, "($1) $2-$3");

    if (telefoneValue === '' || !/\d/.test(telefoneInput.value.slice(-1))) {
    telefoneInput.value = telefoneInput.value.slice(0, -1)
        telefoneInput.style.borderColor = "";
        console.log("primeiro IF");
        return;
    }

    if (telefoneRegex.test(telefoneFormatado)) {
        telefoneInput.value = telefoneFormatado;
        telefoneInput.style.borderColor = "green";
        verificacoes.push(true);
    } else {
        telefoneInput.style.borderColor = "red";
    }
}

function campoSenha() {
    const senhaInput = document.getElementById('input_senha').value;

    //const confirmarSenha = senhaInput === confirmarSenhaInput;

    if(senhaInput.length === 0) {
        document.getElementById('input_senha').style.borderColor= "";
    }else if (senhaInput.length < 6 || senhaInput.length > 20) {
        document.getElementById('input_senha').style.borderColor = "red";
        verificacoes.push(false)
    }else {
        document.getElementById('input_senha').style.borderColor = "green";
        verificacoes.push(true);
    }
}

function campoConfirmaSenha() {
    const confirmaSenhaInput = document.getElementById('input_confirmarSenha').value;
    const senhaInput = document.getElementById('input_senha').value;

    if(confirmaSenhaInput.length === 0 && senhaInput.length === 0){
        document.getElementById('input_confirmarSenha').style.borderColor = "";
    }else if (confirmaSenhaInput !== senhaInput) {
        document.getElementById('input_confirmarSenha').style.borderColor = "red";
        verificacoes.push(false)
    }else if (senhaInput === confirmaSenhaInput)  {
        document.getElementById('input_confirmarSenha').style.borderColor = "green";
        verificacoes.push(true)
    }
}


function senhaValidateLogin() {
    const senhaInput = document.getElementById('input_senha').value;

    if(senhaInput.length === 0) {
            document.getElementById('input_senha').style.borderColor= "";
            return;
        }
    if (senhaInput.length < 6 || senhaInput.length > 20) {
        document.getElementById('input_senha').style.borderColor = "red";
    }else {
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
