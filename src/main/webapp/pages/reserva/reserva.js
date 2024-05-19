function limitarAno(input) {
    const inputValue = input.value;
    if(inputValue.length > 10) {
        input.value = inputValue.slice(0, 10);
    }
}

let txtQtdPessoas = document.getElementById('qtdPessoas');
let QtdPessoas = parseInt(txtQtdPessoas.textContent);
function menosUm() {
    if(QtdPessoas > 0) {
        txtQtdPessoas.textContent = --QtdPessoas;
    }
}

function maisUm() {
    if(QtdPessoas < 15) {
        txtQtdPessoas.textContent = ++QtdPessoas;
    }
}

const modalBox = document.querySelector('.modal_cont')
const modalManager = {
    abrir: () => {
        modalBox.style.display = 'flex';
    },
    fechar: () => {
        modalBox.style.display = 'none';
    }
}

function insertReserve() {
    var data = document.getElementById("data").value;
    var horario = document.getElementById("hours").value;
    var qtdPessoas = document.getElementById("qtdPessoas").textContent;
    var comentarios = document.getElementById("comentario").value;

    fetch('/InsertReserve', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: 'data=' + encodeURIComponent(data) +
              '&horario=' + encodeURIComponent(horario) +
              '&qtdPessoas=' + encodeURIComponent(qtdPessoas) +
              '&comentario=' + encodeURIComponent(comentarios)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao inserir reserva');
        }
        console.log('Reserva inserida com sucesso!');
    })
    .catch(error => {
        console.error('Erro:', error);
    });
}
