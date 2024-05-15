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

        if (emailRegex.test(emailValue)) {
            document.getElementById('input_email').style.borderColor = "green";
            verificacoes.push(true);
        } else {
            document.getElementById('input_email').style.borderColor = "red";
        }
    }


function cpfValidate() {
    let cpfValue = document.getElementById('input_cpf').value;

    if (cpfValue.trim().length === 0 ){
        document.getElementById('input_cpf').style.borderColor = "";
    }else if (cpfValue.length <= 11) {
        cpfValue = cpfValue.replace(cpfRegex, "$1.$2.$3-$4");
        document.getElementById('input_cpf').value = cpfValue;
    }else if (cpfRegex.test(cpfValue) && cpfValue.length === 14) {
        document.getElementById('input_cpf').style.borderColor = "green";
        verificacoes.push(true);
    }else {
        document.getElementById('input_cpf').style.borderColor = "red";
    }
}

function telefoneValidate() {
    let telefoneValue = document.getElementById('input_telefone').value.replace(/\D/g, '');

    let telefoneFormatado = telefoneValue.replace(telefoneRegex, "($1)$2-$3");
    telefoneValue = telefoneFormatado;

    if(telefoneFormatado.length === 0){
         document.getElementById('input_telefone').style.borderColor= "";
    }else if (telefoneFormatado === campos[3].value && telefoneValue.length === 11) {
       document.getElementById('input_telefone').style.borderColor = "green";
        verificacoes.push(true);
    }else {
        document.getElementById('input_telefone').style.borderColor = "red";
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
