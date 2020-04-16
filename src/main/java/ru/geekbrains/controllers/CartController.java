package ru.geekbrains.controllers;

import ru.geekbrains.cart.Cart;
import ru.geekbrains.cart.LineItem;
import ru.geekbrains.pojo.ProductPojo;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CartController implements Serializable {

    @Inject
    private Cart cart;

    public List<LineItem> getAllLineItems(){
        return cart.getAllLineItems();
    }

    public void addToCart(ProductPojo productPojo){
        cart.addProduct(productPojo,"", 1);
    }

    public void removeFromCart(ProductPojo productPojo){
        cart.removeProductQty(productPojo, "", 1);
    }

}
