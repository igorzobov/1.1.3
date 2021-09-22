package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;


public class Main {

    public static void main(String[] args) {
        UserDaoJDBCImpl us = new UserDaoJDBCImpl();
        us.dropUsersTable();
        us.createUsersTable();
        us.saveUser("Игорь","Зобов",(byte) 33);
        us.saveUser("Егор","Зотов",(byte) 34);
        us.saveUser("Ихорь","Зомбов",(byte) 31);
        us.saveUser("Ивар","Злобов",(byte) 25);
        us.getAllUsers().forEach(System.out::println);

    }
}
