package br.com.sistemaReservas.servlet;

import br.com.sistemaReservas.dao.CheckUser;
import br.com.sistemaReservas.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/validate-user")
public class ValidateUser extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String userEmail = request.getParameter("email");
        String userSenha = request.getParameter("senha");


        CheckUser checkUser = new CheckUser();
        checkUser.validate(userEmail,userSenha);
        
      request.getRequestDispatcher("index.html").forward(request, resp);

    }

}
