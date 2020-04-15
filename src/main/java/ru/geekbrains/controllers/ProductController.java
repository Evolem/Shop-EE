package ru.geekbrains.controllers;

import ru.geekbrains.persist.entities.Product;
import ru.geekbrains.persist.repositories.CategoryRepository;
import ru.geekbrains.persist.repositories.ProductRepository;
import ru.geekbrains.services.CategoryService;
import ru.geekbrains.services.ProductService;
import ru.geekbrains.services.pojo.ProductPojo;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class ProductController implements Serializable {

    @Inject
    private ProductService productService;

    @Inject
    private CategoryService categoryService;

    private ProductPojo productPojo;
    private Product product;
    private Integer category_id;

    public Product getProduct() {
        return product;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String createProduct() {
        this.product = new Product();
        if (category_id != null) {
            this.product.setCategory(categoryService.findCategoryById(category_id));
        }
        return "/product.xhtml?faces-redirect=true";
    }

    public List<Product> getAllProduct() throws SQLException {
        return productService.findAll();
    }

    public String editProduct(Product product) {
        this.product = product;

        if (category_id != null) {
            this.product.setCategory(categoryService.findCategoryById(category_id));
        }

        return "/product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Product product) throws SQLException {
        productService.delete(product.getId());
        //return "/index.xhtml?faces-redirect=true";
    }

    public String saveProduct() throws SQLException {
        if (product.getId() == null) {
            productService.insert(product);
        } else {
            productService.update(product);
        }
        return "/index.xhtml?faces-redirect=true";
    }
}
