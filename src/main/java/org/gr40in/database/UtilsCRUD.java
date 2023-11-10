package org.gr40in.database;

import org.gr40in.model.HumanFriends;

import java.sql.*;
import java.util.List;

public class UtilsCRUD {
    public static void createAnimal(HumanFriends humanFriends) {

    }

    public static void createAnimalType(List<String> treeList) {
        System.out.println(treeList);
        for (int i = 1; i < treeList.size(); i++) {
            createBranchOfAnimalTree(treeList.get(i), treeList.get(i - 1));
        }
    }

    public static void createBranchOfAnimalTree(String animalName, String animalParent) {

        Long parentId = getParentId(animalParent);

        String query = "INSERT IGNORE INTO type_of_animal (type_name, parent) VALUES (?,?)";

        try (Connection connection = DataBaseService.getConnection()) {
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, animalName);
            prepareStatement.setLong(2, parentId);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean type_exist(String classOfAnimalType) {
        String query = "SELECT id FROM type_of_animal where type_name=?";
        try (Connection connection = DataBaseService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, classOfAnimalType);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Long getParentId(String animalTypeParentId) {
        String query = "SELECT id FROM type_of_animal where type_name=?";
        Long result = 0L;
        try (Connection connection = DataBaseService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, animalTypeParentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())  result = resultSet.getLong("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
