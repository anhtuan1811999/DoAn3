package com.example.doan3.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductToSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Size size;
    private Integer quantity;
    private boolean status;
}