
if(getCookieValue("cpf")) {
    document.getElementById('btnEntrar').style.display = 'none';
    document.getElementById('btnSair').style.display = 'block';
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
    const listaInfosCookies = ['cpf', 'email', 'nome', 'telefone'];
    listaInfosCookies.forEach((name) => {
        document.cookie = name + '=; Max-Age=-99999999; path=/';
    });
    document.getElementById('btnEntrar').style.display = 'block';
    document.getElementById('btnSair').style.display = 'none';
}