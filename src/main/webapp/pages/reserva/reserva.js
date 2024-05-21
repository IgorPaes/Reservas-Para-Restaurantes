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


function limitarAno(input) {
input.removeAttribute('min');
input.removeAttribute('max');
    const today = new Date();
    const nextYear = new Date();
    nextYear.setFullYear(today.getFullYear() + 1);

    const formatDate = (date) => {
        const day = String(date.getDate()).padStart(2, '0');
        const month = String(date.getMonth() + 1).padStart(2, '0');
        const year = date.getFullYear();
        return `${year}-${month}-${day}`;
    };

    const minDate = formatDate(today);
    const maxDate = formatDate(nextYear);

    input.setAttribute('min', minDate);
    input.setAttribute('max', maxDate);
}

// Garante que os limites sejam configurados quando a página for carregada
document.addEventListener("DOMContentLoaded", function() {
    const dataInput = document.getElementById('data');
    limitarAno(dataInput);
});

/* DESCOMENTE PARA TER O SELECT DE HORÁRIOS
// Função para pegar o horário atual em formato "HH:MM"
function getHorarioAtual() {
    const agora = new Date();
    const hora = agora.getHours().toString().padStart(2, '0');
    const minuto = agora.getMinutes().toString().padStart(2, '0');
    return `${hora}:${minuto}`;
}

// Função para criar um select de horários a partir do horário atual até o final do dia

function criarSelectHorarios() {
    const horarioAtual = getHorarioAtual();
    const selectHorarios = document.createElement('select');
    selectHorarios.name = 'horario';
    selectHorarios.id = 'hours';

    const horaAtual = parseInt(horarioAtual.split(':')[0]);
    const minutosAtual = parseInt(horarioAtual.split(':')[1]);

    for (let hora = horaAtual; hora <= 23; hora++) {
        for (let minuto = 0; minuto <= 45; minuto += 15) {
            if (hora === horaAtual && minuto < minutosAtual) {
                continue; // Pular horários anteriores ao atual
            }

            const option = document.createElement('option');
            const horaFormatada = hora.toString().padStart(2, '0');
            const minutoFormatado = minuto.toString().padStart(2, '0');
            option.text = `${horaFormatada}:${minutoFormatado}`;
            selectHorarios.add(option);
        }
    }

    // Selecionar a div correta usando o seletor de classe
    const bgInputDiv = document.querySelector('.input_block:nth-child(2) .bg_input');
    bgInputDiv.innerHTML = ''; // Limpar qualquer conteúdo existente
    bgInputDiv.appendChild(selectHorarios);
}

// Chamada da função para criar o select de horários
criarSelectHorarios();
*/

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
        window.location.href = '/pages/gerenciamento/cliente/em-andamento/em-andamento.jsp'
    })
    .catch(error => {
        console.error('Erro:', error);
    });
}
