package ru.geekbrains.services;

import ru.geekbrains.persist.entities.Category;
import ru.geekbrains.persist.repositories.CategoryRepository;
import ru.geekbrains.services.pojo.CategoryPojo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Named
@ApplicationScoped
public class CategoryService {

    @Inject
    CategoryRepository categoryRepository;

    @Transactional
    public List<CategoryPojo> findAll() {
      return categoryRepository.findAll().stream()
              .map(CategoryPojo::new)
              .collect(Collectors.toList());
    }

    @Transactional
    public void insert(CategoryPojo categoryPojo){
        categoryRepository.insert(categoryPojo.createCategory());
    }

    @Transactional
    public void update(CategoryPojo categoryPojo){
        Category category = categoryRepository.findCategoryById(categoryPojo.getId());
        category.setName(categoryPojo.getName());
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
