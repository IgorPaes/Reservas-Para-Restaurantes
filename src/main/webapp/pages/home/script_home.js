//// Remove o cookie 'isValid' quando fechamos a pagina home
//window.addEventListener('beforeunload', function() {
//    // Remove o cookie 'isValid'
//    document.cookie = 'isValid=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
//    window.location.href='/pages/reservas/reservas.html';
//});

function userOnline(){
    if (document.cookie.includes('user')){
        window.location.href='/pages/reservas/reservas.html'
    } else {
        console.log('Cliente não está logado');

    }
}

