// Remove o cookie 'isValid' quando fechamos a pagina home
window.addEventListener('beforeunload', function(event) {
    // Remove o cookie 'isValid'
    document.cookie = 'isValid=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
    window.location.href='/pages/reservas/reservas.html'
});

function userOnline(){
    if (document.cookie.includes('isValid=true')){
        console.log('O Cliente está logado');
        window.location.href='/pages/reservas/reservas.html'
    } else {
        console.log('Cliente não está logado');
        
    }
}


