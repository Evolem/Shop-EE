package ru.geekbrains.controllers;

import ru.geekbrains.persist.Category;
import ru.geekbrains.persist.repositories.CategoryRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class CategoryController implements Serializable {

    @Inject
    private CategoryRepository categoryRepository;
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getAllCategory() throws SQLException {
        return categoryRepository.getAllCategory();
    }

    public String create(){
        this.category = new Category();
        return "/category_edit.xhtml?faces-redirect=true";
    }


    public String edit(Category category){
        this.category = category;
        return "/category_edit.xhtml?faces-redirect=true";
    }

    public String save() throws SQLException {
        if (category.getId() == null) {
            categoryRepository.insert(category);
        } else {
            categoryRepository.update(category);
        }
        return "/category_all.xhtml?faces-redirect=true";
    }

    public void delete(Category category) throws SQLException {
        categoryRepository.delete(category.getId());
    }
}
