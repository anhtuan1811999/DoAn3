package com.example.doan3.repository;

import com.example.doan3.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {
    Size findSizeBySize(int size);
}
