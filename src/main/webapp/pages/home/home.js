//// Remove o cookie 'isValid' quando fechamos a pagina home
//window.addEventListener('beforeunload', function() {
//    // Remove o cookie 'isValid'
//    document.cookie = 'isValid=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
//    window.location.href='/pages/reservas/reservas.jsp';
//});

//function userOnline(){
//    if (document.cookie.includes('user')){
//        window.location.href='/pages/reservas/reservas.jsp'
//    } else {
//        console.log('Cliente não está logado');
//
//    }
//}

function userOnline() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/infosUser', true);
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var data = JSON.parse(xhr.responseText);
                if (data.authenticated) {
                    window.location.href = '../reservas/reservas.jsp';
                } else {
                    console.log('Cliente não está logado');
                }
            } else {
                console.error('Erro ao verificar autenticação:', xhr.status);
            }
        }
    };
    xhr.send();
}