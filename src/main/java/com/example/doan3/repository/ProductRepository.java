package com.example.doan3.repository;

import com.example.doan3.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByStatus(boolean status);

    Product findByIdAndStatus(int id, boolean status);
}
