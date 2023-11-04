package org.gr40in;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
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
            resultConnection = DriverManager.getConnection(dbProperties.getProperty("DB_URL"),
                    dbProperties.getProperty("DB_USER"),
                    dbProperties.getProperty("DB_PASSWORD"));
        } catch (SQLException e) {
            System.out.println("Connection ERROR: " + e.getMessage());
        }

        return resultConnection;
    }

}
