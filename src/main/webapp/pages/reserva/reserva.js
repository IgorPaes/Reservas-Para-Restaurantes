document.addEventListener('DOMContentLoaded', function() {
    const container = document.querySelector('.container_xl');
    const bgUrl = container.getAttribute('data-bg-url');
    container.style.setProperty('--bg-url', `url(${bgUrl})`);
});

let txtQtdPessoas = document.getElementById('qtdPessoas');
let QtdPessoas = parseInt(txtQtdPessoas.textContent);
function menosUm() {
    if(QtdPessoas > 1) {
        txtQtdPessoas.textContent = --QtdPessoas;
    }
}

function maisUm() {
    if(QtdPessoas < 15) {
        txtQtdPessoas.textContent = ++QtdPessoas;
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


document.addEventListener("DOMContentLoaded", function() {
    const dataInput = document.getElementById('data');
    limitarAno(dataInput);
});



const notificacao = document.getElementById('notificacao');
const modalManager = {
    abrir: (data, horario, qtdPessoas) => {
        document.querySelector('.notification_modal #dt').textContent = data;
        document.querySelector('.notification_modal #hr').textContent = horario
        document.querySelector('.notification_modal #qp').textContent = qtdPessoas;
        notificacao.style.display = 'flex';
    },
    fechar: () => {
        notificacao.style.display = 'none';
    },
    confirmar: () => {
        const path = window.location.pathname;
        let idRestaurante = path.split('/').pop();
        
        const params = new URLSearchParams();
        params.append('idRestaurante', idRestaurante);
        params.append('data', document.getElementById("data").value);
        params.append('horario', document.getElementById("horario").value);
        params.append('qtdPessoas', document.getElementById("qtdPessoas").textContent);
        params.append('comentario', document.getElementById("comentario").value);
        
        fetch('/insert-reserve', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: params.toString()
        }).then(response => {
            if (!response.ok) throw new Error('Erro ao inserir reserva');
            location.href = '/pages/gerenciamento/cliente/minhas-reservas/minhas-reservas.jsp';
        }).catch(error => {
            console.error('Erro:', error);
        });
    }
}

function confirmarReserva() {
    const data = document.getElementById("data").value;
    const horario = document.getElementById("horario").value;
    const qtdPessoas = document.getElementById("qtdPessoas").textContent;

    if(data.trim().length != "" && horario.trim().length != "" && qtdPessoas.trim().length != "") {
        modalManager.abrir(data, horario, qtdPessoas);
    }else {
        alert("Complete os campos para continuar.")
    }
}
