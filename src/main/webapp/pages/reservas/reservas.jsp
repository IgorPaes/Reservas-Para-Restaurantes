<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt=br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>R&R Reservas</title>

    <link rel="stylesheet" href="/pages/reservas/reservas.css">
    <link rel="stylesheet" href="/geral/geral.css">

    <script src="/pages/reservas/script_reserva.js" defer></script>
</head>
<body>
    <div class="container_xl">
        <figure class="logo">
            <img src="../../assets/logo.png" alt="Logo">
        </figure>
        <main class="form_container">
            <div class="title_box">
                <h1>CRIA A SUA RESERVA</h1>
            </div> 
            <div class="main_cont">
                <div class="booking_information">
                    <div class="infos_title">
                        <h2>INFORMAÇÕES DA RESERVA</h2>
                        <div></div>
                    </div>
                    <div class="fields_box">
                        <div class="input_block">
                            <label for="data">DATAS</label>
                            <div class="bg_input">
                                <input type="date" name="" id="data">
                            </div>
                        </div>
                        <div class="input_block">
                            <span>HORÁRIOS</span>
                            <div>
                                
                            </div>
                        </div>
                        <div class="input_block">
                            <label for="qtdPessoas">QTD DE PESSOAS</label>
                            <div class="bg_input">
                                <input type="number" name="" id="qtdPessoas">
                            </div>
                        </div>
                        <div class="input_block">
                            <label for="comentario">COMENTÁRIO</label>
                            <div class="bg_input">
                                <textarea name="" id="comentario" cols="30" rows="10"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div>
                    <button type="button">CANCELAR</button>
                    <button type="button">CONFIRMAR RESERVA</button>
                </div>
            </div>
        </main>
    </div>
</body>
</html>
