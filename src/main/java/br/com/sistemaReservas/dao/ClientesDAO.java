package br.com.sistemaReservas.dao;

import br.com.sistemaReservas.model.Reservas;
import br.com.sistemaReservas.model.Restaurante;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ClientesDAO {
    static Connection connection = null;
    static PreparedStatement comandoSQL = null;
    static ResultSet resultSet = null;

    //Metodo erroneo para resgatar todas as reservas
    /*public List<Reservas> findAllReserves() {
        String SQL = "SELECT Id, RestauranteId, Datas, Horarios, QtdPessoas FROM reservas";

        try {
            connection = Conexao.abrirConexao();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Reservas> reservas = new ArrayList<>();

            while (resultSet.next()) {
                int idReserva = resultSet.getInt("Id");
                int idRestaurante = resultSet.getInt("RestauranteId");
                Date dataReserva = resultSet.getDate("Datas");
                Time horarioReserva = resultSet.getTime("Horarios");
                int quantidadePessoas = resultSet.getInt("QtdPessoas");

                String nomeRestaurante = obterNomeRestaurantePorId(idRestaurante);

                Reservas reserva = new Reservas(idReserva, nomeRestaurante, dataReserva, horarioReserva.toString(), quantidadePessoas);

                reservas.add(reserva);
            }

            System.out.println("Consulta de reservas realizada com sucesso");
            connection.close();

            return reservas;
        } catch (SQLException e) {
            System.out.println("Erro ao consultar reservas no banco de dados: " + e.getMessage());
            return Collections.emptyList();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }*/

    public List<Reservas> findReservesByUserId(String userEmail) throws SQLException, ClassNotFoundException {
        connection = Conexao.abrirConexao();
        try {
            // Obtém o ID do cliente a partir do email
            int clientId = getClientIdByEmail(userEmail);
            if (clientId == -1) {
                log.error("Cliente não encontrado para o email: {}", userEmail);
                return Collections.emptyList();
            }

            // Consulta as reservas associadas ao ID do cliente
            String SQL = "SELECT Id, RestauranteId, Datas, Horarios, QtdPessoas FROM reservas WHERE ClienteId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, clientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Reservas> reservas = new ArrayList<>();

            // Constrói a lista de reservas
            while (resultSet.next()) {
                int idReserva = resultSet.getInt("Id");
                int idRestaurante = resultSet.getInt("RestauranteId");
                Date dataReserva = resultSet.getDate("Datas");
                Time horarioReserva = resultSet.getTime("Horarios");
                int quantidadePessoas = resultSet.getInt("QtdPessoas");

                String nomeRestaurante = obterNomeRestaurantePorId(idRestaurante);

                Reservas reserva = new Reservas(idReserva, nomeRestaurante, dataReserva, horarioReserva.toString(), quantidadePessoas);

                reservas.add(reserva);
            }

            log.info("Consulta de reservas realizada com sucesso para o usuário: {}", userEmail);
            return reservas;
        } catch (SQLException e) {
            log.error("Erro ao consultar reservas no banco de dados para o usuário {}: {}", userEmail, e.getMessage());
            return Collections.emptyList();
        }
    }

    private int getClientIdByEmail(String email) throws SQLException {
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

    private String obterNomeRestaurantePorId(int idRestaurante) throws SQLException {
        String nomeRestaurante = null;
        String SQL = "SELECT nome_restaurante FROM restaurantes WHERE Id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1, idRestaurante);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            nomeRestaurante = resultSet.getString("nome_restaurante");
        }

        return nomeRestaurante;
    }
    /*private Restaurante obterRestaurantePorId(int idRestaurante) throws SQLException {
        String SQL = "SELECT * FROM restaurantes WHERE id_restaurante = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1, idRestaurante);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return new Restaurante(resultSet.getInt("id_restaurante"), resultSet.getString("nome"), resultSet.getString("endereco"), resultSet.getString("cep"), resultSet.getString("telefone"));
        } else {
            return null;
        }
    }*/
}
