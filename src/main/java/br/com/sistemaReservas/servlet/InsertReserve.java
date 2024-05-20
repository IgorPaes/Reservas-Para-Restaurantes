package br.com.sistemaReservas.servlet;

import br.com.sistemaReservas.dao.ReservasDao;
import br.com.sistemaReservas.utils.CookiesUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@WebServlet("/InsertReserve")
public class InsertReserve extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String client = CookiesUtils.getEmailFromCookie(request);
        log.info(client);
        String restaurantName = CookiesUtils.getRestaurantFromCookie(request);
        log.info(restaurantName);

        String dateString = request.getParameter("data");
        log.info(dateString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        log.info(String.valueOf(date));

        int qtaPeople = Integer.parseInt(request.getParameter("qtdPessoas"));
        log.info(String.valueOf(qtaPeople));
        String comments = request.getParameter("comentario");
        log.info(comments);

        String horarioString = request.getParameter("horario");
        log.info(horarioString);
        DateTimeFormatter formatterh = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.parse(horarioString, formatterh);
        log.info(String.valueOf(time));

        try {
            ReservasDao.insertReserve(client, restaurantName, date, time, qtaPeople, comments);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
}
