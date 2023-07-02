package com.example.doan3.repository;

import com.example.doan3.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByStatus(boolean status);
}
