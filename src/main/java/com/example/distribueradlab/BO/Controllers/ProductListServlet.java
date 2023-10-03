package com.example.distribueradlab.BO.Controllers;


import com.example.distribueradlab.BO.Entities.Product;
import com.example.distribueradlab.BO.Services.Imlementations.ProductService;
import com.example.distribueradlab.DB.DAO.IProductDAO;
import com.example.distribueradlab.DB.DAO.Implementation.ProductDAO;
import com.example.distribueradlab.DB.Database.DatabaseException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductListServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        List<Product> products = new ProductService().getAllProducts();
        req.setAttribute("products", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("products.jsp");
        dispatcher.forward(req, res);

    }
}
