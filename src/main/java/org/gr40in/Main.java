package org.gr40in;

import org.gr40in.app.ConsoleApp;

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

        ConsoleApp app = new ConsoleApp();
        app.run();
    }
}