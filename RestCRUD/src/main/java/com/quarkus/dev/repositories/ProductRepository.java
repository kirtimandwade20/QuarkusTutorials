package com.quarkus.dev.repositories;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.quarkus.dev.entities.Product;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

    public List<Product> findByName(String name) {
        return find("name", name).list();
    }

}
