package br.com.sistemaReservas.servlet;

import br.com.sistemaReservas.dao.DAOReserva;
import br.com.sistemaReservas.model.Reserva;
import br.com.sistemaReservas.utils.CookiesUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/insert-reserve")
public class InsertReserve extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long idRestaurante, idCliente;
        Date dataSQL;
        Time horarioSQL;
        byte qtdPessoas;
        String comentario;

        idCliente = Long.parseLong(CookiesUtils.getIdFromCookie(request));

        idRestaurante = Long.parseLong(request.getParameter("idRestaurante"));

        String stringData = request.getParameter("data");;
        dataSQL = Date.valueOf(LocalDate.parse(stringData, DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        String stringHorario = request.getParameter("horario");
        horarioSQL = Time.valueOf(LocalTime.parse(stringHorario, DateTimeFormatter.ofPattern("HH:mm")));

        qtdPessoas = Byte.parseByte(request.getParameter("qtdPessoas"));
        
        comentario = request.getParameter("comentario");

        Reserva reserva = new Reserva(idRestaurante, idCliente, dataSQL, horarioSQL, qtdPessoas, comentario);

        try {
            DAOReserva.saveReserve(reserva);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    
}
