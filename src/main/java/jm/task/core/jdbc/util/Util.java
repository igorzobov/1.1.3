package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String URL = "jdbc:mysql://127.0.0.1/usersdb?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnectionJDBC() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
//
//            while (resultSet.next()) {
//                String userName = resultSet.getString("name");
//                System.out.println(userName);
//            }
//            resultSet.close();
//            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
