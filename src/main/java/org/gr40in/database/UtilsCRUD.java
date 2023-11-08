package org.gr40in.database;

import org.gr40in.model.HumanFriends;

import java.sql.*;

public class UtilsCRUD {
    public static void createAnimal(HumanFriends humanFriends) {

    }

    public static void createAnimalType(String classOfAnimalType){

    }

    public static boolean type_exist(String classOfAnimalType) {
        String query = "SELECT id FROM type_of_animal where type_name=?";
//        Connection connection = DataBaseService.getConnection();
        try (Connection connection = DataBaseService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, classOfAnimalType);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
