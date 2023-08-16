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
        //connection 비용 자체가 비쌈
        try(Connection connection = DriverManager.getConnection(url,username,password)){
            System.out.println("Connection :" + connection);
            String sql = "CREATE TABLE account (id int, user varchar(255), password varchar(255));";
            //반복적 코드 발생
            //lazy loading 사용 자체가 어려움
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
