package ru.geekbrains.persist.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "shop_orders")
@NamedQueries({
        @NamedQuery (name = "Order.findAllOrder" , query = "SELECT o from Order o"),
        @NamedQuery (name = "Order.findOrderById" , query = "SELECT o from Order o WHERE  o.id = :id")
})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String description;

    @Column
    private BigDecimal price;

    @OneToMany(mappedBy = "order")
    private List<Purchase> purchases;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }
}
