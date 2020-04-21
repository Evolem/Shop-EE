package ru.geekbrains.persist.repositories.ejbRepositories;

import ru.geekbrains.cart.LineItem;
import ru.geekbrains.persist.entities.Order;
import ru.geekbrains.persist.entities.Product;
import ru.geekbrains.persist.entities.Purchase;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

@Stateless
public class OrderRepoImpl implements OrderRepo {

    @PersistenceContext(unitName = "ds")
    EntityManager em;

    @EJB
    ProductRepo productRepo;

    @Override
    @TransactionAttribute
    public List<Order> findAllOrder() {
        List<Order> list = em.createNamedQuery("Order.findAllOrder", Order.class).getResultList();
        return list;
    }

    @Override
    @TransactionAttribute
    public Order findOrderById(Integer id) {
        return em.createNamedQuery("Order.findOrderById", Order.class).setParameter("id", id).getSingleResult();
    }

    @Override
    @TransactionAttribute
    public void createOrder(List<LineItem> lineItems, String description, BigDecimal price) {
        Order order = new Order();
        order.setDescription(description);
        order.setPrice(price);

        em.persist(order);

        for (int i = 0; i < lineItems.size(); i++) {
            Product product = productRepo.findById(lineItems.get(i).getProductPojo().getId());

            Purchase purchase = new Purchase();
            purchase.setOrder(order);
            purchase.setProduct(product);
            purchase.setQuantity(lineItems.get(i).getQty());

            em.merge(purchase);
        }

    }
}
