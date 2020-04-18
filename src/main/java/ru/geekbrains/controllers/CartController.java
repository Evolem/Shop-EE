package ru.geekbrains.controllers;

import ru.geekbrains.cart.Cart;
import ru.geekbrains.cart.LineItem;
import ru.geekbrains.pojo.ProductPojo;
import ru.geekbrains.services.OrderService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Named
@SessionScoped
public class CartController implements Serializable {

    @Inject
    private Cart cart;

    @Inject
    OrderService orderService;

    public List<LineItem> getAllLineItems() {
        return cart.getAllLineItems();
    }

    public void addToCart(ProductPojo productPojo) {
        cart.addProduct(productPojo, "", 1);
    }

    public void removeFromCart(ProductPojo productPojo) {
        cart.removeProductQty(productPojo, "", 1);
    }

    public BigDecimal getSum() {
        BigDecimal sum = BigDecimal.valueOf(0);
        List<LineItem> lineItems = getAllLineItems();

        for (LineItem lineItem : lineItems) {
            sum = lineItem.getProductPojo().getPrice().multiply(BigDecimal.valueOf(lineItem.getQty())).add(sum);
        }
        return sum;
    }

    public void createOrder() {
        String description = "описание";
        orderService.createOrder(getAllLineItems(), description, getSum());
        cart.cleaner();
    }
}
