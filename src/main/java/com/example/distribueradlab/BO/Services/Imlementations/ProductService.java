package com.example.distribueradlab.BO.Services.Imlementations;

import com.example.distribueradlab.BO.Entities.Product;
import com.example.distribueradlab.BO.Services.IProductService;
import com.example.distribueradlab.DB.DAO.IProductDAO;
import com.example.distribueradlab.DB.DAO.Implementation.ProductDAO;
import com.example.distribueradlab.DB.Database.DatabaseException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {


    public boolean addProduct(String name, String description, double price, int quantity, InputStream image){
        IProductDAO productDAO = new ProductDAO();
        try {
            productDAO.addProduct(name, description, price,quantity, image);
            return  true;
        } catch (DatabaseException e) {
            System.out.println("Handle this error in product service dude: " + e.getMessage());
        }
        return false;
    }

    public Product getProductById(int id){
        IProductDAO productDAO = new ProductDAO();
        Product product = null;
        try {
            product = productDAO.getProductById(id);
        } catch (DatabaseException e) {
            System.out.println("Handle this error in product service dude: " + e.getMessage());
        }
        return product;
    }


    public List<Product> getAllProducts(){
        List<Product> products = null;
        try {
            products = new ProductDAO().getAllProducts();
        } catch (DatabaseException e) {
            System.out.println("Handle this error in product service dude: " + e.getMessage());
        }
        return products;

    }



}
