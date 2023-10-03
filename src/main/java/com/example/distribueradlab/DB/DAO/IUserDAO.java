package com.example.distribueradlab.DB.DAO;

import com.example.distribueradlab.BO.Entities.Product;
import com.example.distribueradlab.BO.Entities.User;
import com.example.distribueradlab.DB.Database.DatabaseException;

import java.util.List;

public interface IUserDAO {

    List<User> getAllUsers() throws DatabaseException;
    User getUserById(int id) throws DatabaseException;
    User getUserByEmailAndPassword(String email, String password) throws DatabaseException;

    boolean addUser(String username, String email, String password) throws DatabaseException;
    boolean updateUserById(int id, User updated) throws DatabaseException;
    User deleteUserById(int id);
}
