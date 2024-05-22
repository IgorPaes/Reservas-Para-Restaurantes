package br.com.sistemaReservas.servlet;

import br.com.sistemaReservas.dao.DAOCliente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/validate-user")
public class ValidateUser extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String userEmail = request.getParameter("email");
        String userSenha = request.getParameter("senha");

        Long id = DAOCliente.login(userEmail, userSenha);

        if(id != 0) {
            Cookie idCookie = new Cookie("id", String.valueOf(id));
            resp.addCookie(idCookie);
            resp.sendRedirect("/");
        }else {
            resp.getWriter().println("<script>alert('Credenciais inválidas. Por favor, tente novamente.'); window.location.href='/pages/login-register/login.html';</script>");
        }

    }
    
}