package ru.geekbrains.persist.repositories;

import ru.geekbrains.persist.entities.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Named
public class CategoryRepository {

    @PersistenceContext(unitName = "ds")
    EntityManager em;

    public List<Category> findAll() {
        return em.createQuery("from Category ", Category.class).getResultList();
    }

    @Transactional
    public void insert(Category category) {
        em.persist(category);
    }

    @Transactional
    public void delete(Integer id) {
        Category category = em.find(Category.class, id);
        em.remove(category);
    }

    @Transactional
    public void update(Category category) {
        em.merge(category);
    }

    public Category findCategoryById(int category) {
        return em.find(Category.class, category);
    }
}
