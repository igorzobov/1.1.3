package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

;import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        try {
            Statement statement = Objects.requireNonNull(Util.getConnectionJDBC()).createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                System.out.println("id: " + user.getId());
                System.out.println("name: " + user.getName());
                System.out.println("lastName: " + user.getLastName());
                System.out.println("age: " + user.getAge());
            }
            System.out.println(user.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
