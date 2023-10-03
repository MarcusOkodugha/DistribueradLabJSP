package com.example.distribueradlab.BO.Services.Imlementations;

import com.example.distribueradlab.BO.Services.IProductService;
import com.example.distribueradlab.DB.DAO.IProductDAO;
import com.example.distribueradlab.DB.DAO.Implementation.ProductDAO;
import com.example.distribueradlab.DB.Database.DatabaseException;

import java.io.InputStream;

public class ProductService implements IProductService {


    public boolean addProduct(String name, String description, double price, int quantity, InputStream image){
        IProductDAO productDAO = new ProductDAO();
        try {
            productDAO.addProduct(name, description, price,quantity, image);
            return  true;
        } catch (DatabaseException e) {
            System.out.println("Handle this error in service dude: " + e.getMessage());
        }
        return false;
    }

}
