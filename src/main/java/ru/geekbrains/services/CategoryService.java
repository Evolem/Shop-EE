package ru.geekbrains.services;

import ru.geekbrains.persist.entities.Category;
import ru.geekbrains.persist.repositories.CategoryRepository;
import ru.geekbrains.persist.repositories.ejbRepositories.CategoryRepo;
import ru.geekbrains.pojo.CategoryPojo;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Named
@ApplicationScoped
//@WebService(endpointInterface = "ru.geekbrains.services.CategoryServiceWs", serviceName = "CategoryService")
public class CategoryService implements CategoryServiceWs {

    @EJB
    CategoryRepo categoryRepository;

    @Transactional
    public List<CategoryPojo> findAll() {
      return categoryRepository.findAll().stream()
              .map(CategoryPojo::new)
              .collect(Collectors.toList());
    }

    @Transactional
    public void insertCategory(CategoryPojo categoryPojo){
        categoryRepository.insert(categoryPojo.createCategory());
    }

    @Transactional
    public void update(CategoryPojo categoryPojo){
        Category category = categoryRepository.findCategoryById(categoryPojo.getId());
        category.setName(categoryPojo.getName());
        categoryRepository.update(category);
    }

    @Transactional
    public CategoryPojo findCategoryById(int id){
      return new CategoryPojo(categoryRepository.findCategoryById(id));
    }

    @Transactional
    public void delete(Integer id) {
        categoryRepository.delete(id);
    }
}
