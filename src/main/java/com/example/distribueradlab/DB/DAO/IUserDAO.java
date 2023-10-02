package com.example.distribueradlab.DB.DAO;

import com.example.distribueradlab.BO.Entities.Product;
import com.example.distribueradlab.BO.Entities.User;

import java.util.List;

public interface IUserDAO {

    List<User> getAllUser();
    User getUserById(int id);
    User addUser(User user);
    User updateUserById(int id, User updated);
    User deleteUserById(int id);
}
