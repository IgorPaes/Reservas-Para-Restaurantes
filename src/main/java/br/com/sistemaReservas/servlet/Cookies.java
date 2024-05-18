package br.com.sistemaReservas.servlet;

import br.com.sistemaReservas.dao.Conexao;
import br.com.sistemaReservas.model.User;
import br.com.sistemaReservas.service.UserService;
import br.com.sistemaReservas.utils.CookiesUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

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

@Slf4j
@WebServlet("/infosUser")
public class Cookies extends HttpServlet {

    private static final int OK = 200;
    private static final String CONTENT_TYPE = "application/json";
    private static final String UTF_8 = "UTF-8";
    private static final int NOT_FOUND = 404;
    private final UserService userService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Cookies() {
        this.userService = UserService.getInstance();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Pegando Email do cookies
        String email = CookiesUtils.getEmailFromCookie(request);

        User user = userService.getByEmail(email);

        if (user != null) {
            log.info("Usuário já autenticado => {}", user);
            request.setAttribute("NOME", user.getNome());

            response.setStatus(OK);


        } else {
            response.setStatus(NOT_FOUND);
            log.error("Usuário não está autenticado");
        }
    }
}
