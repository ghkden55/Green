package com.example.product.product;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProductRequest {

    @Data
    public static class SaveDTO {

        private Long productId;

        private String productName;

        private Long productQuantity;

        private Long productPrice;

        private String productImage;

        private String productInfo;

        public Product toEntity() {
            return Product.builder()
                    .productName(productName)
                    .productQuantity(productQuantity)
                    .productPrice(productPrice)
                    .productImage(productImage)
                    .productInfo(productInfo)
                    .build();
        }

    }

}
