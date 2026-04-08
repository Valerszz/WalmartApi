package com.walmartapi.service;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.model.Product;
import com.walmartapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService  {

    private final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product saveProduct(Product product) {

        //MAPPEO agarrar los valores de uno y ponerlos en otro
        ProductEntity productEntity = new ProductEntity();
        productEntity.setDescription(product.getDescription());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        // --> no se pone id por que la base de datos se encarga de ello

        ProductEntity savedEntity = productRepository.save(productEntity);

        product.setName(savedEntity.getName());
        product.setId(savedEntity.getId());
        product.setPrice(savedEntity.getPrice());
        product.setDescription(savedEntity.getDescription());

        // map POJO to entity
        // Call DB
        // map entity to POJO

        return product;
    }

}
