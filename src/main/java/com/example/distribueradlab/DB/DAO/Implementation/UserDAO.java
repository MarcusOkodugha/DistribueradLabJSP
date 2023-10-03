package com.example.distribueradlab.DB.DAO.Implementation;

import com.example.distribueradlab.BO.Entities.User;
import com.example.distribueradlab.DB.DAO.IUserDAO;
import com.example.distribueradlab.DB.Database.DatabaseConnection;
import com.example.distribueradlab.DB.Database.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO  implements IUserDAO {
    @Override
    public List<User> getAllUsers() throws DatabaseException {
        List<User> userList = new ArrayList<>();

        try {
            // Acquire connection
            Connection conn = DatabaseConnection.getInstance().getConnection();
            String sql = "SELECT * FROM t_users";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate through the result set and populate the user list
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setRole(resultSet.getString("role"));
                userList.add(user);
            }

            // Release connection
            DatabaseConnection.getInstance().releaseConnection(conn);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage(),e);
        }

        return userList;
    }


    @Override
    public User getUserById(int id) throws DatabaseException {
        User user = null;
        try {
            // Acquire connection
            Connection conn = DatabaseConnection.getInstance().getConnection();
            String sql = "SELECT * FROM t_users WHERE id = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
            }

            // Release connection
            DatabaseConnection.getInstance().releaseConnection(conn);

        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage(), e);
        }

        return user;
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) throws DatabaseException {
        User user = null;
        try {
            // Acquire connection
            Connection conn = DatabaseConnection.getInstance().getConnection();
            String sql = "SELECT * FROM t_users WHERE email = ? AND password = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if a user with the specified email and password is found
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
            }

            // Release connection
            DatabaseConnection.getInstance().releaseConnection(conn);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage(), e);
        }
        return user;
    }




    @Override
    public boolean addUser(String username, String email, String password) throws DatabaseException {
        boolean success = false;

        try {
            // Acquire connection
            Connection conn = DatabaseConnection.getInstance().getConnection();
            String sql = "INSERT INTO t_users (username, email, password) VALUES (?, ?, ?)";

            // Start transaction
            conn.setAutoCommit(false);

            // Insert into t_users table
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                success = true;
                conn.commit();
            }

            // End transaction
            conn.setAutoCommit(true);

            // Release connection
            DatabaseConnection.getInstance().releaseConnection(conn);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage(), e);
        }

        return success;
    }



    @Override
    public boolean updateUserById(int id, User updated) throws DatabaseException {
        boolean success = false;

        try {
            // Acquire connection
            Connection conn = DatabaseConnection.getInstance().getConnection();
            String sql = "UPDATE t_users SET username = ?, email = ?, password = ?, role = ? WHERE id = ?";

            conn.setAutoCommit(false);
            // Start transaction
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, updated.getUsername());
            preparedStatement.setString(2, updated.getEmail());
            preparedStatement.setString(3, updated.getPassword());
            preparedStatement.setString(4, updated.getRole());
            preparedStatement.setInt(5, id);

            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                success = true ;
                conn.commit();
            }

            conn.setAutoCommit(true);

            // Release connection
            DatabaseConnection.getInstance().releaseConnection(conn);
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage(), e);
        }

        return success;
    }

    @Override
    public User deleteUserById(int id) {
        return null;
    }


    public static void main(String[] args) throws DatabaseException {
        UserDAO userDao =  new UserDAO();

//        System.out.println(userDao.getAllUsers());
//        System.out.println(userDao.getUserByEmailAndPassword("hamada@gmail.com", "123123"));
//        System.out.println(userDao.getUserByEmailAndPassword("hamada@gmail.com", "222222"));


    }
}
