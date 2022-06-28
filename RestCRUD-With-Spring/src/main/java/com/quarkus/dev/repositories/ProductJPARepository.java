package com.quarkus.dev.repositories;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quarkus.dev.entities.Product;


@ApplicationScoped
public interface ProductJPARepository extends JpaRepository<Product,Long> {

    public List<Product> findByName(String name) ;
}
