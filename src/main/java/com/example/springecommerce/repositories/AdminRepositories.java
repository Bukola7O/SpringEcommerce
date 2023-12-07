package com.example.springecommerce.repositories;

import com.example.springecommerce.models.Admin;
import com.example.springecommerce.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepositories extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUsername(String username);
}
