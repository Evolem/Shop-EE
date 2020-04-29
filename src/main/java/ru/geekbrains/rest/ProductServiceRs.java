package ru.geekbrains.rest;

import ru.geekbrains.pojo.ProductPojo;

import javax.ejb.Local;
import javax.faces.push.Push;
import javax.jws.WebMethod;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/v1/product")
public interface ProductServiceRs {

    @PUT
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    void insertProduct(ProductPojo productPojo);

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    void update(ProductPojo productPojo);

    @GET
    @Path("/{id}/id")
    @Produces(MediaType.APPLICATION_JSON)
    ProductPojo findById(@PathParam("id") long id);

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductPojo> findAll();

    @GET
    @Path("/byCategoryId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductPojo> findAllByCategoryId(@PathParam("id") Integer id);

    @POST
    @Path("/delete")
    void delete(Long id);

    ProductPojo findProductByName(String name);
}
