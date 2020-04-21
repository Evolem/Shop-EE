package ru.geekbrains.persist.repositories.ejbRepositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.persist.entities.Product;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductRepoImpl implements ProductRepo {

    private static final Logger logger = LoggerFactory.getLogger(ru.geekbrains.persist.repositories.ProductRepository.class);

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

//  @Resource
//  private UserTransaction userTransaction; //для управления транзакциями вручную


    @Override
    @TransactionAttribute
    public void insert(Product product) {
        em.persist(product); //только создает новую запись
    }

    @Override
    @TransactionAttribute
    public void update(Product product) {
        em.merge(product); //обновляет или создает новую запись, если не найден id
    }

    @Override
    @TransactionAttribute
    public void delete(long id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
    }

    @Override
    @TransactionAttribute
    public Product findById(long id) {
        return em.find(Product.class, id);
    }

    @Override
    @TransactionAttribute
    public List<Product> findAll() {
        //JPQL
        return em.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    @TransactionAttribute
    public List<Product> findAllByCategoryId(Integer id) {
        return em.createQuery("from Product where category.id = :id").setParameter("id", id).getResultList();
    }



}

