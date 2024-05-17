const form = document.getElementById('userForm');
const campos = document.querySelectorAll('.form_lr input');
const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
const nomeRegex = /^[a-zA-Z]{3,}$/;
const cpfRegex = /^(\d{3})\.(\d{3})\.(\d{3})\-(\d{2})$/;
const telefoneRegex = /^\(\d{2}\) \d{5}-\d{4}$/;
let verificacoesLogin = [false, false];
let verificacoesRegister = [false, false, false, false, false, false];

function submitForm(element) {
    let vecVerificacoes = converteVecs(element);
    if (verificaInputs(vecVerificacoes)) {
        console.log("Aaaaaaaaaaaaaaaaaaaa");
        const form = document.getElementById(element);
        form.submit();
    } else {
        verificar(vecVerificacoes);
    }
}

function verificar(vecVerificacoes) {
    for (let i = 0; i < vecVerificacoes.length; i++) {
        if (!vecVerificacoes[i]) {
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
    if (nomeValue.length > 3 && nomeValue.length <= 30) {
        nomeInput.style.borderColor = "green";
        verificacoesRegister[0] = true;
    } else {
        nomeInput.style.borderColor = "red";
        verificacoesRegister[0] = false;
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
        verificacoesRegister[1] = true;
    } else {
        document.getElementById('input_email').style.borderColor = "red";
        verificacoesRegister[1] = false;
    }
}

function emailValidateLogin() {
    let emailValue = document.getElementById('input_email').value;

    if (emailValue.length === 0){
        document.getElementById('input_email').style.borderColor = "";
        return;
    }

    if (emailRegex.test(emailValue)) {
        document.getElementById('input_email').style.borderColor = "green";
        verificacoesLogin[0] = true;
    } else {
        document.getElementById('input_email').style.borderColor = "red";
        verificacoesLogin[0] = false;
    }
}

function cpfValidate() {
    let cpfInput = document.getElementById('input_cpf');
    let cpfValue = cpfInput.value;

    // Remove todos os caracteres não numéricos
    cpfValue = cpfValue.replace(/\D/g, '');

    if (cpfValue.length === 0 || !/\d/.test(cpfInput.value.slice(-1))) {
        cpfInput.value = cpfInput.value.slice(0, -1);
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
        verificacoesRegister[2] = true;
    } else {
        cpfInput.style.borderColor = "red";
        verificacoesRegister[2] = false;
    }
}

function telefoneValidate() {
    let telefoneInput = document.getElementById('input_telefone');
    let telefoneValue = telefoneInput.value;
    let telefoneFormatado = telefoneValue.replace(/^(\d{2})(\d{5})(\d{4})$/, "($1) $2-$3");

    if (telefoneValue === '' || !/\d/.test(telefoneInput.value.slice(-1))) {
        telefoneInput.value = telefoneInput.value.slice(0, -1)
        telefoneInput.style.borderColor = "";
        return;
    }

    if (telefoneRegex.test(telefoneFormatado)) {
        telefoneInput.value = telefoneFormatado;
        telefoneInput.style.borderColor = "green";
        verificacoesRegister[3] = true;
    } else {
        telefoneInput.style.borderColor = "red";
        verificacoesRegister[3] = false;
    }
}

function campoSenha() {
    const senhaInput = document.getElementById('input_senha').value;
    if(senhaInput.length === 0) {
        campoConfirmaSenha();
        document.getElementById('input_senha').style.borderColor= "";
    }else if (senhaInput.length < 6 || senhaInput.length > 20) {
        document.getElementById('input_senha').style.borderColor = "red";
        verificacoesRegister[4] = false;
    }else {
        document.getElementById('input_senha').style.borderColor = "green";
        verificacoesRegister[4] = true;
    }
    const inputConfirmarSenha = document.getElementById('input_confirmarSenha');
    if(senhaInput.length >= 6 && inputConfirmarSenha.value.trim() != 0) {
        campoConfirmaSenha();
    }
}

function campoConfirmaSenha() {
    const confirmaSenhaInput = document.getElementById('input_confirmarSenha').value;
    const senhaInput = document.getElementById('input_senha').value;

    if(confirmaSenhaInput.length === 0 && senhaInput.length === 0){
        document.getElementById('input_confirmarSenha').style.borderColor = "";
    }else if (confirmaSenhaInput !== senhaInput) {
        document.getElementById('input_confirmarSenha').style.borderColor = "red";
        verificacoesRegister[5] = false;
    }else if (senhaInput === confirmaSenhaInput)  {
        document.getElementById('input_confirmarSenha').style.borderColor = "green";
        verificacoesRegister[5] = true;
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
        verificacoesLogin[1] = false;
    }else {
        document.getElementById('input_senha').style.borderColor = "green";
        verificacoesLogin[1] = true;
    }
}

function verificaInputs(vecVerificacoes) {
    return !vecVerificacoes.includes(false);
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

function converteVecs(screen) {
    return verificacoes = (screen == "userFormRegister") ? verificacoesRegister : verificacoesLogin;
}