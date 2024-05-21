package br.com.sistemaReservas.servlet;

import br.com.sistemaReservas.dao.DAOCliente;
import br.com.sistemaReservas.model.Reserva;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaReservas.utils.CookiesUtils;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@WebServlet("/reserve-list")
public class ReserveList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Recupera o email do usuário armazenado nos cookies
            String userEmail = CookiesUtils.getEmailFromCookie(request);


            if (userEmail != null) {
                // Chama o método findReservesByUserId() do seu DAO para obter a lista de reservas do usuário
                DAOCliente dao = new DAOCliente();
                List<Reserva> reservas = dao.findReservesByUserId(userEmail);

                // Log para registrar a quantidade de reservas recuperadas
                log.info("Total de reservas encontradas para o usuário {}: {}", userEmail, reservas.size());

                // Define a lista de reservas como um atributo da requisição
                request.setAttribute("reservas", reservas);

                // Encaminha a requisição para a página JSP que irá exibir as reservas
                //request.getRequestDispatcher("/pages/gerenciamento/cliente/em-andamento/em-andamento.jsp").forward(request, response);
            } else {
                // O usuário não está logado, redireciona para a página de login
                response.sendRedirect("/pages/login-register/login.html");
            }
        } catch (Exception e) {
            // Log para registrar qualquer exceção que ocorra durante o processamento da requisição
            log.error("Erro ao processar requisição", e);

            // Re-throw the exception to let the servlet container handle it
            throw new ServletException("Erro ao processar requisição", e);
        }

    }

        /*try {
            // Chame o método findAllReserves() do seu DAO para obter a lista de reservas
            ClientesDAO dao = new ClientesDAO();
            List<Reservas> reservas = dao.findAllReserves();

            // Log para registrar a quantidade de reservas recuperadas
            log.info("Total de reservas encontradas: {}", reservas.size());

            // Defina a lista de reservas como um atributo da requisição
            request.setAttribute("reservas", reservas);

            // Encaminhe a requisição para a página JSP que irá exibir as reservas
            log.info("Redirecionando para a página de reservas em andamento");

            request.getRequestDispatcher("/pages/gerenciamento/cliente/em-andamento/em-andamento.jsp").forward(request, response);


        } catch (Exception e) {
            // Log para registrar qualquer exceção que ocorra durante o processamento da requisição
            log.error("Erro ao processar requisição", e);

            // Re-throw the exception to let the servlet container handle it
            throw new ServletException("Erro ao processar requisição", e);
        }*/

}