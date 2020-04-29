package ru.ws;

import ru.geekbrains.services.*;

import java.net.MalformedURLException;
import java.net.URL;

public class WsClient {
    public static void main(String[] args) throws MalformedURLException {
        URL pURL = new URL("http://localhost:8080/JspWebApp/ProductService?wsdl");
        URL cURL = new URL("http://localhost:8080/JspWebApp/CategoryService?wsdl");

        ProductService productService = new ProductService(pURL);
        ProductServiceWs productServiceWs = productService.getProductServicePort();

        CategoryService categoryService = new CategoryService(cURL);
        CategoryServiceWs categoryServiceWs = categoryService.getCategoryServicePort();

        //все товары
        productServiceWs.findAll().forEach(p -> System.out.println(p.getName()));
        
        //Все товары по категории
        productServiceWs.findAllByCategoryId(30).forEach(p -> System.out.println(p.getName()));

        // Вставка
        ProductPojo pWs = new ProductPojo();
        pWs.setName("pWs");
        pWs.setCategoryId(30);
        productServiceWs.insertProduct(pWs);


        //Поиск по имени или id
        ProductPojo p = productServiceWs.findProductByName("pWs");
        System.out.println(p.getName());

        //Удаление
        long id_forDelete = p.getId();
        productServiceWs.delete(id_forDelete);

        //Добавить категорию товара
        CategoryPojo categoryFromWs = new CategoryPojo();
        categoryFromWs.setName("categoryFromWs");
        categoryServiceWs.insertCategory(categoryFromWs);

    }
}
