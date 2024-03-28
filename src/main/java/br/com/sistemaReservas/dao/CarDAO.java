package br.com.carstore.dao;

import br.com.carstore.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarDAO {

    public void createCar(Car car) {

        try {
            String SQL = "INSERT INTO CAR (NAME) VALUES (?)";

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, car.getName());
            preparedStatement.execute();

            System.out.println("success in insert car");

            connection.close();
        }catch (Exception e) {
            System.out.println("Erro ao gravar nome do carro no banco!");
        }

    }

}
