package ru.geekbrains.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.services.CategoryService;
import ru.geekbrains.pojo.CategoryPojo;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class CategoryController implements Serializable {

    Logger logger = LoggerFactory.getLogger("Category Controller");

    @Inject
    private CategoryService categoryService;

    private CategoryPojo categoryPojo;

    public CategoryPojo getCategoryPojo() {
        return categoryPojo;
    }

    public void setCategoryPojo(CategoryPojo categoryPojo) {
        this.categoryPojo = categoryPojo;
    }


    public List<CategoryPojo> getAllCategory() {
        return categoryService.findAll();
    }

    public String create() {
        this.categoryPojo = new CategoryPojo();
        return "/category_edit.xhtml?faces-redirect=true";
    }


    public String edit(CategoryPojo categoryPojo) {
        this.categoryPojo = categoryPojo;
        return "/category_edit.xhtml?faces-redirect=true";
    }

    public String save() {
        if (categoryPojo.getId() == null) {
            logger.warn("ID = NULL, CREATE ENTRY");
            categoryService.insert(categoryPojo);
        } else {
            logger.warn("ID =" + categoryPojo.getId() + ", UPDATE ENTRY");
            categoryService.update(categoryPojo);
        }
        return "/category_all.xhtml?faces-redirect=true";
    }

    public void delete(CategoryPojo categoryPojo) {
        categoryService.delete(categoryPojo.getId());
    }
}
