package com.example.jpasample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootApplication
public class JpaSampleApplication {

    public static void main(String[] args) {
        //SpringApplication.run(JpaSampleApplication.class, args);


        String url = "jdbc:mariadb://localhost:3306/jpa_sample";
        String username = "root";
        String password = "qwe123!@#";
        try(Connection connection = DriverManager.getConnection(url,username,password)){
            System.out.println("Connection :" + connection);
            String sql = "CREATE TABLE account (id int, user varchar(255), password varchar(255));";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
