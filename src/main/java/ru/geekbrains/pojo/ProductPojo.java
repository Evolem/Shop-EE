package ru.geekbrains.pojo;

import ru.geekbrains.persist.entities.Product;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class ProductPojo {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    @NotNull
    private Integer category_id;

    public ProductPojo() {
    }

    public ProductPojo(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.category_id = product.getCategory().getId();
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

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
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
