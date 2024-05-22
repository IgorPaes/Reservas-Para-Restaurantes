package br.com.sistemaReservas.dao;

import br.com.sistemaReservas.model.User;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class DAOCliente {

    static Connection connection = null;
    static PreparedStatement comandoSQL = null;
    static ResultSet resultSet = null;

    public void saveUser(User user) throws EmailAlreadyInUseException {

        try {
            connection = Conexao.abrirConexao();

            if(isEmailInUse(user.getEmail())){
                throw new EmailAlreadyInUseException("Email já cadastrado. Por favor, utilize outro email");
            }

            PreparedStatement comandoSQL = connection.prepareStatement("INSERT INTO Clientes (nome, cpf, email, telefone, senha) VALUES(?,?,?,?,?)");
            //PreparedStatement.RETURN_GENERATED_KEYS);

            comandoSQL.setString(1, user.getNome());
            comandoSQL.setString(2, user.getCpf());
            comandoSQL.setString(3, user.getEmail());
            comandoSQL.setString(4, user.getTelefone());
            comandoSQL.setString(5, user.getSenha());

            comandoSQL.executeUpdate();
            connection.close();
        } catch (ClassNotFoundException ex ) {
            System.out.println("ERRO!");
        } catch (SQLException ex) {
            System.out.println("ERRO!");
        }

    }

    public class EmailAlreadyInUseException extends Exception {
        public EmailAlreadyInUseException(String message) {
            super(message);
        }
    }

    private boolean isEmailInUse(String email)throws SQLException {

        try {
            PreparedStatement comandoSQL = connection.prepareStatement("SELECT count(*) from Clientes where email = ?");
            comandoSQL.setString(1, email);
            resultSet = comandoSQL.executeQuery();

            if (resultSet.next()){
                int count = resultSet.getInt(1);
                return count > 0; // Se count for maior que zero, significa que o e-mail já está em uso
            }
        }finally{
            if (resultSet != null){
                resultSet.close();
            }
            if (comandoSQL != null){
                comandoSQL.close();
            }
        }

        return false;
    }

    public static long login(String email, String password){

        try {
            connection = Conexao.abrirConexao();
            comandoSQL = connection.prepareStatement("SELECT id FROM Clientes WHERE email = ? AND senha = ?",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            comandoSQL.setString(1, email);
            comandoSQL.setString(2, password);

            //Executando comando
            resultSet = comandoSQL.executeQuery();

            if(resultSet.next()) {
                return (long) resultSet.getInt("id");
            }

            return 0;
        } catch (ClassNotFoundException | SQLException ex) {
            log.error("ERRO. ", ex);
            return 0;
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
