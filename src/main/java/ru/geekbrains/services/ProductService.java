package ru.geekbrains.services;

import ru.geekbrains.persist.entities.Category;
import ru.geekbrains.persist.entities.Product;
import ru.geekbrains.persist.repositories.CategoryRepository;
import ru.geekbrains.persist.repositories.ProductRepository;
import ru.geekbrains.persist.repositories.ejbRepositories.ProductRepo;
import ru.geekbrains.pojo.ProductPojo;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ApplicationScoped
public class ProductService {

    @EJB
    ProductRepo productRepository;

    @Inject
    CategoryRepository categoryRepository;

    @Transactional
    public void insert(ProductPojo productPojo){
        Category category = categoryRepository.findCategoryById(productPojo.getCategory_id());
        Product product = new Product();

        product.setName(productPojo.getName());
        product.setDescription(productPojo.getDescription());
        product.setPrice(productPojo.getPrice());
        product.setCategory(category);

        productRepository.insert(product);
    }

    @Transactional
    public void update(ProductPojo productPojo){
        Category category = categoryRepository.findCategoryById(productPojo.getCategory_id());
        Product product = productRepository.findById(productPojo.getId());

        product.setName(productPojo.getName());
        product.setPrice(productPojo.getPrice());
        product.setDescription(productPojo.getDescription());
        product.setCategory(category);

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

    public List<ProductPojo> findAllByCategoryId(Integer id){
       return productRepository.findAllByCategoryId(id)
               .stream()
               .map(ProductPojo::new)
               .collect(Collectors.toList());
    }

    public void delete(Long id) {
        productRepository.delete(id);
    }
}
