<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>R&R</title>

    <link rel="stylesheet" href="/pages/gerenciamento/cliente/em-andamento/em-andamento.css">
    <link rel="stylesheet" href="/pages/gerenciamento/cliente/style.css">
    <link rel="stylesheet" href="/geral/geral.css">

    <script src="/pages/gerenciamento/cliente/em-andamento/em-andamento.js"></script>
</head>
<body>
<header class="cabecalho">
    <nav class="navegacao">
        <figure class="logo">
            <img src="/assets/logo.png" alt="">
        </figure>
        <div class="botoes_nav">
            <button type="button" onclick="scrollParaSecao('secao2')">Minhas Reservas</button>
            <button type="button" onclick="scrollParaSecao('secao3')"> Histórico De Reservas</button>
        </div>
        <div class="btn_entrar">
            <button type="button" onclick="location.href='/pages/login-register/login.html'">Entrar</button>
        </div>
    </nav>
</header>
<div class="reservas-container">
    <table id="reservas-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Restaurante</th>
            <th>Data</th>
            <th>Horário</th>
            <th>Pessoas</th>
        </tr>
        </thead>
          <c:forEach var="reserva" items="${reservas}">
              <tr>
                  <td>${reserva.id}</td>
                  <td>${reserva.nomeRestaurante}</td>
                  <td>${reserva.data}</td>
                  <td>${reserva.horario}</td>
                  <td>${reserva.quantidadePessoas}</td>
              </tr>
          </c:forEach>


    </table>


</div>
</body>
</html>