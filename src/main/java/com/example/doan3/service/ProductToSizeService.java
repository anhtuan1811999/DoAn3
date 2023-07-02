package com.example.doan3.service;

import com.example.doan3.dto_request.DTOAddProduct;
import com.example.doan3.dto_request.DTOUpdateProduct;
import com.example.doan3.dto_response.DTOEditProduct;
import com.example.doan3.entity.Product;
import com.example.doan3.entity.ProductToSize;
import com.example.doan3.entity.Size;
import com.example.doan3.repository.ProductRepository;
import com.example.doan3.repository.ProductToSizeRepository;
import com.example.doan3.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductToSizeService {

    @Autowired
    private SizeRepository sizeRepository;

    @Autowired
    private ProductToSizeRepository productToSizeRepository;

    @Autowired
    private ProductRepository productRepository;

    public void mapProductToSize(DTOAddProduct dtoAddProduct, Product product) {
        Size size36 = sizeRepository.findSizeBySize(36);
        Size size37 = sizeRepository.findSizeBySize(37);
        Size size38 = sizeRepository.findSizeBySize(38);
        Size size39 = sizeRepository.findSizeBySize(39);
        Size size40 = sizeRepository.findSizeBySize(40);
        Size size41 = sizeRepository.findSizeBySize(41);
        Size size42 = sizeRepository.findSizeBySize(42);
        Size size43 = sizeRepository.findSizeBySize(43);

        if (dtoAddProduct.isSize36()) {
            int quantity = dtoAddProduct.getQuantity36();
            ProductToSize productToSize = new ProductToSize();
            productToSize.setSize(size36);
            productToSize.setProduct(product);
            productToSize.setQuantity(quantity);
            productToSize.setStatus(true);
            productToSizeRepository.save(productToSize);
        } else {
            ProductToSize productToSize = new ProductToSize();
            productToSize.setSize(size36);
            productToSize.setProduct(product);
            productToSize.setQuantity(0);
            productToSize.setStatus(true);
            productToSizeRepository.save(productToSize);
        }

        if (dtoAddProduct.isSize37()) {
            int quantity = dtoAddProduct.getQuantity37();
            ProductToSize productToSize = new ProductToSize();
            productToSize.setSize(size37);
            productToSize.setProduct(product);
            productToSize.setQuantity(quantity);
            productToSize.setStatus(true);
            productToSizeRepository.save(productToSize);
        } else {
            ProductToSize productToSize = new ProductToSize();
            productToSize.setSize(size37);
            productToSize.setProduct(product);
            productToSize.setQuantity(0);
            productToSize.setStatus(true);
            productToSizeRepository.save(productToSize);
        }

        if (dtoAddProduct.isSize38()) {
            int quantity = dtoAddProduct.getQuantity38();
            ProductToSize productToSize = new ProductToSize();
            productToSize.setSize(size38);
            productToSize.setProduct(product);
            productToSize.setQuantity(quantity);
            productToSize.setStatus(true);
            productToSizeRepository.save(productToSize);
        } else {
            ProductToSize productToSize = new ProductToSize();
            productToSize.setSize(size38);
            productToSize.setProduct(product);
            productToSize.setQuantity(0);
            productToSize.setStatus(true);
            productToSizeRepository.save(productToSize);
        }

        if (dtoAddProduct.isSize39()) {
            int quantity = dtoAddProduct.getQuantity39();
            ProductToSize productToSize = new ProductToSize();
            productToSize.setSize(size39);
            productToSize.setProduct(product);
            productToSize.setQuantity(quantity);
            productToSize.setStatus(true);
            productToSizeRepository.save(productToSize);
        } else {
            ProductToSize productToSize = new ProductToSize();
            productToSize.setSize(size39);
            productToSize.setProduct(product);
            productToSize.setQuantity(0);
            productToSize.setStatus(true);
            productToSizeRepository.save(productToSize);
        }

        if (dtoAddProduct.isSize40()) {
            int quantity = dtoAddProduct.getQuantity40();
            ProductToSize productToSize = new ProductToSize();
            productToSize.setSize(size40);
            productToSize.setProduct(product);
            productToSize.setQuantity(quantity);
            productToSize.setStatus(true);
            productToSizeRepository.save(productToSize);
        } else {
            ProductToSize productToSize = new ProductToSize();
            productToSize.setSize(size40);
            productToSize.setProduct(product);
            productToSize.setQuantity(0);
            productToSize.setStatus(true);
            productToSizeRepository.save(productToSize);
        }

        if (dtoAddProduct.isSize41()) {
            int quantity = dtoAddProduct.getQuantity41();
            ProductToSize productToSize = new ProductToSize();
            productToSize.setSize(size41);
            productToSize.setProduct(product);
            productToSize.setQuantity(quantity);
            productToSize.setStatus(true);
            productToSizeRepository.save(productToSize);
        } else {
            ProductToSize productToSize = new ProductToSize();
            productToSize.setSize(size41);
            productToSize.setProduct(product);
            productToSize.setQuantity(0);
            productToSize.setStatus(true);
            productToSizeRepository.save(productToSize);
        }

        if (dtoAddProduct.isSize42()) {
            int quantity = dtoAddProduct.getQuantity42();
            ProductToSize productToSize = new ProductToSize();
            productToSize.setSize(size42);
            productToSize.setProduct(product);
            productToSize.setQuantity(quantity);
            productToSize.setStatus(true);
            productToSizeRepository.save(productToSize);
        } else {
            ProductToSize productToSize = new ProductToSize();
            productToSize.setSize(size42);
            productToSize.setProduct(product);
            productToSize.setQuantity(0);
            productToSize.setStatus(true);
            productToSizeRepository.save(productToSize);
        }

        if (dtoAddProduct.isSize43()) {
            int quantity = dtoAddProduct.getQuantity43();
            ProductToSize productToSize = new ProductToSize();
            productToSize.setSize(size43);
            productToSize.setProduct(product);
            productToSize.setQuantity(quantity);
            productToSize.setStatus(true);
            productToSizeRepository.save(productToSize);
        } else {
            ProductToSize productToSize = new ProductToSize();
            productToSize.setSize(size43);
            productToSize.setProduct(product);
            productToSize.setQuantity(0);
            productToSize.setStatus(true);
            productToSizeRepository.save(productToSize);
        }
    }

    public void updateQuantity(DTOUpdateProduct dtoUpdateProduct) {
        Optional<Product> product = productRepository.findById(Long.valueOf(dtoUpdateProduct.getId()));
        List<ProductToSize> productToSizeList = productToSizeRepository.findProductToSizeByProductAndStatus(product.get(), true);

        if (!dtoUpdateProduct.getSize36().equals("")) {
            ProductToSize productToSize36 = productToSizeRepository.findById(productToSizeList.get(0).getId()).get();
            int quantityAfterChange = productToSizeList.get(0).getQuantity() + Integer.valueOf(dtoUpdateProduct.getSize36());
            if (quantityAfterChange < 0) {
                quantityAfterChange = 0;
            }
            productToSize36.setQuantity(quantityAfterChange);
            productToSizeRepository.save(productToSize36);
        }
        if (!dtoUpdateProduct.getSize37().equals("")) {
            ProductToSize productToSize37 = productToSizeRepository.findById(productToSizeList.get(1).getId()).get();
            int quantityAfterChange = productToSizeList.get(1).getQuantity() + Integer.valueOf(dtoUpdateProduct.getSize37());
            if (quantityAfterChange < 0) {
                quantityAfterChange = 0;
            }
            productToSize37.setQuantity(quantityAfterChange);
            productToSizeRepository.save(productToSize37);
        }
        if (!dtoUpdateProduct.getSize38().equals("")) {
            ProductToSize productToSize38 = productToSizeRepository.findById(productToSizeList.get(2).getId()).get();
            int quantityAfterChange = productToSizeList.get(2).getQuantity() + Integer.valueOf(dtoUpdateProduct.getSize38());
            if (quantityAfterChange < 0) {
                quantityAfterChange = 0;
            }
            productToSize38.setQuantity(quantityAfterChange);
            productToSizeRepository.save(productToSize38);
        }
        if (!dtoUpdateProduct.getSize39().equals("")) {
            ProductToSize productToSize39 = productToSizeRepository.findById(productToSizeList.get(3).getId()).get();
            int quantityAfterChange = productToSizeList.get(3).getQuantity() + Integer.valueOf(dtoUpdateProduct.getSize39());
            if (quantityAfterChange < 0) {
                quantityAfterChange = 0;
            }
            productToSize39.setQuantity(quantityAfterChange);
            productToSizeRepository.save(productToSize39);
        }
        if (!dtoUpdateProduct.getSize40().equals("")) {
            ProductToSize productToSize40 = productToSizeRepository.findById(productToSizeList.get(4).getId()).get();
            int quantityAfterChange = productToSizeList.get(4).getQuantity() + Integer.valueOf(dtoUpdateProduct.getSize40());
            if (quantityAfterChange < 0) {
                quantityAfterChange = 0;
            }
            productToSize40.setQuantity(quantityAfterChange);
            productToSizeRepository.save(productToSize40);
        }
        if (!dtoUpdateProduct.getSize41().equals("")) {
            ProductToSize productToSize41 = productToSizeRepository.findById(productToSizeList.get(5).getId()).get();
            int quantityAfterChange = productToSizeList.get(5).getQuantity() + Integer.valueOf(dtoUpdateProduct.getSize41());
            if (quantityAfterChange < 0) {
                quantityAfterChange = 0;
            }
            productToSize41.setQuantity(quantityAfterChange);
            productToSizeRepository.save(productToSize41);
        }
        if (!dtoUpdateProduct.getSize42().equals("")) {
            ProductToSize productToSize42 = productToSizeRepository.findById(productToSizeList.get(6).getId()).get();
            int quantityAfterChange = productToSizeList.get(6).getQuantity() + Integer.valueOf(dtoUpdateProduct.getSize42());
            if (quantityAfterChange < 0) {
                quantityAfterChange = 0;
            }
            productToSize42.setQuantity(quantityAfterChange);
            productToSizeRepository.save(productToSize42);
        }
        if (!dtoUpdateProduct.getSize43().equals("")) {
            ProductToSize productToSize43 = productToSizeRepository.findById(productToSizeList.get(7).getId()).get();
            int quantityAfterChange = productToSizeList.get(7).getQuantity() + Integer.valueOf(dtoUpdateProduct.getSize43());
            if (quantityAfterChange < 0) {
                quantityAfterChange = 0;
            }
            productToSize43.setQuantity(quantityAfterChange);
            productToSizeRepository.save(productToSize43);
        }
    }
}
