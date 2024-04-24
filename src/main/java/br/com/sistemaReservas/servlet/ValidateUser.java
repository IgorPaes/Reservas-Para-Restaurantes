package br.com.sistemaReservas.servlet;

import br.com.sistemaReservas.dao.CheckUser;
import br.com.sistemaReservas.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ValidateUser {

    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String userName = request.getParameter("nome");
        String userEmail = request.getParameter("email");

        CheckUser checkUser = new CheckUser();
        checkUser.validate(userName, userEmail);
        
//      request.getRequestDispatcher("index.html").forward(request, resp);

    }

}
