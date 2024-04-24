package br.com.sistemaReservas.dao;

import br.com.sistemaReservas.model.User;
import jdk.jpackage.internal.Log;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveUser {
    public static Connection connection = null;
    public void save(User user) {

        try {
            connection = Conexao.abrirConexao();
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