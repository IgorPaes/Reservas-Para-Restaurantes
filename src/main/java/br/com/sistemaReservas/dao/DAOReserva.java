package br.com.sistemaReservas.dao;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemaReservas.model.Reserva;

@Slf4j
public class DAOReserva {

    static Connection connection = null;
    static PreparedStatement comandoSQL = null;
    static ResultSet resultSet = null;

    public static void saveReserve(Reserva reserva) throws SQLException, ClassNotFoundException {
        
        connection = Conexao.abrirConexao();

        try {
            comandoSQL = connection.prepareStatement("INSERT INTO Reservas (IdRestaurante, IdCliente, Data, Horario, QtdPessoas, Comentario, Status) VALUES (?, ?, ?, ?, ?, ?, ?)");
            
            comandoSQL.setLong(1, reserva.getIdRestaurante());
            comandoSQL.setLong(2, reserva.getIdCliente());
            comandoSQL.setDate(3, (Date) reserva.getData());
            comandoSQL.setTime(4, reserva.getHorario());
            comandoSQL.setInt(5, reserva.getQtdPessoas());
            comandoSQL.setString(6, reserva.getComentario());
            comandoSQL.setString(7, String.valueOf(reserva.getStatus()));

            int rowsInserted = comandoSQL.executeUpdate();
            if (rowsInserted > 0) {
                log.info("Reserva inserida com sucesso!");
            }

        }catch (SQLException ex) {
            log.error("Erro ao inserir reserva.", ex);
        } finally {
            // Fechar recursos
            if (resultSet != null) resultSet.close();
            if (comandoSQL != null) comandoSQL.close();
            if (connection != null) connection.close();
        }

    }

    public List<Reserva> capturaReservas() {

        List<Reserva> listaReservas = new ArrayList<>();
        
        try {
            connection = Conexao.abrirConexao();
            comandoSQL = connection.prepareStatement("SELECT * FROM Reservas");
            resultSet = comandoSQL.executeQuery();

            while(resultSet.next()) {
                Reserva reserva = new Reserva(
                    resultSet.getLong("Id"),
                    resultSet.getLong("IdRestaurante"),
                    resultSet.getLong("IdCliente"),
                    resultSet.getDate("Data"),
                    resultSet.getTime("Horario"),
                    resultSet.getByte("QtdPessoas"),
                    resultSet.getString("Comentario"),
                    resultSet.getString("Status").charAt(0)
                );
                listaReservas.add(reserva);
            }

            return listaReservas;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERRO 10");
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (comandoSQL != null) comandoSQL.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("ERRO 20");
            }
        }

        return null;
    }

}
