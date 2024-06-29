package br.com.sistemaReservas.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaReservas.dao.DAORestaurante;
import br.com.sistemaReservas.model.Restaurante;

import java.io.IOException;

@WebServlet("/open-reserve/*")
public class OpenReserve extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            String IdReserva = pathInfo.substring(1); // Remove a barra inicial
            Restaurante restaurante = new DAORestaurante().buscaRestauranteID(IdReserva);
            request.setAttribute("restaurante", restaurante);
            request.getRequestDispatcher("/pages/reserva/reserva.jsp").forward(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

    }

}
