package ru.geekbrains.persist;

import javax.validation.constraints.Size;



public class Category {

    private Integer id;

    @Size(min = 4 , max = 30 ,message = " Поле должно содержать от 4 до 30 символов")
    private String name;

    public Category() {
    }
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
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
