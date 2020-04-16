package ru.geekbrains.pojo;

import ru.geekbrains.persist.entities.Product;

import java.math.BigDecimal;
import java.util.Objects;

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
        if (product.getCategory() != null) {
            this.categoryPojo = new CategoryPojo(product.getCategory());
        }
    }

    public Product createProduct() {
        Product product = new Product();
        product.setName(name);
        if (categoryPojo != null) {
            product.setCategory(categoryPojo.createCategory());
        }
        product.setDescription(description);
        product.setPrice(price);
        return product;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPojo that = (ProductPojo) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
