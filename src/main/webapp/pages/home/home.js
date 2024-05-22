const ID = "id";
if(getCookieValue(ID)) {
    document.getElementById('btnSair').style.display = 'block';
}

function btnEntrar() {
    if(getCookieValue(ID)) {
        location.href = '/pages/gerenciamento/cliente/em-andamento/em-andamento.jsp';
    }else {
        location.href='/pages/login-register/login.html';
    }
}

// function userOnline() {
//     fetch('/infosUser').then(function (res) {
//         console.log(res);
//         if (!res.ok) {
//             throw new Error("Erro na autenticação -> " + res.status);
//         }
//         //Pegando o nome do restaurante e adicionando nos cookies
//         const restaurantElement = document.getElementById('restaurant_Name');
//         if (restaurantElement) {
//             const restaurantName = restaurantElement.textContent;
//             document.cookie = "restaurant_Name=" + encodeURIComponent(restaurantName) + "; path=/";
//         }
//         window.location.href = 'pages/reserva/reserva.jsp';
//     }).catch(erro => console.error(erro));
// }

function scrollParaSecao(id) {
    const secao = document.getElementById(id);
    secao.scrollIntoView({ behavior: 'smooth' });
}

// Cria um padrão de busca para o nome do cookie
function getCookieValue(name) {
    let pattern = new RegExp("(^|;)\\s*" + name + "\\s*=\\s*([^;]+)");
    let match = document.cookie.match(pattern);
    return match ? match[2] : null;
}

function limparLogin() {
    document.cookie = ID + '=; Max-Age=-99999999; path=/';
    document.getElementById('btnSair').style.display = 'none';
}