package com.example.doan3.service;

import com.example.doan3.dto_request.DTOUpdateProduct;
import com.example.doan3.entity.Product;
import com.example.doan3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void updateProduct(DTOUpdateProduct dtoUpdateProduct){
        Product product = productRepository.findById(Long.valueOf(dtoUpdateProduct.getId())).get();
        if (!product.getName().equals(dtoUpdateProduct.getName())){
            product.setName(dtoUpdateProduct.getName());
        }
        if (!product.getPrice().equals(dtoUpdateProduct.getPrice())){
            product.setPrice(dtoUpdateProduct.getPrice());
        }
        if (!product.getOriginalPrice().equals(dtoUpdateProduct.getOriginalPrice())){
            product.setOriginalPrice(dtoUpdateProduct.getOriginalPrice());
        }
        if (!product.getDescription().equals(dtoUpdateProduct)){
            product.setDescription(dtoUpdateProduct.getDescription());
        }
        productRepository.save(product);
    }

    public void updateImageProduct(DTOUpdateProduct dtoUpdateProduct){
        Product product = productRepository.findById(Long.valueOf(dtoUpdateProduct.getId())).get();
        if (dtoUpdateProduct.getImage().charAt(21)==','){
            product.setImage(dtoUpdateProduct.getImage().substring(22));
            productRepository.save(product);
        } else if (dtoUpdateProduct.getImage().charAt(22)==','){
            product.setImage(dtoUpdateProduct.getImage().substring(23));
            productRepository.save(product);
        }
    }
}
