package com.walmartapi.controller;

import com.walmartapi.model.Product;
import com.walmartapi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        Product foundProduct = productService.getProductbyId(id);
        return ResponseEntity.ok(foundProduct);

    }

    @PostMapping

    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        System.out.println("hola "+product.getName());
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

}
