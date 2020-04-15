package ru.geekbrains.services.pojo;

import ru.geekbrains.persist.entities.Product;

import java.math.BigDecimal;

public class ProductPojo {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private CategoryPojo categoryPojo;

    public ProductPojo() {
    }

    public ProductPojo(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.categoryPojo = new CategoryPojo(product.getCategory());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryPojo getCategoryPojo() {
        return categoryPojo;
    }

    public void setCategoryPojo(CategoryPojo categoryPojo) {
        this.categoryPojo = categoryPojo;
    }
}
