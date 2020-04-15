package ru.geekbrains.services.pojo;

import ru.geekbrains.persist.entities.Category;

import javax.validation.constraints.Size;

public class CategoryPojo {
    private Integer id;

    @Size(min = 4, max = 30, message = " Поле должно содержать от 4 до 30 символов")
    private String name;

    public CategoryPojo() {
    }

    public CategoryPojo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryPojo(Category category) {
        this(category.getId(), category.getName());
    }

    public Category createCategory(){
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        return category;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
