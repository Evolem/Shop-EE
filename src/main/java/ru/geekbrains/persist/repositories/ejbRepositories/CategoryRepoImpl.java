package ru.geekbrains.persist.repositories.ejbRepositories;

import ru.geekbrains.persist.entities.Category;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class CategoryRepoImpl implements CategoryRepo {

    @PersistenceContext(unitName = "ds")
    EntityManager em;

    @Override
    @TransactionAttribute
    public List<Category> findAll() {
        return em.createQuery("from Category ", Category.class).getResultList();
    }

    @Override
    @TransactionAttribute
    public void insert(Category category) {
        em.persist(category);
    }

    @Override
    @TransactionAttribute
    public void delete(Integer id) {
        Category category = em.find(Category.class, id);
        em.remove(category);
    }

    @Override
    @TransactionAttribute
    public void update(Category category) {
        em.merge(category);
    }

    @Override
    @TransactionAttribute
    public Category findCategoryById(int category) {
        return em.find(Category.class, category);
    }
}
