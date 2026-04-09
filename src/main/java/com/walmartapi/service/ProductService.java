package com.walmartapi.service;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.exception.NotFound;
import com.walmartapi.mapper.CustomObjectMapper;
import com.walmartapi.mapper.impl.ProductMapper;
import com.walmartapi.model.Product;
import com.walmartapi.repository.ProductRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService  {

    private final ProductRepository productRepository;
    private final CustomObjectMapper <ProductEntity,Product> productMapper;

    public ProductService(ProductRepository productRepository, CustomObjectMapper <ProductEntity,Product> productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product saveProduct(Product product) {

        ProductEntity newProduct = productMapper.mapToEntity(product);
        ProductEntity savedEntity = productRepository.save(newProduct);

        // map POJO to entity
        // Call DB
        // map entity to POJO

        System.out.println(savedEntity.getId());
        return productMapper.mapToDTO(savedEntity);
    }

    public Product getProductbyId(Long id){
        Optional<ProductEntity> product = productRepository.findById(id);

        //reduce el numero de null pointer exceptions
        if (product.isEmpty()){
            throw new NotFound("Product Not Found");
        }

        return productMapper.mapToDTO(product.get());
    }

}

//hacer update y delete
//para update checar que exista primero
//llamar get by id y si regresa un producto entonces si existe si no arrojar exception
// hay que llamar al metodo save, si ya existe uno hay que actualizarlo sino entonces los guarda el metodo de save