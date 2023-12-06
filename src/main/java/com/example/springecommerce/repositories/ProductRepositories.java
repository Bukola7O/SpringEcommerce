package com.example.springecommerce.repositories;

import com.example.springecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface ProductRepositories extends JpaRepository<Product, Long> {
    List<Product> findByCategories(String categories);

}
