package org.gr40in;

import java.io.FileInputStream;
import java.io.IOException;
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

        Properties dbProperties = new Properties();
        try {
            dbProperties.load(Files.newInputStream(DBpath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            return DriverManager.getConnection(dbProperties.getProperty("DB_URL"),
                    dbProperties.getProperty("DB_USER"),
                    dbProperties.getProperty("DB_PASSWORD"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
