package ru.geekbrains.persist.repositories;

import ru.geekbrains.persist.Category;
import ru.geekbrains.persist.util.DataSource;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named
public class CategoryRepository {

    private Connection conn;

    @Inject
    DataSource dataSource;

    @PostConstruct
    public void init(){
        conn = dataSource.getConnection();
    }

    public List<Category> getAllCategory() throws SQLException {
        List<Category> categories = new ArrayList<>();
        try(Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery("select * from categories");

            while (rs.next()){
                categories.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        }
        return categories;
    }

    public void insert(Category category) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into categories(`name`) values (?);")) {
            stmt.setString(1, category.getName());
            stmt.execute();
        }
    }

    public void update(Category category) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "update categories set `name` = ? where `id` = ?;")) {
            stmt.setString(1, category.getName());
            stmt.setLong(2, category.getId());
            stmt.execute();
        }
    }

    public void delete(long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
                "delete from categories where id = ?;")) {
            stmt.setLong(1, id);
            stmt.execute();
        }
    }

}
