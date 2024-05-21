function userOnline() {
    fetch('/infosUser').then(function (res) {
        console.log(res);
        if (!res.ok) {
            throw new Error("Erro na autenticação -> " + res.status);
        }

        //Pegando o nome do restaurante e adicionando nos cookies
        const restaurantElement = document.getElementById('restaurant_Name');
        if (restaurantElement) {
            const restaurantName = restaurantElement.textContent;
            document.cookie = "restaurant_Name=" + encodeURIComponent(restaurantName) + "; path=/";
        }
        window.location.href = 'pages/reserva/reserva.jsp';
    }).catch(erro => console.error(erro));
}

function scrollParaSecao(id) {
    const secao = document.getElementById(id);
    secao.scrollIntoView({ behavior: 'smooth' });
}
