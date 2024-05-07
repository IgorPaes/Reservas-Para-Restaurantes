<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../general/style.css">
    <link rel="stylesheet" href="minhas-reservas.css">
    <title>Minhas Reservas</title>
</head>
<body>

    <header class="cabecalho">
        <figure class="logo">
            <img src="../../assets/logo.png" alt="Logo">
        </figure>
        <nav class="botoes_nav">
            <a href="minhas-reservas.jsp" class="botao_ativo">Minhas Reservas</a>
            <a href="historico-reservas.jsp">Histórico de reservas</a>
        </nav>
        <div class="bloco_usuario">
            <span>Carlos Henrique</span>
            <figure class="icone_usuario">
                <img src="" alt="">
            </figure>
        </div>

    </header>

    <section class="tabela_minhas_reservas">
        <table>
            <thead>
                <tr>
                    <th> ID <img src="../../assets/Arrow_branco.png" class="arrow"></th>
                    <th> Restaurante </th>
                    <th> Data <img src="../../assets/Arrow_branco.png" class="arrow"></th>
                    <th> Horário </th>
                    <th> Pessoas </th>
                </tr>
            </thead>
        </table>
    </section>
    

</body>
</html>


