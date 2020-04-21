package ru.geekbrains.persist.repositories.ejbRepositories;

import ru.geekbrains.cart.LineItem;
import ru.geekbrains.persist.entities.Order;

import javax.ejb.Local;
import java.math.BigDecimal;
import java.util.List;

@Local
public interface OrderRepo {

    List<Order> findAllOrder();

    Order findOrderById(Integer id);

    void createOrder(List<LineItem> lineItems, String description, BigDecimal price);

}
