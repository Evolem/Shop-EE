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
    private Integer category_id = -1;

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
        if(category_id == -1) return productService.findAll();
        else  return productService.findAllByCategoryId(category_id);
    }

    public String refresh(){
        return "/index.xhtml?faces-redirect=true";
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
            productService.insertProduct(productPojo);
        } else {
            productService.update(productPojo);
        }
        return "/index.xhtml?faces-redirect=true";
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}
