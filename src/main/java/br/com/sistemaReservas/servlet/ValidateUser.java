package br.com.sistemaReservas.servlet;

import br.com.sistemaReservas.dao.CheckUser;
import br.com.sistemaReservas.model.User;
import com.mysql.cj.conf.PropertyDefinitions;

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

        CheckUser checkUser = new CheckUser();
        //Só pra ver se o retorno do select está correto
        //System.out.println("SELECT email, senha FROM Clientes WHERE email = '" + userEmail + "' AND senha = '" + userSenha + "'");

        boolean isValid = checkUser.validate(userEmail,userSenha);
        if(isValid){

            request.getRequestDispatcher("index.html").forward(request, resp);
        }else{
            // request.setAttribute("errorMessage","Credenciais invalidas. Tente novamente.");
            // System.out.println("Credenciais invalidas");
            // Alert na tela.
            resp.getWriter().println("<script>alert('Credenciais inválidas. Por favor, tente novamente.'); window.location.href='/pages/login-register/login.html';</script>");
            //esse codigo aqui serve apenas para redirecionar a pagina informada. resp.sendRedirect("/pages/login-register/login.html");
        }

      //request.getRequestDispatcher("index.html").forward(request, resp);

    }

}



