package com.walmartapi.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
//representacion de una tabla en una base de datos

@Table(name="products")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;

}
