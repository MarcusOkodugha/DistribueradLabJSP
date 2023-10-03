package com.example.distribueradlab.BO.Controllers;

import com.example.distribueradlab.BO.Services.IProductService;
import com.example.distribueradlab.BO.Services.Imlementations.ProductService;
import com.example.distribueradlab.DB.DAO.IProductDAO;
import com.example.distribueradlab.DB.DAO.Implementation.ProductDAO;
import com.example.distribueradlab.DB.Database.DatabaseException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;


@WebServlet("/add-product")
@MultipartConfig
public class AddProductServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {





        RequestDispatcher dispatcher = req.getRequestDispatcher("product-form.jsp");
        dispatcher.forward(req, res);

    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {


        String name = req.getParameter("name");
        String description = req.getParameter("description");
        double price = Integer.parseInt(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        // Get upload image.
        Part part = req.getPart("image");
        InputStream inputStream = part.getInputStream();

        IProductService pServ = new ProductService();
        pServ.



        res.sendRedirect("products");

    }

}
