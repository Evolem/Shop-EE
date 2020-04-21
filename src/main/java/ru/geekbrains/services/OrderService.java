package ru.geekbrains.services;

import ru.geekbrains.cart.LineItem;
import ru.geekbrains.persist.entities.Order;
import ru.geekbrains.persist.repositories.OrderRepository;
import ru.geekbrains.persist.repositories.ejbRepositories.OrderRepo;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
@Named
public class OrderService {

    @EJB
    OrderRepo orderRepository;

    @Transactional
    public List<Order> findAllOrder(){
       return orderRepository.findAllOrder();
    }

    @Transactional
    public void createOrder(List<LineItem> lineItems, String description, BigDecimal price) {
        orderRepository.createOrder(lineItems, description, price);
    }
}
