package ru.geekbrains.services;

import ru.geekbrains.persist.entities.Category;
import ru.geekbrains.persist.entities.Product;
import ru.geekbrains.persist.repositories.CategoryRepository;
import ru.geekbrains.persist.repositories.ProductRepository;
import ru.geekbrains.persist.repositories.ejbRepositories.ProductRepo;
import ru.geekbrains.pojo.ProductPojo;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebService;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@WebService(endpointInterface = "ru.geekbrains.services.ProductServiceWs", serviceName = "ProductService")
public class ProductService implements ProductServiceWs {

    @EJB
    ProductRepo productRepository;

    @Inject
    CategoryRepository categoryRepository;

    @Transactional
    @Override
    public void insertProduct(ProductPojo productPojo){
        Category category = categoryRepository.findCategoryById(productPojo.getCategory_id());
        Product product = new Product();

        product.setName(productPojo.getName());
        product.setDescription(productPojo.getDescription());
        product.setPrice(productPojo.getPrice());
        product.setCategory(category);

        productRepository.insert(product);
    }

    @Transactional
    @Override
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
    @Override
    public ProductPojo findById(long id){
        return new ProductPojo(productRepository.findById(id));
    }

    @Transactional
    @Override
    public List<ProductPojo> findAll(){
        return productRepository.findAll().stream()
                .map(ProductPojo::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductPojo> findAllByCategoryId(Integer id){
       return productRepository.findAllByCategoryId(id)
               .stream()
               .map(ProductPojo::new)
               .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    @Transactional
    public ProductPojo findProductByName(String name) {
        return new ProductPojo(productRepository.findProductByName(name));
    }
}
