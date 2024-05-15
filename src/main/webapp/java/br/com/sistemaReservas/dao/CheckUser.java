package br.com.sistemaReservas.dao;


import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class CheckUser {
    public static Connection connection = null;
    public boolean validate(String email, String senha) {
        System.out.println(email);
        System.out.println(senha);
        PreparedStatement comandoSQL = null;
        ResultSet resultSet = null;
        try {
            connection = Conexao.abrirConexao();
            comandoSQL = connection.prepareStatement("SELECT email,senha FROM Clientes WHERE email = ? AND senha = ?",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            comandoSQL.setString(1, email);
            comandoSQL.setString(2, senha);

            //Executando comando
            resultSet = comandoSQL.executeQuery();

            return resultSet.next();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SaveUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    Logger.getLogger(SaveUser.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (comandoSQL != null) {
                try {
                    comandoSQL.close();
                } catch (SQLException e) {
                    Logger.getLogger(SaveUser.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    Logger.getLogger(SaveUser.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return false;
    }


}
