package ru.geekbrains.persist.repositories.ejbRepositories;

import ru.geekbrains.persist.entities.Product;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductRepo {

     void insert(Product product);

     void update(Product product) ;

     void delete(long id) ;

     Product findById(long id) ;

     List<Product> findAll() ;

     List<Product> findAllByCategoryId(Integer id);

     Product findProductByName(String name);
}
