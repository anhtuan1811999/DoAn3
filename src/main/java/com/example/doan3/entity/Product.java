package com.example.doan3.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    private String originalPrice;
    @Column(length = 2048)
    private String description;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;
    private boolean status;


}
