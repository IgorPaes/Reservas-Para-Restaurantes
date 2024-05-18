package br.com.sistemaReservas.dao;

import br.com.sistemaReservas.model.User;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class UserDao {
    private static final String NOME = "NOME";
    private static final String CPF = "CPF";
    private static final String EMAIL = "EMAIL";
    private static final String TELEFONE = "TELEFONE";
    private static final String SENHA = "SENHA";

    public static User getByEmail(String email){
        Connection connection = null;
        PreparedStatement comandoSQL = null;
        ResultSet resultSet = null;

        try {
            connection = Conexao.abrirConexao();
            comandoSQL = connection.prepareStatement("SELECT * FROM Clientes WHERE email = ?");
            comandoSQL.setString(1, email);

            resultSet = comandoSQL.executeQuery();

            if (resultSet.next()) {
                log.info("Usuário encontrado");

                return User.builder()
                        .nome(resultSet.getString(NOME))
                        .cpf(resultSet.getString(CPF))
                        .email(resultSet.getString(EMAIL))
                        .telefone(resultSet.getString(TELEFONE))
                        .build();
            }

            return null;
        } catch (ClassNotFoundException | SQLException ex) {
            log.error("ERRO. ", ex);
            return null;
        } finally {
            // Fechar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (comandoSQL != null) comandoSQL.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                log.error("ERRO. ", e);
            }
        }
    }

    public static User login (String email, String password){
        log.info(email);
        log.info(password);
        Connection connection = null;
        PreparedStatement comandoSQL = null;
        ResultSet resultSet = null;
        try {
            connection = Conexao.abrirConexao();
            comandoSQL = connection.prepareStatement("SELECT * FROM Clientes WHERE email = ? AND senha = ?",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            comandoSQL.setString(1, email);
            comandoSQL.setString(2, password);

            //Executando comando
            resultSet = comandoSQL.executeQuery();

            if (resultSet.next()) {
                return User.builder()
                        .nome(resultSet.getString(NOME))
                        .cpf(resultSet.getString(CPF))
                        .email(resultSet.getString(EMAIL))
                        .telefone(resultSet.getString(TELEFONE))
                        .build();
            }

            return null;

        } catch (ClassNotFoundException | SQLException ex) {
            log.error("ERRO. ", ex);
            return null;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                    comandoSQL.close();
                    connection.close();
                } catch (SQLException e) {
                    log.error("ERRO. ", e);
                }
            }
        }
    }
}
