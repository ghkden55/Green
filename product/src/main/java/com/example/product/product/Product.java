package com.example.product.product;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Product {

    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 상품명, 입력 값 필수
    @Column(length = 100, nullable = false)
    private String productName;

    // 상품 설명, 입력 값 필수
    @Column(length = 500, nullable = false)
    private String description;

    // 이미지 정보
    @Column(length = 100)
    private String image;

    // 가격
    private int price;

    // 수량
    //private int quantity;


    public void update(ProductResponse.FindAllDTO updateDTO){
        this.productName = updateDTO.getProductName();
        this.description = updateDTO.getDescription();
        this.image = updateDTO.getImage();
        this.price = updateDTO.getPrice();
    }


}
