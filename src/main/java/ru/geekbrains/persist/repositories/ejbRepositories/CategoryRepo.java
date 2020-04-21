package ru.geekbrains.persist.repositories.ejbRepositories;

import ru.geekbrains.persist.entities.Category;

import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Local
public interface CategoryRepo {
    List<Category> findAll();

    void insert(Category category);

    void delete(Integer id);

    void update(Category category);

    Category findCategoryById(int category);
}
