package ru.geekbrains.controllers;


import ru.geekbrains.persist.entities.Order;
import ru.geekbrains.persist.repositories.OrderRepository;
import ru.geekbrains.services.OrderService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@SessionScoped
@Named
public class OrderController implements Serializable {

    @Inject
    private OrderService orderService;

    public List<Order> getAll() {
        return orderService.findAllOrder();
    }


}
