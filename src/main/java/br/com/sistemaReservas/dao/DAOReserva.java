package br.com.sistemaReservas.dao;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

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

}
