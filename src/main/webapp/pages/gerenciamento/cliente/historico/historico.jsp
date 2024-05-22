<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>R&R</title>

    <link rel="stylesheet" href="/geral/geral.css">
    <link rel="stylesheet" href="/pages/gerenciamento/cliente/historico/historico.css">
    <link rel="stylesheet" href="/pages/gerenciamento/cliente/style.css">
    
    <script src="/pages/gerenciamento/cliente/historico/historico.js"></script>  
</head>
<body>
    <header class="cabecalho">
        <nav class="navegacao">
            <figure class="logo" onclick="location.href='/'">
                <img src="/assets/logo.png" alt="">
            </figure>
            <div class="botoes_nav">
                <button type="button" class="selected_page" onclick="location.href='/minhas-reservas'">Minhas Reservas</button>
                <button type="button">Histórico De Reservas</button>
            </div>
            <div class="user">
                <h1>São Jorge</h1>
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
                <li class="list_item">                     
                    <span><span>#</span>1</span>
                    <span>OUTBACK</span>
                    <span>21/05/2024</span>
                    <span>20:30</span>
                    <span>10</span>
                </li> 
            </ul>
        </div>
    </section>
</body>
</html>