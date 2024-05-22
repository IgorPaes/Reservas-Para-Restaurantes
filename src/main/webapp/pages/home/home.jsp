<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>R&R Reserva De Restaurante</title>

    <script src="/pages/home/home.js" defer></script>

    <meta http-equiv="cache-control" content="max-age=0" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
    <meta http-equiv="pragma" content="no-cache" />

    <link rel="stylesheet" href="/geral/geral.css">
    <link rel="stylesheet" href="/pages/home/home.css">
</head>
<body>
    <header class="cabecalho">
        <nav class="navegacao">
            <figure class="logo">
                <img src="/assets/logo.png" alt="">
            </figure>
            <div class="botoes_nav">
                <button type="button" onclick="scrollParaSecao('secao2')">Restaurantes</button>
                <button type="button" onclick="scrollParaSecao('secao3')">Clientes</button>
            </div>
            <div class="btn_entrar">
                <button type="button" id="btnEntrar" onclick="btnEntrar()">Entrar</button>
                <button type="button" id="btnSair" onclick="limparLogin()" class="log_out" style="display: none;">Sair</button>
            </div>
        </nav>
    </header>
    <main>
        <section class="caixa_primaria" id="secao1">
            <div class="informacao_principal">
                <h1 class="titulo_principal_reserva">Faça a sua reserva em seus restaurantes favoritos em um único lugar.</h1>
                <p class="paragrafo_principal">O R&R oferece recursos adicionais, como avaliações detalhadas, menus atualizados e até mesmo sugestões personalizadas com base no histórico de preferências dos usuários. Com essa ferramenta, desfrutar de uma refeição memorável nos restaurantes favoritos nunca foi tão fácil e conveniente.</p>
            </div>
            <figure class="img_celular">
                <img src="/assets/celular.png" alt="Imagem da seção principal">
            </figure>
        </section>
        <section class="tela_resturantes" id="secao2">
            <nav class="bloco_navegacao">
                <div class="bloco_pesquisa">
                    <input type="text" placeholder="Encontre seu restaurante...">
                    <button>
                        <svg xmlns="http://www.w3.org/2000/svg" width="13" height="13" viewBox="0 0 13 13" fill="none">
                            <path d="M6.38462 10.8662L11 6.4331L6.38462 1.99998M10.359 6.4331L1 6.4331" stroke="white" stroke-width="2" stroke-miterlimit="10" stroke-linecap="square"/>
                        </svg>
                    </button>
                </div>
            </nav>
            <ul class="lista_restaurantes">
                <c:forEach var="restaurante" items="${restaurantes}">
                    <li class="bloco_item" style="background-image: url('/assets/ImagensRestaurantes/fundosRestaurantes/${restaurante.img}');">
                        <div class="conteudo_item">
                            <div class="item_top">
                                <h3>${restaurante.nome}</h3>
                                <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none">
                                    <path d="M11.625 23.25C9.32583 23.25 7.07821 22.5683 5.1665 21.2908C3.25478 20.0135 1.76478 18.1979 0.884906 16.0738C0.00503572 13.9495 -0.225178 11.6121 0.223379 9.35709C0.671923 7.10205 1.7791 5.03068 3.40488 3.40488C5.03068 1.7791 7.10205 0.671923 9.35709 0.223379C11.6121 -0.225178 13.9495 0.00503572 16.0738 0.884906C18.1979 1.76478 20.0135 3.25478 21.2908 5.1665C22.5683 7.07821 23.25 9.32583 23.25 11.625C23.25 14.7082 22.0252 17.665 19.8452 19.8452C17.665 22.0252 14.7082 23.25 11.625 23.25ZM11.625 1.9375C9.70894 1.9375 7.83602 2.50566 6.24292 3.57014C4.64982 4.63461 3.40814 6.14759 2.67492 7.91776C1.9417 9.68789 1.74986 11.6357 2.12364 13.515C2.49744 15.3941 3.42009 17.1203 4.7749 18.4751C6.12973 19.8299 7.85588 20.7526 9.73503 21.1264C11.6143 21.5002 13.5621 21.3084 15.3322 20.5751C17.1024 19.8418 18.6154 18.6001 19.6798 17.0071C20.7443 15.414 21.3125 13.5411 21.3125 11.625C21.3125 9.05574 20.2918 6.59167 18.4751 4.7749C16.6584 2.95815 14.1943 1.9375 11.625 1.9375Z" fill="white" fill-opacity="0.5"/>
                                    <path d="M11.5 12.7917C11.2441 12.7883 10.9996 12.6853 10.8186 12.5043C10.6377 12.3233 10.5346 12.0788 10.5312 11.823V7.30212C10.5312 7.0452 10.6333 6.79879 10.815 6.61711C10.9966 6.43544 11.2431 6.33337 11.5 6.33337C11.7569 6.33337 12.0034 6.43544 12.185 6.61711C12.3667 6.79879 12.4688 7.0452 12.4688 7.30212V11.823C12.4654 12.0788 12.3623 12.3233 12.1814 12.5043C12.0004 12.6853 11.7559 12.7883 11.5 12.7917Z" fill="white" fill-opacity="0.5"/>
                                    <path d="M11.5 16.6667C11.2441 16.6633 10.9996 16.5603 10.8186 16.3793C10.6377 16.1983 10.5346 15.9538 10.5312 15.698V15.0521C10.5312 14.7952 10.6333 14.5488 10.815 14.3672C10.9966 14.1854 11.2431 14.0834 11.5 14.0834C11.7569 14.0834 12.0034 14.1854 12.185 14.3672C12.3667 14.5488 12.4688 14.7952 12.4688 15.0521V15.698C12.4654 15.9538 12.3623 16.1983 12.1814 16.3793C12.0004 16.5603 11.7559 16.6633 11.5 16.6667Z" fill="white" fill-opacity="0.5"/>
                                </svg>
                            </div>
                            <div class="bloco_infos_item">
                                <div class="info_item">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="21" height="22" viewBox="0 0 21 22" fill="none">
                                        <path d="M13.125 18.7844L7.875 16.9469L3.80625 18.5219C3.51458 18.6386 3.24479 18.6059 2.99687 18.4239C2.74896 18.2419 2.625 17.9975 2.625 17.6907V5.44067C2.625 5.25109 2.67983 5.08338 2.7895 4.93755C2.89917 4.79172 3.0485 4.68234 3.2375 4.60942L7.875 3.03442L13.125 4.87192L17.1937 3.29692C17.4854 3.18026 17.7552 3.21322 18.0031 3.3958C18.251 3.57838 18.375 3.82251 18.375 4.12817V16.3782C18.375 16.5678 18.3205 16.7355 18.2114 16.8813C18.1023 17.0271 17.9527 17.1365 17.7625 17.2094L13.125 18.7844ZM12.25 16.6407V6.40317L8.75 5.17817V15.4157L12.25 16.6407Z" fill="white" fill-opacity="0.5"/>
                                    </svg>
                                    <span>${restaurante.endereco} - ${restaurante.cep}</span>
                                </div>
                                <div class="info_item">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="23" height="24" viewBox="0 0 23 24" fill="none">
                                        <path d="M15.8663 12.7778L15.4298 13.2118C15.4298 13.2118 14.3923 14.2434 11.5605 11.4275C8.72861 8.61176 9.76608 7.58018 9.76608 7.58018L10.0409 7.30687C10.7181 6.6336 10.7819 5.55267 10.1911 4.76355L8.9827 3.14933C8.25151 2.17264 6.83862 2.04362 6.00055 2.87693L4.49635 4.37259C4.0808 4.78578 3.80232 5.3214 3.8361 5.91559C3.92249 7.43571 4.61026 10.7064 8.44805 14.5224C12.5178 18.569 16.3365 18.7298 17.8981 18.5843C18.392 18.5383 18.8216 18.2867 19.1677 17.9425L20.5291 16.5889C21.4481 15.6751 21.1889 14.1087 20.0132 13.4695L18.1823 12.4742C17.4102 12.0546 16.4697 12.1778 15.8663 12.7778Z" fill="white" fill-opacity="0.5"/>
                                    </svg>
                                    <span>${restaurante.telefone}</span>
                                </div>
                            </div>
                            <div class="item_baixo">
                                <div class="item_status">
                                    <span class="verde">Aberto</span>
                                    
                                </div>
                                <button type="button" onclick="location.href='/open-reserve/${restaurante.id}'">CRIAR RESERVA</button>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </section>

        <section class="clientes" id="secao3">
            <div class="titulo_restaurantes">
                <h1>ALGUNS DE NOSSOS CLIENTES</h1>
            </div>
            <div class="clientes_restaurantes">
                <img src="/assets/ImagensRestaurantes/logosRestaurantes/outback.png">
                <img src="/assets/ImagensRestaurantes/logosRestaurantes/coco_bambu.png">
                <img src="/assets/ImagensRestaurantes/logosRestaurantes/fogo_de_chao.png">
                <img src="/assets/ImagensRestaurantes/logosRestaurantes/restaurant.png">
            </div>
        </section>

        <section class="conteudo_cadastre" id="secao4">
            <div class="bloco_text">
                <h1>Cadastre o seu restaurante e profissionalize a forma com que gerencia suas reservas.</h1>
                <p>Cadastre o seu restaurante conosco e leve a gestão das suas reservas para um novo patamar de profissionalismo. Com nossa plataforma intuitiva e eficiente, você terá total controle sobre as reservas, podendo gerenciá-las de forma simples e organizada. Aumente a eficiência do seu estabelecimento e proporcione uma experiência ainda melhor para seus clientes, garantindo que cada reserva seja tratada com atenção e cuidado. Junte-se a nós e otimize a operação do seu restaurante hoje mesmo.</p>
            </div>
            <figure class="caixa">
                <img src="/assets/caixa.png" alt="">
            </figure>
        </section>

        <footer class="rodape">
            <div class="conteudo_rodape">
                <img src="/assets/logo.png" alt="">
            </div>
        </footer>
    </main>
</body>

</html>