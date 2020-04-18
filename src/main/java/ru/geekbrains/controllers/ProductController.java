package ru.geekbrains.controllers;

import ru.geekbrains.services.CategoryService;
import ru.geekbrains.services.OrderService;
import ru.geekbrains.services.ProductService;
import ru.geekbrains.pojo.ProductPojo;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class ProductController implements Serializable {

    @Inject
    private ProductService productService;

    @Inject
    private CategoryService categoryService;

    @Inject
    private OrderService orderService;

    private ProductPojo productPojo;

    public ProductPojo getProductPojo() {
        return productPojo;
    }

    public void setProductPojo(ProductPojo productPojo) {
        this.productPojo = productPojo;
    }

    public String createProduct() {
        this.productPojo = new ProductPojo();
        return "/product.xhtml?faces-redirect=true";
    }

    public List<ProductPojo> getAllProduct(){
        return productService.findAll();
    }

    public String editProduct(ProductPojo product) {
        this.productPojo = product;
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
