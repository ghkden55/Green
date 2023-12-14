package com.example.product.product;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Long productQuantity;

    @Column(nullable = false)
    private Long productPrice;

    @Column(nullable = false)
    private String productImage;

    @Column
    private String productInfo;

    @Builder
    public Product(Long productId, String productName, Long productQuantity, Long productPrice, String productImage, String productInfo) {
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productInfo = productInfo;
    }
}
