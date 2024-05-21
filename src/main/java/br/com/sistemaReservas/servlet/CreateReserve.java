package br.com.sistemaReservas.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaReservas.dao.DAORestaurante;
import br.com.sistemaReservas.model.Restaurante;

import java.io.IOException;

@WebServlet("/create-reserve/*")
public class CreateReserve extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            
            response.sendRedirect("/pages/reserva/reserva.jsp");
            String IdReserva = pathInfo.substring(1); // Remove a barra inicial
            Restaurante restaurante = new DAORestaurante().buscaRestauranteID(IdReserva);
            request.setAttribute("restaurantes", restaurante);

        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
