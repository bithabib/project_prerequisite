package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50) NOT NULL, " +
                "lastName VARCHAR(50) NOT NULL, " +
                "age TINYINT NOT NULL" +
                ");";

        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Users table created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error creating users table.");
        }

    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users;";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Users table dropped successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error dropping users table.");
        }

    }

    public void saveUser(String name, String lastName, byte age) {
    String sql = "INSERT INTO users (name, lastName, age) VALUES ('" + name + "', '" + lastName + "', " + age + ");";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("User with name " + name + " added to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error saving user to the database.");
        }

    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM users WHERE id = " + id + ";";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            int rowsAffected = statement.executeUpdate(sql);
            if (rowsAffected > 0) {
                System.out.println("User with ID " + id + " has been removed.");
            } else {
                System.out.println("No user found with ID " + id + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error removing user from the database.");
        }

    }

    public List<User> getAllUsers() {
        List <User> users = new ArrayList<>();
        String sql = "SELECT * FROM users;";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement();
             var resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving users from the database.");
        }
        return users;
    }

    public void cleanUsersTable() {
        String sql = "DELETE FROM users;";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("All users have been removed from the table.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error cleaning users table.");
        }

    }
}
