package org.gr40in.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.Properties;

public class DataBaseService {


    public static Connection getConnection() {

        Path DBpath = Path.of("src/main/resources/database.properties");
        Connection resultConnection = null;
        Properties dbProperties = new Properties();

        try (InputStream is = Files.newInputStream(DBpath)) {
            dbProperties.load(is);
        } catch (IOException e) {
            System.out.println("Properties read ERROR: " + e.getMessage());
        }

        try {
            resultConnection = DriverManager.getConnection(
                    dbProperties.getProperty("DB_URL"),
                    dbProperties.getProperty("DB_USER"),
                    dbProperties.getProperty("DB_PASSWORD"));
        } catch (SQLException e) {
            System.out.println("Connection ERROR: " + e.getMessage());
        }

        return resultConnection;
    }

    public static void initDataBase(){
        String query = "CREATE DATABASE IF NOT EXISTS human_friends;";
        Connection connection = DataBaseService.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Database"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
