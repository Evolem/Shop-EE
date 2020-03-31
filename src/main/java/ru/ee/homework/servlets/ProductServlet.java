package ru.ee.homework.servlets;

import ru.ee.homework.entities.Product;
import ru.ee.homework.repositories.ProductRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {
    ProductRepo productRepo = ProductRepo.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //todo проверки валидности id

        int id = Integer.parseInt(req.getPathInfo().substring(1));
        Product product = productRepo.getProductById(id);

        getServletContext().setAttribute("title", product.getName()); // плохой вариант как я понимаю, как лучше передавать изменяемые переменные?
        req.setAttribute("productId", product.getId());
        req.setAttribute("productName", product.getName());
        req.setAttribute("productPrice", product.getPrice());
        req.setAttribute("product", product);
        getServletContext().getRequestDispatcher("/templates/product.jsp").include(req, resp);
    }
}
