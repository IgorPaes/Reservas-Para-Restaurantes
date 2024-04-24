package br.com.sistemaReservas.servlet;

import br.com.sistemaReservas.dao.SaveUser;
import br.com.sistemaReservas.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-user")
public class CreateUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String userName = request.getParameter("nome");
        String userEmail = request.getParameter("email");
        String userCpf = request.getParameter("cpf");
        String userTelefone = request.getParameter("telefone");
        String userSenha = request.getParameter("senha");

        SaveUser saveUser = new SaveUser();
        saveUser.save(new User(userName, userEmail, userCpf, userTelefone, userSenha));

        request.getRequestDispatcher("pages/reservas/reservas.html").forward(request, resp);
        //.forward(request, resp)

    }

}
