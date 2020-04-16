package ru.geekbrains.cart;

import ru.geekbrains.pojo.ProductPojo;

import java.util.Objects;

public class LineItem {

    private ProductPojo productPojo;
    private String option;
    private Integer qty;

    public LineItem() {
    }

    public LineItem(ProductPojo productPojo, String option) {
        this.productPojo = productPojo;
        this.option = option;
    }

    public ProductPojo getProductPojo() {
        return productPojo;
    }

    public void setProductPojo(ProductPojo productPojo) {
        this.productPojo = productPojo;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return productPojo.equals(lineItem.productPojo) &&
                option.equals(lineItem.option);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productPojo, option);
    }
}
