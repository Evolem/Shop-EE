package ru.geekbrains.persist;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named
public class CategoryRepository {

    @Inject
    DataSource dataSource;
}
