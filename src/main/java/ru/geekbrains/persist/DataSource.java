package ru.geekbrains.persist;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@ApplicationScoped //скоуп в атрибутах приложения
@Named //для создания бина
public class DataSource {

    @Inject
    private ServletContext ctx;

    private Connection connection;

    @PostConstruct //после создания бина
    public void init() throws SQLException {
        String jdbcConnectionString = ctx.getInitParameter("jdbcConnectionString");
        String dbUsername = ctx.getInitParameter("dbUsername");
        String dbPassword = ctx.getInitParameter("dbPassword");

        connection = DriverManager.getConnection(jdbcConnectionString, dbUsername, dbPassword);
    }

    public Connection getConnection() {
        return connection;
    }
}
