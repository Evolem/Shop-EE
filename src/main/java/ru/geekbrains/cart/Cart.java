package ru.geekbrains.cart;

import ru.geekbrains.cart.LineItem;
import ru.geekbrains.pojo.ProductPojo;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SessionScoped
@Named
public class Cart implements Serializable {
    private Map<LineItem, Integer> lineItems;

    public Cart() {
        this.lineItems = new HashMap<>();
    }

    public void addProduct(ProductPojo productPojo, String option, int qty) {
        LineItem lineItem = new LineItem(productPojo, option);
        lineItems.put(lineItem, lineItems.getOrDefault(lineItem, 0) + qty);
    }

    public void removeProductQty(ProductPojo productPojo, String option, int qty){
        LineItem lineItem = new LineItem(productPojo, option);
        int currentQty = lineItems.getOrDefault(lineItem,0);
        if (currentQty - qty > 0){
            lineItems.put(lineItem, currentQty - qty);
        }
        else {
            lineItems.remove(lineItem);
        }
    }

    public List<LineItem> getAllLineItems(){
        lineItems.forEach(LineItem::setQty);
        return new ArrayList<>(lineItems.keySet());
    }

    public void cleaner(){
        lineItems.clear();
    }
}
