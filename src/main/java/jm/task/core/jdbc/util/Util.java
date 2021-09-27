package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import java.sql.*;
import java.util.Properties;

public class Util {
    private static final String URL = "jdbc:mysql://127.0.0.1/usersdb?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {
                Properties properties = new Properties();
                properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
                properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                properties.setProperty(Environment.URL, URL);
                properties.setProperty(Environment.USER, USER);
                properties.setProperty(Environment.PASS, PASSWORD);
                properties.put(Environment.SHOW_SQL, "true");
                sessionFactory = new Configuration()
                        .addProperties(properties)
                        .addAnnotatedClass(User.class)
                        .buildSessionFactory();
            } catch (Exception e) {
                System.out.println("Исключение в фабрике: " + e);
            }
        }
        return sessionFactory;
    }

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
