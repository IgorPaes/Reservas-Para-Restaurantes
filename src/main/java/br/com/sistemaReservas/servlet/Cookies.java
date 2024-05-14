package br.com.sistemaReservas.servlet;

import br.com.sistemaReservas.dao.Conexao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/infosUser")
public class Cookies extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException, IOException, IOException {
        // Pegando Email do cookies
        String email = getEmailFromCookie(request);

        boolean userAuthenticated = infos(email, request);

        //Passando os cookies para Json
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"authenticated\": " + userAuthenticated + "}");
    }

    private boolean infos(String email, HttpServletRequest request) {

        Connection connection = null;
        PreparedStatement comandoSQL = null;
        ResultSet resultSet = null;

        try {
            connection = Conexao.abrirConexao();
            comandoSQL = connection.prepareStatement("SELECT * FROM Clientes WHERE email = ?");
            comandoSQL.setString(1, email);

            resultSet = comandoSQL.executeQuery();

            boolean userExists = resultSet.next();

            // Comparando o valor do cookie com o email retornado pela consulta SQL
            if (userExists) {
                System.out.println("Email encontrado no bd");
                return true;
            } else {
                System.out.println("Email não encontrado no bd");
                return false;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            // Fechar recursos
            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (comandoSQL != null) comandoSQL.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    private String getEmailFromCookie(HttpServletRequest request) {
        // Implemente a lógica para extrair o email do cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("email")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
