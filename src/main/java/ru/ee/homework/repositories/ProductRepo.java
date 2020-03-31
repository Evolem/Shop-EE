package ru.ee.homework.repositories;

import ru.ee.homework.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private static ProductRepo productRepo;
    private List<Product> products;

    private ProductRepo() {
        products = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            products.add(new Product(i, "Продукт №" + i, 100 + i));
        }
        System.out.println("Репозиторий заполнен");
    }


    public static ProductRepo getInstance() {
        return (productRepo == null) ? productRepo = new ProductRepo() : productRepo;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) return product;
        }
        return null;
    }
}
