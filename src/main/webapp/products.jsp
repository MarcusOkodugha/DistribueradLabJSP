<%@ page import="com.example.distribueradlab.BO.Entities.Product" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: hamadaaljarrah
  Date: 2023-10-02
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
    <body>

    <%
        Object data = request.getAttribute("products");
        System.out.println(data);
        if (data !=null) {
            ArrayList<Product> products = (ArrayList<Product>) data;
            for (Product product : products) {
    %>
            <div >
                <img src="data:image/jpg;base64,<%=product.getBase64Image()%>">
                <a href="product-detail?id=<%=product.getId()%>"><%= product.getName()%></a>
                <p><%= product.getDescription()%></p>
                <p><%= product.getQuantity()%></p>
                <p><%= product.getPrice()%></p>
                
            </div>
        <%
            }
        }
        %>

    </body>
</html>
