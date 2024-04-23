package br.com.sistemaReservas.dao;

import br.com.sistemaReservas.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SaveUser {

    public void save(User user) {

        try {
            String SQL = "INSERT INTO CAR (NAME) VALUES (?)";

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, user.getNoma());
            preparedStatement.execute();

            connection.close();
        }catch (Exception e) {
            System.out.println("Erro ao gravar!");
        }

    }

}