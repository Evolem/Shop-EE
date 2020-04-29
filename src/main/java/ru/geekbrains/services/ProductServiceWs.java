package ru.geekbrains.services;

import ru.geekbrains.persist.entities.Product;
import ru.geekbrains.pojo.ProductPojo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProductServiceWs {

    @WebMethod
    void insertProduct(ProductPojo productPojo);

    @WebMethod
    void update(ProductPojo productPojo);

    @WebMethod
    ProductPojo findById(long id);

    @WebMethod
    List<ProductPojo> findAll();

    @WebMethod
    List<ProductPojo> findAllByCategoryId(Integer id);

    @WebMethod
    void delete(Long id);

    @WebMethod
    ProductPojo findProductByName(String name);
}
