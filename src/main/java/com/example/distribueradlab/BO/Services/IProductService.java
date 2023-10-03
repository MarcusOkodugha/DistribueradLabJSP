package com.example.distribueradlab.BO.Services;

import com.example.distribueradlab.BO.Entities.Product;

import java.io.InputStream;
import java.util.List;

public interface IProductService {

    boolean addProduct(String name, String description, double price, int quantity, InputStream image);
    Product getProductById(int id);

    List<Product> getAllProducts();
}
