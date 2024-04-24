const form = document.getElementById('userForm');
const campos = document.querySelectorAll('.form_lr input');
const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
const nomeRegex = /^[a-zA-Z]{3,}$/;
const cpfRegex = /^(\d{3})\.(\d{3})\.(\d{3})\-(\d{2})$/
const telefoneRegex = /^\d{2}\s\d{4,5}-\d{4}$/
let verificacoes = [false, false, false, false, false, false]

function submitForm(element) {
    if(botaoVerificar()) {
        const form = document.getElementById(element);
        form.submit();
    }
    else{
        verificar()
    }
}


function verificar(){
        for(let i = 0; i < verificacoes.length; i++){
           if(!verificacoes[i]){
                campos[i].style.borderColor = "red"
            }
        }
}

function nameValidate (){
    if(campos[0].value.length < 3 || !nomeRegex.test(campos[0].value)){
        campos[0].style.borderColor = "red";
        console.log("O nome deve ter 3 caracteres");
    }else{
        campos[0].style.borderColor = "green";
        console.log("Nome Validado");
        verificacoes[0] = true;
    }
}

function emailValidate(){

    if(emailRegex.test(campos[1].value)){
        campos[1].style.borderColor = "green";
        console.log("E-mail Validado");
        verificacoes[1] = true;

    }else{
        campos[1].style.borderColor = "red";
        console.log("E-mail Não Validado");
    }
}

function cpfValidate(){
    campos[2].value = campos[2].value.replace(/^(\d{3})(\d{3})(\d{3})(\d{2})$/, "$1.$2.$3-$4");
    if(cpfRegex.test(campos[2].value)){
        campos[2].style.borderColor = "green";
        console.log("CPF Validado");
        verificacoes[2] = true;

    }else{
        campos[2].style.borderColor = "red";
        console.log("CPF Não Validado");
    }
}

function telefoneValidate(){

    if(telefoneRegex.test(campos[3].value)){
        campos[3].style.borderColor = "green";
        console.log("Telefone Validado");
        verificacoes[3] = true;

    }else{
        campos[3].style.borderColor = "red";
        console.log("Telefone Não Validado");
    }
}

function senhaValidate(){

    const confirmarSenha = campos[4].value === campos[5].value ? true:false
    if(confirmarSenha){
        campos[4].style.borderColor = "green";
        campos[5].style.borderColor = "green";
        console.log("Senha Correta")
        verificacoes[4] = true;
        verificacoes[5] = true;
    }
    else{
        campos[4].style.borderColor = "red";
        campos[5].style.borderColor = "red";
        console.log("Senha Incorreta")
    }
    return confirmarSenha;
}

function botaoVerificar(){
    return !verificacoes.includes(false);
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