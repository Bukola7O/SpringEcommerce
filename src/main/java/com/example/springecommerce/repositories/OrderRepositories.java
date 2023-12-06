package com.example.springecommerce.repositories;

import com.example.springecommerce.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositories extends JpaRepository<Order, Long> {
}
