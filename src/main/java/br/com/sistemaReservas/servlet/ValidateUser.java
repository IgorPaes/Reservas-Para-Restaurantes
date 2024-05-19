package br.com.sistemaReservas.servlet;

import br.com.sistemaReservas.model.User;
import br.com.sistemaReservas.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/validate-user")
public class ValidateUser extends HttpServlet {

    private final UserService userService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ValidateUser() {
        this.userService = UserService.getInstance();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String userEmail = request.getParameter("email");
        String userSenha = request.getParameter("senha");


        User user = userService.login(userEmail, userSenha);
        if (user != null) {

            Cookie emailCookie = new Cookie("email", userEmail);
            Cookie nomeCookie = new Cookie("nome", user.getNome());
            Cookie telefoneCookie = new Cookie("telefone", user.getTelefone());
            Cookie cpf = new Cookie("cpf", user.getCpf());
            resp.addCookie(emailCookie);
            resp.addCookie(nomeCookie);
            resp.addCookie(telefoneCookie);
            resp.addCookie(cpf);
            // resp.sendRedirect("index.html");

            request.getRequestDispatcher("/pages/home/home.jsp").forward(request, resp);
        } else {
            // request.setAttribute("errorMessage","Credenciais invalidas. Tente novamente.");
            // System.out.println("Credenciais invalidas");
            // Alert na tela.
            resp.getWriter().println("<script>alert('Credenciais inválidas. Por favor, tente novamente.'); window.location.href='/pages/login-register/login.html';</script>");
            //esse codigo aqui serve apenas para redirecionar a pagina informada. resp.sendRedirect("/pages/login-register/login.html");
        }
    }
}



