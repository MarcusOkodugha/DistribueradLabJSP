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
    <script src="https://cdn.tailwindcss.com"></script>

</head>
    <body>

    <%
        Object data = request.getAttribute("products");
        if (data !=null) {
            ArrayList<Product> products = (ArrayList<Product>) data;
            for (Product product : products) {
    %>
            <div class="p-4 rounded-lg shadow-lg w-[300px]">
                <img class="product-image h-[200px] w-full object-cover" src="data:image/jpg;base64,<%=product.getBase64Image()%>">
                <div>
                    <a href="product-detail?id=<%=product.getId()%>"><%= product.getName()%></a>
                    <p>Price: <%= product.getPrice()%> kr</p>
                </div>

                
            </div>
        <%
            }
        }
        %>

    </body>
</html>
