package br.com.sistemaReservas.dao;

import br.com.sistemaReservas.model.User;

import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class SaveUser {
    public static Connection connection = null;

    public class EmailAlreadyInUseException extends Exception {
        public EmailAlreadyInUseException(String message) {
            super(message);
        }
    }

    private boolean isEmailInUse(String email)throws SQLException {

        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String query = "Select count(*) from Clientes where email = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1,email);
            resultSet = statement.executeQuery();

            /* result set.next serve para ver se meu select retornou linha, se retornou linha usamos
             resultSet.getInt para atribuir o valor que veio nessa linha e passar pra variavel count */
            if (resultSet.next()){
                int count = resultSet.getInt(1);
                return count > 0; // Se count for maior que zero, significa que o e-mail já está em uso
            }
        }finally{
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
        }

        return false;
    }

    public void save(User user) throws EmailAlreadyInUseException{

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

            //Executando comando
            comandoSQL.executeUpdate();
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SaveUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}