package com.example.doan3.controller;

import com.example.doan3.dto_request.DTOAddProduct;
import com.example.doan3.dto_request.DTOItem;
import com.example.doan3.dto_request.DTOUpdateProduct;
import com.example.doan3.entity.Product;
import com.example.doan3.entity.ProductToSize;
import com.example.doan3.repository.ProductRepository;
import com.example.doan3.repository.ProductToSizeRepository;
import com.example.doan3.service.ProductService;
import com.example.doan3.service.ProductToSizeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductToSizeRepository productToSizeRepository;

    @Autowired
    private ProductToSizeService productToSizeService;

    @Autowired
    private ProductService productService;

    @GetMapping("home-page")
    public String homePage(Model model, HttpSession session, HttpServletRequest request){
        List<DTOItem> itemList = (List<DTOItem>) request.getSession().getAttribute("cart");
        if (itemList == null){
            itemList = new ArrayList<>();
            request.getSession().setAttribute("cart", itemList);
        }
        List<Product> productList = productRepository.findAllByStatus(true);
        model.addAttribute("productList",productList);
        return "home-page";
    }

    @GetMapping("add-product")
    public String addProduct(Model model){
        DTOAddProduct dtoAddProduct = new DTOAddProduct();
        model.addAttribute("dtoAddProduct", dtoAddProduct);
        return "add-product";
    }

    @PostMapping("add-product")
    public String receiveProduct(@ModelAttribute("dtoAddProduct") DTOAddProduct dtoProduct, @RequestParam("file")MultipartFile file) throws IOException {
        Product product = new Product();
        product.setName(dtoProduct.getName());
        product.setPrice(dtoProduct.getPrice());
        product.setOriginalPrice(dtoProduct.getOriginalPrice());
        product.setDescription(dtoProduct.getDescription());
        product.setStatus(true);
        product.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        productRepository.save(product);

        productToSizeService.mapProductToSize(dtoProduct, productRepository.save(product));
        return "add-product";
    }

    @GetMapping("edit-product")
    public String editProduct(Model model){
        List<Product> productList = productRepository.findAllByStatus(true);
        List<ProductToSize> productToSizeList = productToSizeRepository.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("productToSizeRepository", productToSizeRepository);
        return "edit-product";
    }

    @GetMapping("edit-product/delete/{id}")
    public RedirectView deleteProduct(@PathVariable("id") long id){

        Optional<Product> productOptional = productRepository.findById(id);
        Product product = productOptional.get();
        product.setStatus(false);
        productRepository.save(product);

        var redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/edit-product");
        return redirectView;
    }

    @GetMapping("edit-product/edit-information/{id}")
    public String editProduct(@PathVariable("id") long id, Model model){
        Product product = productRepository.findById(id).get();
        model.addAttribute("dtoUpdateProduct", new DTOUpdateProduct());
        model.addAttribute("product", product);
        model.addAttribute("productToSizeRepository", productToSizeRepository);
        return "detail-product";
    }

    @PostMapping("edit-information")
    public ResponseEntity handleProductInformation(DTOUpdateProduct dtoUpdateProduct){
        productToSizeService.updateQuantity(dtoUpdateProduct);
        productService.updateProduct(dtoUpdateProduct);
        productService.updateImageProduct(dtoUpdateProduct);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("detail-product-customer/{id}")
    public String detailProductCustomer(@PathVariable("id") int id ,HttpServletRequest request, HttpSession session, Model model){
        var product = productRepository.findByIdAndStatus(id, true);
        var sizes = productToSizeRepository.findProductToSizeByProductAndStatus(product, true);
        model.addAttribute("product",product);
        model.addAttribute("sizes",sizes);
        return "detail-product-customer";
    }


    @PostMapping("detail-product-customer")
    public String detailProductCustomerSubmit(HttpServletRequest request, HttpSession session, Model model){
        System.out.println("inside");
        System.out.println(request.getParameter("sizeInput"));

        return "redirect:/home-page";
    }
}