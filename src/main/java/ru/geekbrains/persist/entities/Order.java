package ru.geekbrains.persist.entities;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private User user;
    private List<Product> productList;
    private BigDecimal price;
}
