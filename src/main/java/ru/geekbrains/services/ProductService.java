package ru.geekbrains.services;

import ru.geekbrains.persist.entities.Product;
import ru.geekbrains.persist.repositories.ProductRepository;
import ru.geekbrains.pojo.ProductPojo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    @Transactional
    public void insert(ProductPojo productPojo){
        Product product = productPojo.createProduct();
        productRepository.insert(product);
    }

    @Transactional
    public void update(ProductPojo productPojo){
        Product product = productPojo.createProduct();
        productRepository.update(product);
    }

    @Transactional
    public ProductPojo findById(long id){
        return new ProductPojo(productRepository.findById(id));
    }

    @Transactional
    public List<ProductPojo> findAll(){
        return productRepository.findAll().stream()
                .map(ProductPojo::new)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        productRepository.delete(id);
    }
}
