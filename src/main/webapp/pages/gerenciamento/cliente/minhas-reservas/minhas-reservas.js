function deletarReserva(btn, idReserva) {
    
    fetch(`/deletar-reserva?id=${idReserva}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ id: idReserva })
    }).then(response => {
        if (!response.ok) throw new Error('Erro na rede: ' + response.statusText);
    }).then(() => {
        let parentElement = btn.closest('.list_item');
        parentElement.remove();
    }).catch(error => {
        console.error('Erro:', error);
    });

}