package ru.geekbrains.persist.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Table(name = "categories")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @OneToMany(
            mappedBy = "category", //сущность по которой идет связь
            cascade = CascadeType.ALL,
            orphanRemoval = true //продукт без категории будет удален
    )
    private List<Product> products;

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

    public List<Product> getProducts() {
        return products;
    }

}
