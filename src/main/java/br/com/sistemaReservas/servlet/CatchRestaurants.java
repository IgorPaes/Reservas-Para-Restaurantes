package br.com.sistemaReservas.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemaReservas.dao.DAORestaurante;
import br.com.sistemaReservas.model.Restaurante;

@WebServlet("")
public class CatchRestaurants extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DAORestaurante daoRestaurante = new DAORestaurante();
        List<Restaurante> restaurantes = daoRestaurante.capturaRestaurantes();

        if (restaurantes != null) {            
            // Adicionar a lista de restaurantes ao request
            request.setAttribute("restaurantes", restaurantes);
            // Encaminhar a requisição para home.jsp
            request.getRequestDispatcher("/pages/home/home.jsp").forward(request, response);
        }else {
            System.out.println("Nenhum restaurante foi registrado!");
        }

    }

}