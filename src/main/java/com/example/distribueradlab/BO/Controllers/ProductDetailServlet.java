package com.example.distribueradlab.BO.Controllers;

import com.example.distribueradlab.BO.Entities.Product;
import com.example.distribueradlab.BO.Services.IProductService;
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

@WebServlet("/product-detail")
public class ProductDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        // Get product
        Product product = new ProductService().getProductById(id);

        req.setAttribute("product", product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product-detail.jsp");
        dispatcher.forward(req, res);
    }
}
