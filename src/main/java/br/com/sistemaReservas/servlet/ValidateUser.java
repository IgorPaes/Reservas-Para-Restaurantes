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
    
    // private final UserService userService;
    // private final ObjectMapper objectMapper = new ObjectMapper();

    // public ValidateUser() {
    //     this.userService = UserService.getInstance();
    // }

    // protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

    //     String userEmail = request.getParameter("email");
    //     String userSenha = request.getParameter("senha");

    //     User user = userService.login(userEmail, userSenha);
    //     if (user != null) {

    //         Cookie emailCookie = new Cookie("email", userEmail);
    //         Cookie nomeCookie = new Cookie("nome", user.getNome());
    //         Cookie telefoneCookie = new Cookie("telefone", user.getTelefone());
    //         Cookie cpf = new Cookie("cpf", user.getCpf());
    //         resp.addCookie(emailCookie);
    //         resp.addCookie(nomeCookie);
    //         resp.addCookie(telefoneCookie);
    //         resp.addCookie(cpf);

    //         resp.sendRedirect("/");
    //         // request.getRequestDispatcher("/pages/home/home.jsp").forward(request, resp);
    //     } else {
    //         resp.getWriter().println("<script>alert('Credenciais inválidas. Por favor, tente novamente.'); window.location.href='/pages/login-register/login.html';</script>");
    //     }
    // }
    
}