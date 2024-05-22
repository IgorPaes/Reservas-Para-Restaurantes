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
        // connection = Conexao.abrirConexao();

        // try {
        //     // Verificar se o email do cliente existe
        //     int clientId = getClientIdByEmail(connection, email);
        //     if (clientId == -1) {
        //         log.error("Cliente não encontrado.");
        //         return;
        //     }

        //     // Verificar se o restaurante existe
        //     int restaurantId = getRestaurantIdByName(connection, nomeRestaurante);
        //     if (restaurantId == -1) {
        //         log.error("Restaurante não encontrado.");
        //         return;
        //     }

        //     // Inserir a reserva
        //     String insertReservaQuery = "INSERT INTO Reservas (IdRestaurante, IdCliente, Data, Horario, QtdPessoas, comentario) VALUES (?, ?, ?, ?, ?, ?)";
        //     comandoSQL = connection.prepareStatement(insertReservaQuery);
            
        //     comandoSQL.setInt(1, restaurantId);
        //     comandoSQL.setInt(2, clientId);
        //     comandoSQL.setDate(3, Date.valueOf(data));
        //     comandoSQL.setTime(4, Time.valueOf(horario));
        //     comandoSQL.setInt(5, qtdPessoas);
        //     comandoSQL.setString(6, comentario);

        //     int rowsInserted = comandoSQL.executeUpdate();
        //     if (rowsInserted > 0) {
        //         log.info("Reserva inserida com sucesso!");
        //     }

        // } catch (SQLException ex) {
        //     log.error("Erro ao inserir reserva.", ex);
        // } finally {
        //     // Fechar recursos
        //     if (resultSet != null) resultSet.close();
        //     if (comandoSQL != null) comandoSQL.close();
        //     if (connection != null) connection.close();
        // }
    }

    private static int getClientIdByEmail(Connection connection, String email) throws SQLException {
        String query = "SELECT Id FROM Clientes WHERE Email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("Id");
                }
            }
        }
        return -1; // Cliente não encontrado
    }

    private static int getRestaurantIdByName(Connection connection, String nomeRestaurante) throws SQLException {
        String query = "SELECT Id FROM Restaurantes WHERE NomeRestaurante = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nomeRestaurante);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("Id");
                }
            }
        }
        return -1; // Restaurante não encontrado
    }
}
