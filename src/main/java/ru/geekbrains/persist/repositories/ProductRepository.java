package ru.geekbrains.persist.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.entities.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.sql.*;
import java.util.List;

@ApplicationScoped
@Named
public class ProductRepository {

    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

//  @Resource
//  private UserTransaction userTransaction; //для управления транзакциями вручную


    @Transactional
    public void insert(Product product) {
        em.persist(product); //только создает новую запись
    }

    @Transactional
    public void update(Product product) {
        em.merge(product); //обновляет или создает новую запись, если не найден id
    }

    @Transactional
    public void delete(long id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
    }

    public Product findById(long id) {
        return em.find(Product.class, id);
    }

    public List<Product> findAll() {
        //JPQL
        return em.createQuery("from Product", Product.class).getResultList();
    }

}
