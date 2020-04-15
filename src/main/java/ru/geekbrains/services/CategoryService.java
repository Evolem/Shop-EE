package ru.geekbrains.services;

import ru.geekbrains.persist.entities.Category;
import ru.geekbrains.persist.repositories.CategoryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;


@Named
@ApplicationScoped
public class CategoryService {

    @Inject
    CategoryRepository categoryRepository;

    @Transactional
    public List<Category> findAll() {
      return categoryRepository.findAll();
    }

    @Transactional
    public void insert(Category category){
        categoryRepository.insert(category);
    }

    @Transactional
    public void update(Category category){
        categoryRepository.update(category);
    }

    @Transactional
    public Category findCategoryById(int category_id){
      return categoryRepository.findCategoryById(category_id);
    }

    @Transactional
    public void delete(Integer id) {
        categoryRepository.delete(id);
    }
}
