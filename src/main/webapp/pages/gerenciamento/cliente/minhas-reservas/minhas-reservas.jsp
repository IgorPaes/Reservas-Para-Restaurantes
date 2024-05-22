<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>R&R</title>
    
    <link rel="stylesheet" href="/geral/geral.css">
    <link rel="stylesheet" href="/pages/gerenciamento/cliente/minhas-reservas/minhas-reservas.css">
    <link rel="stylesheet" href="/pages/gerenciamento/cliente/style.css">

    <script src="/pages/gerenciamento/cliente/minhas-reservas/minhas-reservas.js"></script>
</head>
<body>
    <header class="cabecalho">
        <nav class="navegacao">
            <figure class="logo" onclick="location.href='/'">
                <img src="/assets/logo.png" alt="">
            </figure>
            <div class="botoes_nav">
                <button type="button" class="selected_page">Minhas Reservas</button>
                <!-- /pages/gerenciamento/cliente/historico/historico.jsp -->
                <button type="button" onclick="location.href='/historico-reservas'">Histórico De Reservas</button>
            </div>
            <div class="user">
                <h1>${reservas[0].idCliente}</h1>
                <img src="/assets/saojorge.jpeg" alt="">
            </div>
        </nav>
    </header>
    <section class="list_section">
        <div class="list_cont">
            <div class="list_titles">
                <span class="arrow id">ID</span>
                <span>Restaurante</span>
                <span class="arrow data">Data</span>
                <span>Horário</span>
                <span>QtdPessoas</span>
            </div>
            <ul class="list_block">
                <c:forEach var="reserva" items="${reservas}">
                    <li class="list_item">
                        <div class="left_box">                        
                            <span><span>#</span>${reserva.id}</span>
                            <span>${reserva.idRestaurante}</span>
                            <span>${reserva.data}</span>
                            <span>${reserva.horario}</span>
                            <span>${reserva.qtdPessoas}</span>
                        </div>
                        <!-- <div class="btns_box">
                            <button type="button" class="btnCancelar">Cancelar Reserva</button>
                            <button type="button" class="btnEditar">
                                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="26" viewBox="0 0 34 35" fill="none">
                                    <path d="M26.8917 3.40918L23.2962 1.12618C22.8603 0.84997 22.3338 0.759933 21.8323 0.875872C21.3308 0.991812 20.8954 1.30423 20.6218 1.74443L19.2034 4.0242L26.0842 8.38734L27.5015 6.10971C28.071 5.192 27.799 3.98449 26.8917 3.40918ZM6.96447 23.7104L13.8431 28.0746L25.0535 10.0446L18.1728 5.6793L6.96341 23.7114L6.96447 23.7104ZM5.91259 29.2552L5.76172 33.3554L9.35297 31.4363L12.6892 29.6567L6.05072 25.4427L5.91259 29.2552Z" fill="white"/>
                                </svg>
                            </button>
                        </div> -->
                    </li> 
                </c:forEach>
            </ul>
        </div>
    </section>
</body>
</html>