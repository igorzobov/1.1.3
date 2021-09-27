package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Игорь", "Зобов", (byte) 33);
        userService.saveUser("Егор", "Зотов", (byte) 34);
        userService.saveUser("Ихорь", "Зомбов", (byte) 31);
        userService.saveUser("Ивар", "Злобов", (byte) 25);
        userService.removeUserById(2);
        System.out.println(userService.getAllUsers().size());
        userService.getAllUsers().forEach(System.out::println);
        Util.getSessionFactory().close();
    }
}
