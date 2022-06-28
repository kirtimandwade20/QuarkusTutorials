package com.quarkus.dev.resource;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.QueryParam;

import com.quarkus.dev.entities.Product;
import com.quarkus.dev.repositories.ProductRepository;
@Path("/product")
public class ProductResource {


    ProductRepository productRepository;

    public ProductResource(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> products() {
        return Product.listAll();
    }

    @GET
    @Path("/find")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> products(@QueryParam("name") String name) {
        if (name != null) {
            return productRepository.findByName(name);
        }
        return Collections.emptyList() ;
      }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response newFruit(Product product) {
        product.id = null;
        product.persist();
        return Response.status(Status.CREATED).entity(product).build();
    }

}
