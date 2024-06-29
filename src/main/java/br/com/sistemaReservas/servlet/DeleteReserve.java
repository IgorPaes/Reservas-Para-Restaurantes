package br.com.sistemaReservas.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaReservas.dao.DAOReserva;

@WebServlet("/deletar-reserva")
public class DeleteReserve extends HttpServlet {
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Long idReserva = Long.parseLong(request.getParameter("id"));

        DAOReserva reserva = new DAOReserva();
        reserva.deletarReserva(idReserva);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        // response.getWriter().write("{\"message\": \"Reserva deletada com sucesso\"}");
        
    }

}
