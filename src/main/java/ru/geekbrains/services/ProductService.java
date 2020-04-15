package ru.geekbrains.services;

import ru.geekbrains.persist.entities.Product;
import ru.geekbrains.persist.repositories.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named
@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    @Transactional
    public void insert(Product product){
        productRepository.insert(product);
    }

    @Transactional
    public void update(Product product){
        productRepository.update(product);
    }

    @Transactional
    public Product findById(long id){
        return productRepository.findById(id);
    }

    @Transactional
    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public void delete(Long id) {
        productRepository.delete(id);
    }
}
