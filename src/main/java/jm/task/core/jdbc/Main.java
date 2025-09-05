package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // implement algorithm here
        try (Connection connection = Util.getConnection()) {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Database connection successful!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            System.out.println("Error while checking connection:");
            e.printStackTrace();
        }

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("John", "Doe", (byte) 30);
        userService.saveUser("Jane", "Smith", (byte) 25);
        userService.saveUser("Mike", "Johnson", (byte) 40);
        userService.saveUser("Emily", "Davis", (byte) 22);

        // get all users and print them
        List <User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
//        remove user by id
        userService.removeUserById(2);
        // get all users and print them
        users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user.getName());
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
