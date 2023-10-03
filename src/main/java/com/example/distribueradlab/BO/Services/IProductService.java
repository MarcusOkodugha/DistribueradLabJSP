package com.example.distribueradlab.BO.Services;

import java.io.InputStream;

public interface IProductService {

    boolean addProduct(String name, String description, double price, int quantity, InputStream image)
}
