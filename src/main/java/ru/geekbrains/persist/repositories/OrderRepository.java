package ru.geekbrains.persist.repositories;

import ru.geekbrains.cart.LineItem;
import ru.geekbrains.persist.entities.Order;
import ru.geekbrains.persist.entities.Product;
import ru.geekbrains.persist.entities.Purchase;
import ru.geekbrains.services.ProductService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@ApplicationScoped
@Named
public class OrderRepository {

    @PersistenceContext(unitName = "ds")
    EntityManager em;

    @Inject
    ProductRepository productRepository;

    @Transactional
    public List<Order> findAllOrder(){
        List<Order> list = em.createNamedQuery("Order.findAllOrder", Order.class).getResultList();
        return list;
    }

    @Transactional
    public Order findOrderById(Integer id){
        return em.createNamedQuery("Order.findOrderById",Order.class).setParameter("id", id).getSingleResult();
    }

    @Transactional
    public void createOrder(List<LineItem> lineItems, String description, BigDecimal price){
        Order order = new Order();
        order.setDescription(description);
        order.setPrice(price);

        em.persist(order);

        for (int i = 0; i < lineItems.size(); i++) {
            Product product = productRepository.findById(lineItems.get(i).getProductPojo().getId());

            Purchase purchase = new Purchase();
            purchase.setOrder(order);
            purchase.setProduct(product);
            purchase.setQuantity(lineItems.get(i).getQty());

            em.merge(purchase);
        }




    }

}
