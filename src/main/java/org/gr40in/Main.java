package org.gr40in;

import org.gr40in.app.ConsoleApp;
import org.gr40in.database.DataBaseService;
import org.gr40in.database.UtilsCRUD;
import org.gr40in.model.Cat;
import org.gr40in.model.Dog;
import org.gr40in.model.Horse;
import org.gr40in.model.HumanFriends;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<String> stringList = new ArrayList<>();
//
//        String query = "SHOW DATABASES ";
//        Connection connection = DataBaseService.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                System.out.println(resultSet.getString("Database"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

//        ConsoleApp app = new ConsoleApp();
//        app.run();

        HumanFriends dog1 = new Dog();
        HumanFriends cat1 = new Cat();
        HumanFriends cat2 = new Cat();
        HumanFriends horse1 = new Horse();
//        System.out.println(dog1.getClass().getSuperclass());
        create_animal_types(dog1);
        create_animal_types(cat1);
        create_animal_types(cat2);
        create_animal_types(horse1);

//        System.out.println(UtilsCRUD.type_exist("asfa"));


//        System.out.println(dog1.getClass().getSuperclass().getSuperclass());

//
//        String query = "SHOW DATABASES";
//        Connection connection = DataBaseService.getConnection();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("Database"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }

    public static void create_animal_types(HumanFriends oneHumanFriends) {
        List<String> treeList = new ArrayList<>();
        Class startClass = oneHumanFriends.getClass();
        while (!startClass.getSimpleName().equals("Object")) {
            treeList.addFirst(startClass.getSimpleName());
            startClass = startClass.getSuperclass();
        }
        UtilsCRUD.createAnimalType(treeList);
    }
}