package ru.geekbrains.services;

import ru.geekbrains.pojo.CategoryPojo;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CategoryServiceWs {

    @WebMethod
    void insertCategory(CategoryPojo categoryPojo);
    @WebMethod
    CategoryPojo findCategoryById(int id);
}
