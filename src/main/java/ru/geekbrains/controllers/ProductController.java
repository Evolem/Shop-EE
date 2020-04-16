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
    private Integer category_id;

    public ProductPojo getProductPojo() {
        return productPojo;
    }

    public void setProductPojo(ProductPojo productPojo) {
        this.productPojo = productPojo;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String createProduct() {
        this.productPojo = new ProductPojo();
        if (category_id != null) {
            this.productPojo.setCategoryPojo(categoryService.findCategoryById(category_id));
        }
        return "/product.xhtml?faces-redirect=true";
    }

    public List<ProductPojo> getAllProduct(){
        return productService.findAll();
    }

    public String editProduct(ProductPojo product) {
        this.productPojo = product;
        if (category_id != null) {
            this.productPojo.setCategoryPojo(categoryService.findCategoryById(category_id));
        }

        return "/product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(ProductPojo product) {
        productService.delete(product.getId());
        //return "/index.xhtml?faces-redirect=true";
    }

    public String saveProduct() {
        if (productPojo.getId() == null) {
            productService.insert(productPojo);
        } else {
            productService.update(productPojo);
        }
        return "/index.xhtml?faces-redirect=true";
    }
}
