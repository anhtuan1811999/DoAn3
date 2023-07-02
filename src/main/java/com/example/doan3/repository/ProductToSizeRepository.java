package com.example.doan3.repository;

import com.example.doan3.entity.Product;
import com.example.doan3.entity.ProductToSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductToSizeRepository extends JpaRepository<ProductToSize, Long> {
    List<ProductToSize> findProductToSizeByProductAndStatus(Product product, boolean status);
}
