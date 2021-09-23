package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String URL = "jdbc:mysql://127.0.0.1/usersdb?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnectionJDBC() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("getConnectionJDBC ERROR");
        } finally {
            try {
                DriverManager.getConnection(URL, USER, PASSWORD).close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
