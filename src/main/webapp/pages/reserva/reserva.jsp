<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt=br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>R&R Reservas</title>
    <script src="/pages/reserva/reserva.js" defer></script>

    <meta http-equiv="cache-control" content="max-age=0" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="pragma" content="no-cache" />

    <link rel="stylesheet" href="/pages/reserva/reserva.css">
    <link rel="stylesheet" href="/geral/geral.css">
</head>
<body>
    <div class="modal_cont" id="notificacao" style="display: none;">
        <div class="notification_bg"></div>
        <div class="notification_modal">
            <div class="notify_title">
                <h2>CONFIRMAÇÃO DA RESERVA</h2>
                <div></div>
            </div>
            <p>Eu <span>Joãozinho</span> confirmo a reserva no restaurante <span>${restaurante.nome}</span> as <span id="hr">...</span> no dia <span id="dt">...</span> para <span id="qp">...</span> pessoa(s).</p>
            <div class="notify_btns">
                <button type="button" onclick="modalManager.fechar()">EDITAR</button>
                <button type="button" onclick="modalManager.confirmar()">CONFIRMAR</button>
            </div>
        </div>
    </div>
    <div class="container_xl" data-bg-url="/assets/ImagensRestaurantes/fundosRestaurantes/${restaurante.img}">
        <figure class="logo" onclick="location.href='/'">
            <img src="../../assets/logo.png" alt="Logo">
        </figure>
        <main class="form_container">
            <div class="title_box">
                <h1>CRIAR RESERVA</h1>
            </div>
            <div class="main_cont">
                <div class="booking_information">
                    <div class="infos_title">
                        <h2>INFORMAÇÕES DA RESERVA</h2>
                        <div></div>
                    </div>
                    <form class="form_reserve" id="userFormReserve" action="/InsertReserve" method="post">
                        <div class="fields_box">
                            <div class="input_block">
                                <label for="data">DATAS <span>*</span></label>
                                <div class="bg_input">
                                    <!-- COLOCAR INPUT CORRETO DE ACORDO COM O FIGMA -->
                                    <input type="date" name="" id="data" onload="limitarAno(this)">
                                </div>
                            </div>
                            <div class="input_block">
                                <span>HORÁRIOS <span>*</span></span>
                                <div class="bg_input">
                                    <!-- COLOCAR INPUT CORRETO DE ACORDO COM O FIGMA -->
                                    <input type="time" id="horario">
                                </div>
                            </div>

                            <div class="input_block">
                                <span>QTD DE PESSOAS <span>*</span></span>
                                <div class="bg_input qtdPessoas">
                                    <div class="extend_btn" onclick="menosUm()">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="18" height="2" viewBox="0 0 18 2" fill="none">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="18" height="2" viewBox="0 0 18 2" fill="none">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="18" height="2" viewBox="0 0 18 2" fill="none">
                                            <path d="M18 2H0V0H18V2Z" fill="#110F19"/>
                                        </svg>
                                    </div>
                                    <span id="qtdPessoas">1</span>
                                    <div class="extend_btn" onclick="maisUm()">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 18 18" fill="none">
                                            <path d="M17.7891 9C17.7891 9.27972 17.6779 9.54798 17.4802 9.74578C17.2824 9.94357 17.0141 10.0547 16.7344 10.0547H10.0547V16.7344C10.0547 17.0141 9.94357 17.2824 9.74578 17.4802C9.54798 17.6779 9.27972 17.7891 9 17.7891C8.72028 17.7891 8.45202 17.6779 8.25422 17.4802C8.05643 17.2824 7.94531 17.0141 7.94531 16.7344V10.0547H1.26562C0.985904 10.0547 0.717641 9.94357 0.519848 9.74578C0.322056 9.54798 0.210938 9.27972 0.210938 9C0.210938 8.72028 0.322056 8.45202 0.519848 8.25422C0.717641 8.05643 0.985904 7.94531 1.26562 7.94531H7.94531V1.26562C7.94531 0.985904 8.05643 0.717641 8.25422 0.519848C8.45202 0.322056 8.72028 0.210938 9 0.210938C9.27972 0.210938 9.54798 0.322056 9.74578 0.519848C9.94357 0.717641 10.0547 0.985904 10.0547 1.26562V7.94531H16.7344C17.0141 7.94531 17.2824 8.05643 17.4802 8.25422C17.6779 8.45202 17.7891 8.72028 17.7891 9Z" fill="#110F19"/>
                                        </svg>
                                    </div>
                                </div>
                            </div>
                            <div class="input_block">
                                <label for="comentario">COMENTÁRIO</label>
                                <div class="bg_input">
                                    <textarea name="comentario" id="comentario" placeholder="Digite aqui o comentário..." maxlength="480" cols="30" rows="10"></textarea>
                                </div>
                            </div>
                        </div>
                    </form>

                </div>
                <div class="buttons_box">
                    <button type="button" class="btn_cancelar" onclick="location.href='/'">CANCELAR</button>
                    <button type="button" class="btn_confirmar" onclick="confirmarReserva()">CONFIRMAR RESERVA</button>
                </div>
            </div>
        </main>
    </div>
</body>
</html>
