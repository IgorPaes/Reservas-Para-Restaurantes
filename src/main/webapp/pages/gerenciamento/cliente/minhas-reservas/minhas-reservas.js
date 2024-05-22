function deletarLinha() {
    
    let btn = document.querySelector('.btnCancelar')
    let parentElement = btn.closest('.list_item');
    
    if (parentElement) {
        parentElement.remove();
    } else {
        console.log('Não encontrado');
    }

}