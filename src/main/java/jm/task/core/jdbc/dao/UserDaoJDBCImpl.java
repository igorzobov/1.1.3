package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try {
            Connection connection = Util.getConnectionJDBC();
            assert connection != null;
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users " +
                    "(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
                    "name CHAR(100) NOT NULL, " +
                    "lastName CHAR(100) NOT NULL, " +
                    "age INT NOT NULL )";
            statement.execute(sql);
            statement.close();
            System.out.println("createUsersTable ok");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Don't create users table");
        }
    }

    public void dropUsersTable() {
        try {
            Connection connection = Util.getConnectionJDBC();
            assert connection != null;
            Statement statement = connection.createStatement();
            String sql = "DROP TABLE users";
            statement.execute(sql);
            statement.close();
            System.out.println("dropUsersTable ok");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Don't drop users table");
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            Connection connection = Util.getConnectionJDBC();
            String sql = "insert into users (name, lastName, age) values (?, ?, ?)";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("saveUser ok");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Don't save user");
        }

    }

    public void removeUserById(long id) {
        try {
            Connection connection = Util.getConnectionJDBC();
            String sql = "DELETE FROM users WHERE (id) = (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.close();
            System.out.println("removeUserById ok");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Don't remove user by id");
        }
    }

    public List<User> getAllUsers() {
        try {
            Connection connection = Util.getConnectionJDBC();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            List<User> userList = new ArrayList<>();

            while (rs.next()) {
                long userId = rs.getLong("id");
                String userName = rs.getString("name");
                String userLastName = rs.getString("lastName");
                byte userAge = rs.getByte("age");
                userList.add(new User(userId, userName, userLastName, userAge));
            }
            System.out.println("getAllUsers ok");
            statement.close();
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Don't get all users");
        }
        return null;
    }

    public void cleanUsersTable() {
        try {
            Connection connection = Util.getConnectionJDBC();
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM users");
            statement.close();
            System.out.println("cleanUsersTable ok");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Don't clean user table");
        }
    }
}
